package com.h9w.shop.purchase.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class RegistInfoDTO {
    Integer memberNo;
    Integer amount;
    Long productNo;
    Integer totalPrice;
}
