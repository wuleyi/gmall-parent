package org.leyi.gmall.mbg.sms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 新鲜好物表
 * </p>
 *
 * @author wuleyi
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sms_home_new_product")
@ApiModel(value="HomeNewProduct对象", description="新鲜好物表")
public class HomeNewProduct extends Model<HomeNewProduct> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long productId;

    private String productName;

    private Integer recommendStatus;

    private Integer sort;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
