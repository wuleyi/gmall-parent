package org.leyi.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.leyi.gmall.base.BasePage;
import org.leyi.gmall.pms.dto.PmsProductCategoryWithAttributeDto;
import org.leyi.gmall.pms.entity.ProductAttributeCategory;

import java.util.List;

/**
 * <p>
 * 产品属性分类表 服务类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
public interface IProductAttributeCategoryService extends IService<ProductAttributeCategory> {

    BasePage pagePlus(Long current, Long size);

    List<PmsProductCategoryWithAttributeDto> listWithAttr();
}
