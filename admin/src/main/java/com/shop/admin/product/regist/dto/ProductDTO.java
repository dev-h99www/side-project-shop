package com.shop.admin.product.regist.dto;

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
    private int productCategoryNo;
    private int productStatusNo;
    private int productPrice;
}
