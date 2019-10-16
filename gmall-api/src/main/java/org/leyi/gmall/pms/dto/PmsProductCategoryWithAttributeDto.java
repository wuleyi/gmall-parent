package org.leyi.gmall.pms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.leyi.gmall.pms.entity.ProductAttribute;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PmsProductCategoryWithAttributeDto implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;
    private String name;
    private List<ProductAttribute> productAttributeList;

}
