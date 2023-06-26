package com.h9w.shop.product.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity(name = "ProductCategoryForProducts")
@Table(name = "TBL_PRODUCT_CATEGORY")
public class ProductCategory {

    @Id
    @Column(name = "PRODUCT_CATEGORY_NO")
    private int productCategoryNo;

    @Column(name = "PRODUCT_CATEGORY_NAME")
    private String productCategoryName;
}