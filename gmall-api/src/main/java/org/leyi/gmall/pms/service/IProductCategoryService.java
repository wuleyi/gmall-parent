package org.leyi.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.leyi.gmall.base.BasePage;
import org.leyi.gmall.pms.entity.ProductCategory;

import java.util.List;

/**
 * <p>
 * 产品分类 服务类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
public interface IProductCategoryService extends IService<ProductCategory> {

    List<ProductCategory> listWithChildren();

    BasePage getByParentId(Long parentId, Long current, Long size);

}
