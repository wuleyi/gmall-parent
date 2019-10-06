package org.leyi.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.leyi.gmall.base.BasePage;
import org.leyi.gmall.constant.ProductStatusConstant;
import org.leyi.gmall.pms.entity.Product;
import org.leyi.gmall.pms.mapper.ProductMapper;
import org.leyi.gmall.pms.service.IProductService;
import org.leyi.gmall.pms.vo.PmsProductQuery;

import java.util.Optional;

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
        lambdaQueryWrapper.eq(Product::getDeleteStatus, 1);

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

}
