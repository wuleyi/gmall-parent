package org.leyi.gmall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.leyi.gmall.ums.entity.MemberLevel;

import java.util.List;

/**
 * <p>
 * 会员等级表 服务类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
public interface IMemberLevelService extends IService<MemberLevel> {

    List<MemberLevel> listByDefaultStatus(Integer defaultStatus);
}
