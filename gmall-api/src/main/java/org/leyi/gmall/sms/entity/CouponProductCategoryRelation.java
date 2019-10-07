package org.leyi.gmall.sms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 优惠券和产品分类关系表
 * </p>
 *
 * @author wuleyi
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sms_coupon_product_category_relation")
@ApiModel(value="CouponProductCategoryRelation对象", description="优惠券和产品分类关系表")
public class CouponProductCategoryRelation extends Model<CouponProductCategoryRelation> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long couponId;

    private Long productCategoryId;

    @ApiModelProperty(value = "产品分类名称")
    private String productCategoryName;

    @ApiModelProperty(value = "父分类名称")
    private String parentCategoryName;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
