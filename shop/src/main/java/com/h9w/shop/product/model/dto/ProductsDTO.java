package com.h9w.shop.product.model.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductsDTO {

    private List<ProductDTO> products;
    private PageInfoDTO pageInfo;
}
