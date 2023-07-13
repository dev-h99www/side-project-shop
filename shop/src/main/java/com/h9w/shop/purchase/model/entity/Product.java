package com.h9w.shop.purchase.model.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity(name = "ProductForPurchase")
@Table(name = "TBL_PRODUCT")
@SequenceGenerator(
        name = "PRODUCT_SEQ_GENERATOR",
        sequenceName = "SEQ_PRODUCT_NO",
        initialValue = 1,
        allocationSize = 1
)
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "PRODUCT_SEQ_GENERATOR"
    )
    @Column(name = "PRODUCT_NO")
    private Long productNo;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_DATE")
    private String productDate;

    @Column(name = "PRODUCT_CATEGORY_NO")
    private Integer productCategoryNo;

    @Column(name = "PRODUCT_STATUS_NO")
    private Integer productStatusNo;

    @Column(name = "PRODUCT_PRICE")
    private Integer productPrice;
}
