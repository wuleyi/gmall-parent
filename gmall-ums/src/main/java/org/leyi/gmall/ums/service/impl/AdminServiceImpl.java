package org.leyi.gmall.ums.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.leyi.gmall.ums.entity.Admin;
import org.leyi.gmall.ums.mapper.AdminMapper;
import org.leyi.gmall.ums.service.IAdminService;
import org.springframework.util.DigestUtils;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Override
    public Admin login(String username, String password) {

        return baseMapper.selectOne(new LambdaQueryWrapper<Admin>()
                .eq(Admin::getUsername, username)
                .eq(Admin::getPassword, DigestUtils.md5DigestAsHex(password.getBytes())));
    }

    @Override
    public Admin getByUserName(String userName) {
        return baseMapper.selectOne(new LambdaQueryWrapper<Admin>().eq(Admin::getUsername, userName));
    }
}
