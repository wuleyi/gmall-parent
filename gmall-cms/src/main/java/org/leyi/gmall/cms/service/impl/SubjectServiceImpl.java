package org.leyi.gmall.cms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.leyi.gmall.cms.entity.Subject;
import org.leyi.gmall.cms.mapper.SubjectMapper;
import org.leyi.gmall.cms.service.ISubjectService;

/**
 * <p>
 * 专题表 服务实现类
 * </p>
 *
 * @author wuleyi
 * @since 2019-10-07
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements ISubjectService {

}
