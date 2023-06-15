package com.shop.admin.product.regist.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity(name = "ProductCategoryForProductRegist")
@Table(name = "TBL_PRODUCT_CATEGORY")
public class ProductCategory {

    @Id
    @Column(name = "PRODUCT_CATEGORY_NO")
    private int productCategoryNo;

    @Column(name = "PRODUCT_CATEGORY_NAME")
    private String productCategoryName;
}