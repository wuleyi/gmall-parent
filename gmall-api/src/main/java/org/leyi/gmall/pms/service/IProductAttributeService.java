package org.leyi.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.leyi.gmall.base.BasePage;
import org.leyi.gmall.pms.entity.ProductAttribute;

import java.util.ArrayList;

/**
 * <p>
 * 商品属性参数表 服务类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
public interface IProductAttributeService extends IService<ProductAttribute> {

    BasePage listByCategoryIdAndType(String productAttributeCategoryId, String type, Long current, Long size);

    ArrayList<ProductAttribute> listByCategoryId(Long productCategoryId);

}
