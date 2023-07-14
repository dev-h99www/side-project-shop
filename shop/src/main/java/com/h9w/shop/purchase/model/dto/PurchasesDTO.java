package com.h9w.shop.purchase.model.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PurchasesDTO {
    private List<PurchaseDTO> purchases;
    private PageInfoDTO pageInfo;
}
