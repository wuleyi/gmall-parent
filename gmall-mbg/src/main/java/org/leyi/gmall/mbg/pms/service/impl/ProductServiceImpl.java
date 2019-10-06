package org.leyi.gmall.mbg.pms.service.impl;

import org.leyi.gmall.mbg.pms.entity.Product;
import org.leyi.gmall.mbg.pms.mapper.ProductMapper;
import org.leyi.gmall.mbg.pms.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
