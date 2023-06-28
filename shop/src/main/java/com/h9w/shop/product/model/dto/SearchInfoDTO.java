package com.h9w.shop.product.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class SearchInfoDTO {
    private Integer categoryNo;
    private Integer statusNo;
    private String searchValue;
}
