package org.leyi.gmall.mbg.ums.service.impl;

import org.leyi.gmall.mbg.ums.entity.AdminPermissionRelation;
import org.leyi.gmall.mbg.ums.mapper.AdminPermissionRelationMapper;
import org.leyi.gmall.mbg.ums.service.IAdminPermissionRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 服务实现类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
@Service
public class AdminPermissionRelationServiceImpl extends ServiceImpl<AdminPermissionRelationMapper, AdminPermissionRelation> implements IAdminPermissionRelationService {

}
