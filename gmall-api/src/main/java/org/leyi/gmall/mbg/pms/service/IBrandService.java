package org.leyi.gmall.mbg.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.leyi.gmall.mbg.base.BasePage;
import org.leyi.gmall.mbg.base.BasePage;
import org.leyi.gmall.mbg.pms.entity.Brand;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
public interface IBrandService extends IService<Brand> {

    BasePage listByKeywords(String keywords, Long current, Long size);
}
