package org.leyi.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.leyi.gmall.base.BasePage;
import org.leyi.gmall.pms.entity.ProductAttribute;
import org.leyi.gmall.pms.mapper.ProductAttributeMapper;
import org.leyi.gmall.pms.service.IProductAttributeService;

/**
 * <p>
 * 商品属性参数表 服务实现类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
@Service
public class ProductAttributeServiceImpl extends ServiceImpl<ProductAttributeMapper, ProductAttribute> implements IProductAttributeService {

    @Override
    public BasePage listByCategoryIdAndType(String productAttributeCategoryId, String type, Long current, Long size) {

        return new BasePage<ProductAttribute>(baseMapper.selectPage(new Page(current, size), new LambdaQueryWrapper<ProductAttribute>()
                .eq(ProductAttribute::getProductAttributeCategoryId, productAttributeCategoryId)
                .eq(ProductAttribute::getType, type)));
    }

}
