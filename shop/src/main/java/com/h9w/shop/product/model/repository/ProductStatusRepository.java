package com.h9w.shop.product.model.repository;

import com.h9w.shop.product.model.entity.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStatusRepository extends JpaRepository<ProductStatus, Integer> {
}
