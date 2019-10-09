package org.leyi.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.leyi.gmall.base.BasePage;
import org.leyi.gmall.cms.entity.PrefrenceAreaProductRelation;
import org.leyi.gmall.cms.entity.SubjectProductRelation;
import org.leyi.gmall.cms.service.IPrefrenceAreaProductRelationService;
import org.leyi.gmall.cms.service.ISubjectProductRelationService;
import org.leyi.gmall.constant.ProductStatusConstant;
import org.leyi.gmall.pms.entity.*;
import org.leyi.gmall.pms.mapper.ProductMapper;
import org.leyi.gmall.pms.service.*;
import org.leyi.gmall.pms.vo.PmsProductPlusVo;
import org.leyi.gmall.pms.vo.PmsProductQuery;
import org.leyi.gmall.util.LeyiUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Override
    public BasePage listByCondition(PmsProductQuery productQuery, Long current, Long size) {

        LambdaQueryWrapper<Product> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Product::getDeleteStatus, 0);

        Optional.ofNullable(productQuery.getPublishStatus())
                .ifPresent(publishStatus -> lambdaQueryWrapper.eq(Product::getPublishStatus, publishStatus));
        Optional.ofNullable(productQuery.getVerifyStatus())
                .ifPresent(verifyStatus -> lambdaQueryWrapper.eq(Product::getVerifyStatus, verifyStatus));
        Optional.ofNullable(productQuery.getProductCategoryId())
                .ifPresent(productCategoryId -> lambdaQueryWrapper.eq(Product::getProductCategoryId, productCategoryId));
        Optional.ofNullable(productQuery.getBrandId())
                .ifPresent(brandId -> lambdaQueryWrapper.eq(Product::getBrandId, brandId));

        final String keywords = productQuery.getKeyword();
        final boolean keywordsIsNotEmpty = StringUtils.isNotEmpty(keywords);
        lambdaQueryWrapper.like(keywordsIsNotEmpty, Product::getName, keywords);
        String productSn = productQuery.getProductSn();
        lambdaQueryWrapper.likeRight(StringUtils.isNotEmpty(productSn), Product::getProductSn, productSn);

        return new BasePage<Product>(baseMapper.selectPage(new Page(current, size), lambdaQueryWrapper));
    }

    @Override
    public boolean updateBatchProductStatus(String ids, Integer publishStatus, String productStatusType) {

        SFunction<Product, ?> column = Product::getPublishStatus; // 假设默认是修改商品状态
        switch (productStatusType) {
            case ProductStatusConstant.DELETE_STATUS:
                column = Product::getDeleteStatus;
                break;
            case ProductStatusConstant.NEW_STATUS:
                column = Product::getNewStatus;
                break;
            case ProductStatusConstant.RECOMMAND_STATUS:
                column = Product::getRecommandStatus;
                break;
            case ProductStatusConstant.VERIFY_STATUS:
                column = Product::getVerifyStatus;
                break;
        }
        return this.update(new LambdaUpdateWrapper<Product>()
                .in(StringUtils.isNotEmpty(ids), Product::getId, Lists.newArrayList(ids.split(",")))
                .set(column, publishStatus));
    }

    @Autowired
    private IProductAttributeValueService productAttributeValueService;
    @Autowired
    private IMemberPriceService memberPriceService;
    @Autowired
    private IProductLadderService productLadderService;
    @Autowired
    private IProductFullReductionService productFullReductionService;
    @Reference
    private ISubjectProductRelationService subjectProductRelationService;
    @Reference
    private IPrefrenceAreaProductRelationService prefrenceAreaProductRelationService;
    @Autowired
    private IProductCategoryService productCategoryService;
    @Autowired
    private ISkuStockService skuStockService;

    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveProductPlus(PmsProductPlusVo productPlusVo) {

        ProductServiceImpl currentProxy = (ProductServiceImpl) AopContext.currentProxy();

        currentProxy.saveProductMajor(productPlusVo);
        currentProxy.saveSkuStock(productPlusVo.getSkuStockList());

        currentProxy.saveMemberPrice(productPlusVo.getMemberPriceList());
        currentProxy.saveProductLadder(productPlusVo.getProductLadderList());
        currentProxy.saveProductFullReduction(productPlusVo.getProductFullReductionList());
        currentProxy.saveProductAttributeValue(productPlusVo.getProductAttributeValueList());
        currentProxy.saveSubjectProductRelation(productPlusVo.getSubjectProductRelationList());
        currentProxy.savePrefrenceAreaProductRelation(productPlusVo.getPrefrenceAreaProductRelationList());

        currentProxy.updateProductCategoryCount(productPlusVo.getProductCategoryId());
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveProductMajor(PmsProductPlusVo productPlusVo) {

        ProductServiceImpl currentProxy = (ProductServiceImpl) AopContext.currentProxy();

        currentProxy.saveProduct(productPlusVo);
        currentProxy.saveSkuStock(productPlusVo.getSkuStockList());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveProduct(PmsProductPlusVo productPlusVo){

        Product product = LeyiUtils.copyProperties(productPlusVo, new Product());
        this.save(product);
        threadLocal.set(product.getId());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveSkuStock(List<SkuStock> skuStockList) {
        final Long productId = threadLocal.get();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        skuStockList.forEach(ss -> {
            ss.setProductId(productId);
            ss.setSkuCode("K_" + productId + "_" + String.format("%03d", atomicInteger.incrementAndGet()));
        });
        skuStockService.saveBatch(skuStockList);
    }

    // 会员价格
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveMemberPrice(List<MemberPrice> memberPriceList) {
        final Long productId = threadLocal.get();
        memberPriceList.forEach(mp -> mp.setProductId(productId));
        memberPriceService.saveBatch(memberPriceList);
    }

    // 阶梯价格
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveProductLadder(List<ProductLadder> productLadderList) {
        final Long productId = threadLocal.get();
        productLadderList.forEach(pl -> pl.setProductId(productId));
        productLadderService.saveBatch(productLadderList);
    }

    // 满减价格
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveProductFullReduction(List<ProductFullReduction> productFullReductionList) {
        final Long productId = threadLocal.get();
        productFullReductionList.forEach(pfr -> pfr.setProductId(productId));
        productFullReductionService.saveBatch(productFullReductionList);
    }

    // 商品属性值
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveProductAttributeValue(List<ProductAttributeValue> productAttributeValueList) {
        final Long productId = threadLocal.get();
        productAttributeValueList.forEach(pav -> pav.setProductId(productId));
        productAttributeValueService.saveBatch(productAttributeValueList);
    }

    // 商品关联专题
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveSubjectProductRelation(List<SubjectProductRelation> subjectProductRelationList) {
        final Long productId = threadLocal.get();
        subjectProductRelationList.forEach(spr -> spr.setProductId(productId));
        subjectProductRelationService.saveBatch(subjectProductRelationList);
    }

    // 商品关联优选
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void savePrefrenceAreaProductRelation(List<PrefrenceAreaProductRelation> prefrenceAreaProductRelationList) {
        final Long productId = threadLocal.get();
        prefrenceAreaProductRelationList.forEach(papr -> papr.setProductId(productId));
        prefrenceAreaProductRelationService.saveBatch(prefrenceAreaProductRelationList);
    }

    // 更新商品分类数目
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateProductCategoryCount(Long productCategoryId) {
        productCategoryService.update(new LambdaUpdateWrapper<ProductCategory>()
                .eq(ProductCategory::getId, productCategoryId)
                .setSql("product_count = product_count + 1"));
    }

}
