package org.leyi.gmall.pms.vo;

import lombok.Data;
import org.leyi.gmall.pms.entity.ProductCategory;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class PmsProductCategoryCreateVo extends ProductCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Long> productAttributeIdList;

}
