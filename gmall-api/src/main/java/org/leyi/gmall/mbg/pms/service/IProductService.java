package org.leyi.gmall.mbg.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.leyi.gmall.mbg.base.BasePage;
import org.leyi.gmall.mbg.base.BasePage;
import org.leyi.gmall.mbg.pms.vo.PmsProductQuery;
import org.leyi.gmall.mbg.pms.entity.Product;
import org.leyi.gmall.mbg.pms.vo.PmsProductQuery;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
public interface IProductService extends IService<Product> {

    BasePage listByCondition(PmsProductQuery productQuery, Long current, Long size );

}
