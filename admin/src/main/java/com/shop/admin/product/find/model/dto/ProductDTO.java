package com.shop.admin.product.find.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ProductDTO {

    private int productNo;
    private String productName;
    private String productDate;
    private ProductCategoryDTO productCategory;
    private ProductStatusDTO productStatus;
    private int productPrice;
}
