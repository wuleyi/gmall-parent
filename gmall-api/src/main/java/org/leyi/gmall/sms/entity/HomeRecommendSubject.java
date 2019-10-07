package org.leyi.gmall.sms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 首页推荐专题表
 * </p>
 *
 * @author wuleyi
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sms_home_recommend_subject")
@ApiModel(value="HomeRecommendSubject对象", description="首页推荐专题表")
public class HomeRecommendSubject extends Model<HomeRecommendSubject> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long subjectId;

    private String subjectName;

    private Integer recommendStatus;

    private Integer sort;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
