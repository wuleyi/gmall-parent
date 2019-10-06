package org.leyi.gmall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.leyi.gmall.ums.entity.Admin;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
public interface IAdminService extends IService<Admin> {

    Admin login(String username, String password);

    Admin getByUserName(String userName);
}
