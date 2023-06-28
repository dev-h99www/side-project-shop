package com.h9w.shop.product.model.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class PageInfoDTO {

    private int page;
    private int totalItemCount;
    private int pageItemCount;
    private SearchInfoDTO searchInfo;
}
