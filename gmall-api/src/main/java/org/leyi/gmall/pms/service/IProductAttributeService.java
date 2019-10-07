package org.leyi.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.leyi.gmall.pms.entity.ProductAttribute;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 商品属性参数表 服务类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
public interface IProductAttributeService extends IService<ProductAttribute> {

    HashMap<String, List> listByCategoryIdAndType(String productAttributeCategoryId, String type);

}
