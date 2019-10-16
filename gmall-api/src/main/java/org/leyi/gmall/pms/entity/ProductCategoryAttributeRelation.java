package org.leyi.gmall.pms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 产品的分类和属性的关系表，用于设置分类筛选条件
 * </p>
 *
 * @author wuleyi
 * @since 2019-09-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("pms_product_category_attribute_relation")
@ApiModel(value = "ProductCategoryAttributeRelation对象", description = "产品的分类和属性的关系表，用于设置分类筛选条件")
@NoArgsConstructor
public class ProductCategoryAttributeRelation extends Model<ProductCategoryAttributeRelation> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long productCategoryId;

    private Long productAttributeId;

    public ProductCategoryAttributeRelation(Long productCategoryId, Long productAttributeId) {
        this.productCategoryId = productCategoryId;
        this.productAttributeId = productAttributeId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
