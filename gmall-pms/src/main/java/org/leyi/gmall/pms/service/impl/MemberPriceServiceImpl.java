package org.leyi.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.leyi.gmall.pms.entity.MemberPrice;
import org.leyi.gmall.pms.mapper.MemberPriceMapper;
import org.leyi.gmall.pms.service.IMemberPriceService;

/**
 * <p>
 * 商品会员价格表 服务实现类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
@Service
public class MemberPriceServiceImpl extends ServiceImpl<MemberPriceMapper, MemberPrice> implements IMemberPriceService {

}
