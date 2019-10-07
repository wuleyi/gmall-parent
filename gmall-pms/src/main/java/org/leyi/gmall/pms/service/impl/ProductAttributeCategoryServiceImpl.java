package org.leyi.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.leyi.gmall.base.BasePage;
import org.leyi.gmall.pms.entity.ProductAttributeCategory;
import org.leyi.gmall.pms.mapper.ProductAttributeCategoryMapper;
import org.leyi.gmall.pms.service.IProductAttributeCategoryService;

/**
 * <p>
 * 产品属性分类表 服务实现类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
@Service
public class ProductAttributeCategoryServiceImpl extends ServiceImpl<ProductAttributeCategoryMapper, ProductAttributeCategory> implements IProductAttributeCategoryService {

    @Override
    public BasePage pagePlus(Long current, Long size) {

        return new BasePage(baseMapper.selectPage(new Page(current, size), null));
    }

}
