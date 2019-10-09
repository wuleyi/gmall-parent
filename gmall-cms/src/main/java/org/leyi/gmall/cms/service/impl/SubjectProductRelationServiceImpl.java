package org.leyi.gmall.cms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.leyi.gmall.cms.entity.SubjectProductRelation;
import org.leyi.gmall.cms.mapper.SubjectProductRelationMapper;
import org.leyi.gmall.cms.service.ISubjectProductRelationService;

import java.util.Collection;

/**
 * <p>
 * 专题商品关系表 服务实现类
 * </p>
 *
 * @author wuleyi
 * @since 2019-10-07
 */
@Service
public class SubjectProductRelationServiceImpl extends ServiceImpl<SubjectProductRelationMapper, SubjectProductRelation> implements ISubjectProductRelationService {

    @Override
    public boolean saveBatch4Dubbo(Collection<SubjectProductRelation> entityList) {

        return this.saveBatch(entityList);
    }
}
