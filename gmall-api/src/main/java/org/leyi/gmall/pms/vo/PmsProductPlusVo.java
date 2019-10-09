package org.leyi.gmall.pms.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.leyi.gmall.cms.entity.PrefrenceAreaProductRelation;
import org.leyi.gmall.cms.entity.SubjectProductRelation;
import org.leyi.gmall.pms.entity.*;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@ApiModel("商品添加参数")
public class PmsProductPlusVo extends Product implements Serializable {

    @ApiModelProperty("sku库存")
    private ArrayList<SkuStock> skuStockList;

    @ApiModelProperty("会员价格")
    private ArrayList<MemberPrice> memberPriceList;

    @ApiModelProperty("阶梯价格")
    private ArrayList<ProductLadder> productLadderList;

    @ApiModelProperty("满减价格")
    private ArrayList<ProductFullReduction> productFullReductionList;

    @ApiModelProperty("商品属性值")
    private ArrayList<ProductAttributeValue> productAttributeValueList;

    @ApiModelProperty("商品关联专题")
    private ArrayList<SubjectProductRelation> subjectProductRelationList;

    @ApiModelProperty("商品关联优选")
    private ArrayList<PrefrenceAreaProductRelation> prefrenceAreaProductRelationList;

}
