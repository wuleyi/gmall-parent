package org.leyi.gmall.mbg.sms.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品限时购与商品关系表
 * </p>
 *
 * @author wuleyi
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sms_flash_promotion_product_relation")
@ApiModel(value="FlashPromotionProductRelation对象", description="商品限时购与商品关系表")
public class FlashPromotionProductRelation extends Model<FlashPromotionProductRelation> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long flashPromotionId;

    @ApiModelProperty(value = "编号")
    private Long flashPromotionSessionId;

    private Long productId;

    @ApiModelProperty(value = "限时购价格")
    private BigDecimal flashPromotionPrice;

    @ApiModelProperty(value = "限时购数量")
    private Integer flashPromotionCount;

    @ApiModelProperty(value = "每人限购数量")
    private Integer flashPromotionLimit;

    @ApiModelProperty(value = "排序")
    private Integer sort;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
