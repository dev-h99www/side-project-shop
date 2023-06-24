package com.shop.admin.product.find.model.repository;

import com.shop.admin.product.find.model.entity.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStatusForFindRepository extends JpaRepository<ProductStatus, Integer> {
}
