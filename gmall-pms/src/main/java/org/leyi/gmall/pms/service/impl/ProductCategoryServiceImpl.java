package org.leyi.gmall.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.leyi.gmall.mbg.pms.dto.PmsProductMultiCategoryDto;
import org.leyi.gmall.mbg.pms.entity.ProductCategory;
import org.leyi.gmall.pms.mapper.ProductCategoryMapper;
import org.leyi.gmall.mbg.pms.service.IProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements IProductCategoryService {

    @Override
    public List<PmsProductMultiCategoryDto> listWithChildren() {

        List<ProductCategory> productCategories = baseMapper.selectList(null);

        final List<ProductCategory> firstLevelCategories = productCategories.parallelStream().filter(productCategory -> productCategory.getLevel() == 0).collect(Collectors.toUnmodifiableList());
        List<PmsProductMultiCategoryDto> multiCategoryDtos = Lists.newArrayListWithCapacity(firstLevelCategories.size());

        firstLevelCategories.forEach(flc -> {
            PmsProductMultiCategoryDto multiCategoryDto = new PmsProductMultiCategoryDto();
            BeanUtils.copyProperties(flc, multiCategoryDto);
            multiCategoryDtos.add(multiCategoryDto);
        });

        multiCategoryDtos.forEach(flc -> {
            Long flcId = flc.getId();
            List<ProductCategory> secondLevelCategories = productCategories.stream().filter(productCategory -> productCategory.getParentId() == flcId).collect(Collectors.toUnmodifiableList());
            secondLevelCategories.forEach(slc -> {
                Long slcId = slc.getId();
                List<ProductCategory> thirdLevelCategories = productCategories.stream().filter(productCategory -> productCategory.getParentId() == slcId).collect(Collectors.toUnmodifiableList());
            });
        });
        return null;
    }


}
