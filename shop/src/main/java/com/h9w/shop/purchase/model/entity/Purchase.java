package com.h9w.shop.purchase.model.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity(name = "Purchase")
@Table(name = "TBL_PAYMENT")
@SequenceGenerator(
        name = "PRODUCT_SEQ_GENERATOR",
        sequenceName = "SEQ_PURCHASE_NO",
        initialValue = 1,
        allocationSize = 1
)
public class Purchase {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "PRODUCT_SEQ_GENERATOR"
    )
    @Column(name = "PURCHASE_NO")
    private Long purchaseNo;

    @Column(name = "MEMBER_NO")
    private Integer memberNo;

    @Column(name = "PRODUCT_NO")
    private Long productNo;

    @Column(name = "ORDER_DATE")
    private String orderDate;

    @Column(name = "AMOUNT")
    private Integer amount;

    @Column(name = "TOTAL_PRICE")
    private Integer totalPrice;
}
