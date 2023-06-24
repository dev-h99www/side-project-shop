package com.shop.admin.product.find.model.dto;


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
    private String type;
    private int categoryNo;
    private int statusNo;
}
