package com.h9w.shop.purchase.model.dto;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ProductDTO {
    private Long productNo;
    private String productName;
    private String productDate;
    private Integer productCategoryNo;
    private Integer productStatusNo;
    private Integer productPrice;
}
