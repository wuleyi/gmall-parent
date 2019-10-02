package org.leyi.gmall.mbg.pms.dto;

import lombok.Data;
import org.leyi.gmall.mbg.pms.entity.ProductCategory;

import java.util.List;

@Data
public class PmsProductMultiCategoryDto extends ProductCategory {

    private List<PmsProductMultiCategoryDto> children;

}

