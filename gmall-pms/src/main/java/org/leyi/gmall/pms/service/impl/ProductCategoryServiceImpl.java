package org.leyi.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.leyi.gmall.base.BasePage;
import org.leyi.gmall.constant.RedisCacheConstant;
import org.leyi.gmall.pms.entity.ProductCategory;
import org.leyi.gmall.pms.entity.ProductCategoryAttributeRelation;
import org.leyi.gmall.pms.mapper.ProductCategoryMapper;
import org.leyi.gmall.pms.service.IProductCategoryAttributeRelationService;
import org.leyi.gmall.pms.service.IProductCategoryService;
import org.leyi.gmall.pms.vo.PmsProductCategoryCreateVo;
import org.leyi.gmall.util.LeyiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
@Slf4j
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements IProductCategoryService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public List<ProductCategory> listWithChildren() {

        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        String cacheVal = operations.get(RedisCacheConstant.PRODUCT_CATEGORY_CACHE_KEY);
        if (StringUtils.isNotEmpty(cacheVal)) return JSON.parseArray(cacheVal, ProductCategory.class);

        log.debug("PRODUCT_CATEGORY_CACHE_KEY 缓存未命中，开始查询数据库...");
        List<ProductCategory> categoryDtos = baseMapper.selectList(null);

        List<ProductCategory> productCategories = renderCategory(categoryDtos.stream().filter(categoryDto -> categoryDto.getLevel() == 0).collect(Collectors.toList()), categoryDtos);
        operations.set(RedisCacheConstant.PRODUCT_CATEGORY_CACHE_KEY, JSON.toJSONString(productCategories), 3, TimeUnit.DAYS);
        return productCategories;
    }

    @Override
    public BasePage getByParentId(Long parentId, Long current, Long size) {

        return new BasePage(baseMapper.selectPage(new Page(current, size), new LambdaQueryWrapper<ProductCategory>()
                .eq(ProductCategory::getParentId, parentId)));
    }

    @Autowired
    private IProductCategoryAttributeRelationService productCategoryAttributeRelationService;

    @Override
    @Transactional
    public boolean saveProductCategory(PmsProductCategoryCreateVo productCategoryCreateVo) {

        var productCategory = LeyiUtils.copyProperties(productCategoryCreateVo, new ProductCategory());

        // 新商品分类的 level = 父分类level +1，如果是"无上级分类"，前端传过来的parentId会为-1，直接加1就行
        final var parentId = productCategoryCreateVo.getParentId();
        var parentProductCategory = baseMapper.selectOne(new LambdaQueryWrapper<ProductCategory>()
                .select(ProductCategory::getLevel)
                .eq(ProductCategory::getId, parentId));
        productCategory.setLevel((Objects.nonNull(parentProductCategory) ? parentProductCategory.getLevel() : parentId.intValue()) + 1);

        this.save(productCategory);
        var productCategoryId = productCategory.getId();

        productCategoryAttributeRelationService.saveBatch(productCategoryCreateVo.getProductAttributeIdList().stream()
                .map(productAttributeId -> new ProductCategoryAttributeRelation(productCategoryId, productAttributeId))
                .collect(Collectors.toUnmodifiableList()));

        // 添加了新分类，这里采取将redis中缓存的key删除的方式来使数据同步，使得下次从新从数据库中查询
        redisTemplate.delete(RedisCacheConstant.PRODUCT_CATEGORY_CACHE_KEY);
        return true;
    }

    /**
     * 递归封装 n 级分类
     *
     * @param categories   存放每次从 categoryDtos 中筛选出来的集合
     * @param categoryDtos 存放所有分类的集合
     * @return
     */
    private List<ProductCategory> renderCategory(List<ProductCategory> categories, List<ProductCategory> categoryDtos) {
        categories.forEach(supCategory -> {
            Long curCategoryId = supCategory.getId();
            List<ProductCategory> subCategories = categoryDtos.stream().filter(categoryDto -> categoryDto.getParentId() == curCategoryId).collect(Collectors.toList());
            supCategory.setChildren(subCategories);
            renderCategory(subCategories, categoryDtos);
        });
        return categories;
    }


}
