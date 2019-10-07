package org.leyi.gmall.ums.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.leyi.gmall.ums.entity.MemberLevel;
import org.leyi.gmall.ums.mapper.MemberLevelMapper;
import org.leyi.gmall.ums.service.IMemberLevelService;

import java.util.List;

/**
 * <p>
 * 会员等级表 服务实现类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
@Service
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelMapper, MemberLevel> implements IMemberLevelService {

    @Override
    public List<MemberLevel> listByDefaultStatus(Integer defaultStatus) {

        return baseMapper.selectList(new LambdaQueryWrapper<MemberLevel>().eq(MemberLevel::getDefaultStatus, defaultStatus));
    }

}
