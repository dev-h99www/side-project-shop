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
@Entity(name = "ProductStatusForProducts")
@Table(name = "TBL_PRODUCT_STATUS")
public class ProductStatus {

    @Id
    @Column(name = "PRODUCT_STATUS_NO")
    private int productStatusNo;

    @Column(name = "PRODUCT_STATUS_NAME")
    private String productStatusName;
}
