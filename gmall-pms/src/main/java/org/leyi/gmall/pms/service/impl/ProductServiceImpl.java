package org.leyi.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.leyi.gmall.mbg.base.BasePage;
import org.leyi.gmall.mbg.pms.entity.Product;
import org.leyi.gmall.pms.mapper.ProductMapper;
import org.leyi.gmall.mbg.pms.service.IProductService;
import org.leyi.gmall.mbg.pms.vo.PmsProductQuery;

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

        Optional.ofNullable(productQuery.getPublishStatus())
                .ifPresent(publishStatus -> lambdaQueryWrapper.eq(Product::getPublishStatus, publishStatus));
        Optional.ofNullable(productQuery.getVerifyStatus())
                .ifPresent(verifyStatus -> lambdaQueryWrapper.eq(Product::getVerifyStatus, verifyStatus));
        Optional.ofNullable(productQuery.getProductCategoryId())
                .ifPresent(productCategoryId -> lambdaQueryWrapper.eq(Product::getProductCategoryId, productCategoryId));
        Optional.ofNullable(productQuery.getBrandId())
                .ifPresent(brandId -> lambdaQueryWrapper.eq(Product::getBrandId, brandId));

        final String keywords = productQuery.getKeywords();
        final boolean keywordsIsNotEmpty = StringUtils.isNotEmpty(keywords);
        lambdaQueryWrapper.eq(keywordsIsNotEmpty, Product::getKeywords, keywords).like(keywordsIsNotEmpty, Product::getName, keywords);
        String productSn = productQuery.getProductSn();
        lambdaQueryWrapper.likeRight(StringUtils.isNotEmpty(productSn), Product::getProductSn, productSn);

        return new BasePage<Product>(baseMapper.selectPage(new Page(current, size), lambdaQueryWrapper));
    }

}
