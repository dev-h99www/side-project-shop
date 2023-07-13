package com.h9w.shop.purchase.model.entity;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity(name = "PurchaseHistoryCategory")
@Table(name = "TBL_PURCHASE_HISTORY_CATEGORY")
@SequenceGenerator(
        name = "PURCHASE_HISTORY_CATEGORY_SEQ_GENERATOR",
        sequenceName = "SEQ_PURCHASE_HISTORY_CATEGORY_NO",
        initialValue = 1,
        allocationSize = 1
)
public class PurchaseHistoryCategory {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "PURCHASE_HISTORY_CATEGORY_SEQ_GENERATOR"
    )
    @Column(name = "PURCHASE_HISTORY_CATEGORY_NO")
    private Integer purchaseHistoryCategoryNo;

    @Column(name = "PURCHASE_HISTORY_CATEGORY_NAME")
    private String purchaseHistoryCategoryName;
}
