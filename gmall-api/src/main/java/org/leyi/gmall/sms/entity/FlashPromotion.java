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
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 限时购表
 * </p>
 *
 * @author wuleyi
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sms_flash_promotion")
@ApiModel(value="FlashPromotion对象", description="限时购表")
public class FlashPromotion extends Model<FlashPromotion> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String title;

    @ApiModelProperty(value = "开始日期")
    private LocalDate startDate;

    @ApiModelProperty(value = "结束日期")
    private LocalDate endDate;

    @ApiModelProperty(value = "上下线状态")
    private Integer status;

    @ApiModelProperty(value = "秒杀时间段名称")
    private LocalDateTime createTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
