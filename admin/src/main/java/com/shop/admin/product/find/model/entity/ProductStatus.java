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
@Entity(name = "ProductStatusForProductFind")
@Table(name = "TBL_PRODUCT_STATUS")
public class ProductStatus {

    @Id
    @Column(name = "PRODUCT_STATUS_NO")
    private int productStatusNo;

    @Column(name = "PRODUCT_STATUS_NAME")
    private String productStatusName;
}
