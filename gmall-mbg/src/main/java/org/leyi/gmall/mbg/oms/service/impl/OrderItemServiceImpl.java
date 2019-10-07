package org.leyi.gmall.mbg.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.leyi.gmall.mbg.oms.entity.OrderItem;
import org.leyi.gmall.mbg.oms.mapper.OrderItemMapper;
import org.leyi.gmall.mbg.oms.service.IOrderItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单中所包含的商品 服务实现类
 * </p>
 *
 * @author wuleyi
 * @since 2019-10-07
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {

}
