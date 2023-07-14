package com.h9w.shop.purchase.model.dto;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class PurchaseDTO {
    private Long purchaseNo;
    private Integer memberNo;
    private Long productNo;
    private String productName;
    private String orderDate;
    private Integer amount;
    private Integer totalPrice;
}
