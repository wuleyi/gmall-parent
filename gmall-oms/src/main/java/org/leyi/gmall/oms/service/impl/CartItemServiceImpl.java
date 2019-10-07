package org.leyi.gmall.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.leyi.gmall.oms.entity.CartItem;
import org.leyi.gmall.oms.mapper.CartItemMapper;
import org.leyi.gmall.oms.service.ICartItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author wuleyi
 * @since 2019-10-07
 */
@Service
public class CartItemServiceImpl extends ServiceImpl<CartItemMapper, CartItem> implements ICartItemService {

}
