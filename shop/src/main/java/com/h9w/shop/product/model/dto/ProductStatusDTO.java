package com.h9w.shop.product.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ProductStatusDTO {

    private int productStatusNo;
    private String productStatusName;
}
