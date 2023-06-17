package com.shop.admin.product.find.model.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity(name = "ProductForProductFind")
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
    private int productNo;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_DATE")
    private String productDate;

    @Column(name = "PRODUCT_CATEGORY_NO")
    private int productCategoryNo;

    @Column(name = "PRODUCT_STATUS_NO")
    private int productStatusNo;

    @Column(name = "PRODUCT_PRICE")
    private int productPrice;
}
