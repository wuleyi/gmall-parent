package org.leyi.gmall.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.leyi.gmall.cms.entity.SubjectProductRelation;

import java.util.Collection;

/**
 * <p>
 * 专题商品关系表 服务类
 * </p>
 *
 * @author wuleyi
 * @since 2019-10-07
 */
public interface ISubjectProductRelationService extends IService<SubjectProductRelation> {

    boolean saveBatch4Dubbo(Collection<SubjectProductRelation> entityList);

}
