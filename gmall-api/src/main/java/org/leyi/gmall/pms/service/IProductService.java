package org.leyi.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.leyi.gmall.base.BasePage;
import org.leyi.gmall.pms.entity.Product;
import org.leyi.gmall.pms.vo.PmsProductQuery;

import java.util.Map;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
public interface IProductService extends IService<Product> {

    BasePage listByCondition(PmsProductQuery productQuery, Long current, Long size);

    boolean updateBatchProductStatus(String ids, Integer publishStatus, String productStatusType);

    boolean saveProduct(Map<String, Object> params);

}
