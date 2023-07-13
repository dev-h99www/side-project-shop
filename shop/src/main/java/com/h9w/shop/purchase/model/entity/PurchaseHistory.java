package com.h9w.shop.purchase.model.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity(name = "PurchaseHistory")
@Table(name = "TBL_PURCHASE_HISTORY")
@SequenceGenerator(
        name = "PURCHASE_HISTORY_SEQ_GENERATOR",
        sequenceName = "SEQ_PURCHASE_HISTORY_NO",
        initialValue = 1,
        allocationSize = 1
)
public class PurchaseHistory {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "PURCHASE_HISTORY_SEQ_GENERATOR"
    )
    @Column(name = "PURCHASE_HISTORY_NO")
    private Long purchaseHistoryNo;

    @Column(name = "PURCHASE_NO")
    private Long purchaseNo;

    @Column(name = "PURCHASE_HISTORY_CATEGORY_NO")
    private Integer purchaseHistoryCategoryNo;

    @Column(name = "HISTORY_DATE")
    private String historyDate;
}
