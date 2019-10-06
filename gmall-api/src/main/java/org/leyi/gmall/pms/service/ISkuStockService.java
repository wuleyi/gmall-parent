package org.leyi.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.leyi.gmall.pms.entity.SkuStock;

import java.util.List;

/**
 * <p>
 * sku的库存 服务类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
public interface ISkuStockService extends IService<SkuStock> {

    List<SkuStock> listByProductIdAndKeyword(String productId, String keyword);

    boolean updateBatch(List<SkuStock> skuStocks);
}
