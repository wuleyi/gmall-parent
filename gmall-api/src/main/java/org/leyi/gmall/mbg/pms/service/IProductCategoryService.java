package org.leyi.gmall.mbg.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.leyi.gmall.mbg.pms.dto.PmsProductMultiCategoryDto;
import org.leyi.gmall.mbg.pms.dto.PmsProductMultiCategoryDto;
import org.leyi.gmall.mbg.pms.entity.ProductCategory;

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

    List<PmsProductMultiCategoryDto> listWithChildren();
}
