package org.leyi.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.leyi.gmall.base.BasePage;
import org.leyi.gmall.pms.dto.PmsProductAttributeCategoryDto;
import org.leyi.gmall.pms.entity.ProductAttributeCategory;
import org.leyi.gmall.pms.mapper.ProductAttributeCategoryMapper;
import org.leyi.gmall.pms.mapper.ProductAttributeMapper;
import org.leyi.gmall.pms.service.IProductAttributeCategoryService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private ProductAttributeMapper productAttributeMapper;

    @Override
    public BasePage pagePlus(Long current, Long size) {

        return new BasePage(baseMapper.selectPage(new Page(current, size), null));
    }

    @Override
    public List<PmsProductAttributeCategoryDto> listWithAttr() {

        var productAttributeCategories = this.list();
        var resultList = Lists.newArrayListWithCapacity(productAttributeCategories.size());
        productAttributeCategories.forEach(pac -> {
            var productAttributeCategoryId = pac.getId();
            resultList.add(new PmsProductAttributeCategoryDto(
                    productAttributeCategoryId,
                    pac.getName(),
                    productAttributeMapper.selectList(null).stream()
                            .filter(pa -> pa.getProductAttributeCategoryId() == productAttributeCategoryId)
                            .collect(Collectors.toUnmodifiableList()))
            );
        });
        return JSON.parseArray(JSON.toJSONString(resultList), PmsProductAttributeCategoryDto.class);
    }

}
