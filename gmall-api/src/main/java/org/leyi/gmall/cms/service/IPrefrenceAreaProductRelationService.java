package org.leyi.gmall.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.leyi.gmall.cms.entity.PrefrenceAreaProductRelation;

import java.util.Collection;

/**
 * <p>
 * 优选专区和产品关系表 服务类
 * </p>
 *
 * @author wuleyi
 * @since 2019-10-07
 */
public interface IPrefrenceAreaProductRelationService extends IService<PrefrenceAreaProductRelation> {

    boolean saveBatch4Dubbo(Collection<PrefrenceAreaProductRelation> entityList);

}
