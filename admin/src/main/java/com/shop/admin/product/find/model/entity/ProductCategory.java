package com.shop.admin.product.find.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity(name = "ProductCategoryForProductFind")
@Table(name = "TBL_PRODUCT_CATEGORY")
public class ProductCategory {

    @Id
    @Column(name = "PRODUCT_CATEGORY_NO")
    private int productCategoryNo;

    @Column(name = "PRODUCT_CATEGORY_NAME")
    private String productCategoryName;
}