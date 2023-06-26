package com.h9w.shop.product.model.dto;

import org.springframework.data.domain.Page;

public class ProductsDTO {

    private Page<ProductDTO> products;
    private PageInfoDTO pageInfo;
}
