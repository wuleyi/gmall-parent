package org.leyi.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.leyi.gmall.base.BasePage;
import org.leyi.gmall.pms.entity.Brand;
import org.leyi.gmall.pms.mapper.BrandMapper;
import org.leyi.gmall.pms.service.IBrandService;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    @Override
    public BasePage listByKeywords(String keywords, Long current, Long size) {
        final boolean keywordsIsNotEmpty = StringUtils.isNotEmpty(keywords);

        return new BasePage<Brand>(baseMapper.selectPage(new Page(current, size), new LambdaQueryWrapper<Brand>()
                .eq(keywordsIsNotEmpty, Brand::getFirstLetter, keywords)
                .like(keywordsIsNotEmpty, Brand::getName, keywords)
        ));
    }

}
