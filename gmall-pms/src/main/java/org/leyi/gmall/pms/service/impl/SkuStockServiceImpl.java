package org.leyi.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.leyi.gmall.pms.entity.SkuStock;
import org.leyi.gmall.pms.mapper.SkuStockMapper;
import org.leyi.gmall.pms.service.ISkuStockService;

import java.util.List;

/**
 * <p>
 * sku的库存 服务实现类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
@Service
public class SkuStockServiceImpl extends ServiceImpl<SkuStockMapper, SkuStock> implements ISkuStockService {

    @Override
    public List<SkuStock> listByProductIdAndKeyword(String productId, String keyword) {

        return baseMapper.selectList(new LambdaQueryWrapper<SkuStock>()
                .eq(StringUtils.isNotEmpty(productId), SkuStock::getProductId, productId)
                .likeRight(StringUtils.isNotEmpty(keyword), SkuStock::getSkuCode, keyword));
    }

    @Override
    public boolean updateBatch(List<SkuStock> skuStocks) {

        return this.updateBatchById(skuStocks);
    }

}
