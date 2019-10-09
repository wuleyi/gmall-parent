package org.leyi.gmall.cms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.leyi.gmall.cms.entity.PrefrenceAreaProductRelation;
import org.leyi.gmall.cms.mapper.PrefrenceAreaProductRelationMapper;
import org.leyi.gmall.cms.service.IPrefrenceAreaProductRelationService;

import java.util.Collection;

/**
 * <p>
 * 优选专区和产品关系表 服务实现类
 * </p>
 *
 * @author wuleyi
 * @since 2019-10-07
 */
@Service
public class PrefrenceAreaProductRelationServiceImpl extends ServiceImpl<PrefrenceAreaProductRelationMapper, PrefrenceAreaProductRelation> implements IPrefrenceAreaProductRelationService {

    @Override
    public boolean saveBatch4Dubbo(Collection<PrefrenceAreaProductRelation> entityList) {

        return this.saveBatch(entityList);
    }

}
