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
@ApiModel("商品添加参数（全）")
public class PmsProductCreateVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty("商品分类id")
    private Integer productCategoryId;

    @ApiModelProperty("商品分类名称")
    private String productCategoryName;

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("副标题")
    private String subTitle;

    @ApiModelProperty("商品品牌id")
    private Integer brandId;

    @ApiModelProperty("商品品牌名称")
    private String brandName;

    @ApiModelProperty("商品介绍")
    private String description;

    @ApiModelProperty("商品货号")
    private String productSn;

    @ApiModelProperty("商品售价")
    private Integer price;

    @ApiModelProperty("市场价")
    private Integer originalPrice;

    @ApiModelProperty("商品库存")
    private Integer stock;

    @ApiModelProperty("库存预警值")
    private Integer lowStock;

    @ApiModelProperty("计量单位")
    private String unit;

    @ApiModelProperty("商品重量(克)")
    private Integer weight;

    @ApiModelProperty("排序")
    private Integer sort;

    // ------------------------------------------------------------------------------------------------------

    @ApiModelProperty("赠送积分")
    private String giftPoint;

    @ApiModelProperty("赠送成长值")
    private String giftGrowth;

    @ApiModelProperty("积分购买限制")
    private String usePointLimit;

    @ApiModelProperty("预告商品")
    private Integer previewStatus;

    @ApiModelProperty("商品上架")
    private Integer publishStatus;

    @ApiModelProperty("新品状态")
    private Integer newStatus;

    @ApiModelProperty("推荐状态")
    private Integer recommandStatus;

    @ApiModelProperty("审核状态")
    private Integer verifyStatus;

    @ApiModelProperty("商品删除状态")
    private Integer deleteStatus;

    @ApiModelProperty("服务保证")
    private String serviceIds;

    @ApiModelProperty("详细页标题")
    private String detailTitle;

    @ApiModelProperty("详细页描述")
    private String detailDesc;

    @ApiModelProperty("商品关键字")
    private String keywords;

    @ApiModelProperty("商品备注")
    private String note;

    @ApiModelProperty("促销类型")
    private Integer promotionType;

    @ApiModelProperty("特惠促销开始时间")
    private Long promotionStartTime;

    @ApiModelProperty("特惠促销结束时间")
    private Long promotionEndTime;

    @ApiModelProperty("特惠促销价格")
    private String promotionPrice;

    @ApiModelProperty("限时购表id")
    private Integer flashPromotionId;

    @ApiModelProperty("限时购价格")
    private Integer flashPromotionPrice;

    @ApiModelProperty("限时购数量")
    private Integer flashPromotionCount;

    @ApiModelProperty("活动每人限购数量")
    private Integer promotionPerLimit;

    @ApiModelProperty("限时购排序")
    private Integer flashPromotionSort;

    @ApiModelProperty("会员价格")
    private ArrayList<MemberPrice> memberPriceList;

    @ApiModelProperty("阶梯价格")
    private ArrayList<ProductLadder> productLadderList;

    @ApiModelProperty("满减价格")
    private ArrayList<ProductFullReduction> productFullReductionList;

    // ------------------------------------------------------------------------------------------------------

    @ApiModelProperty("商品属性类型")
    private Integer productAttributeCategoryId;

    @ApiModelProperty("商品属性值")
    private ArrayList<ProductAttributeValue> productAttributeValueList;

    @ApiModelProperty("商品图片")
    private String pic;

    @ApiModelProperty("画册图片，连产品图片限制为5张，以逗号分割")
    private String albumPics;

    @ApiModelProperty("电脑端详情")
    private String detailHtml;

    @ApiModelProperty("移动端详情")
    private String detailMobileHtml;

    @ApiModelProperty("商品关联专题")
    private ArrayList<SubjectProductRelation> subjectProductRelationList;

    @ApiModelProperty("商品关联优选")
    private ArrayList<PrefrenceAreaProductRelation> prefrenceAreaProductRelationList;

    @ApiModelProperty("销量")
    private Integer sale;

    @ApiModelProperty("sku库存")
    private ArrayList<SkuStock> skuStockList;

    @ApiModelProperty("运费模版")
    private Integer feightTemplateId;

}
