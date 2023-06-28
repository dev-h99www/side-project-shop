package com.h9w.shop.product.model.repository;

import com.h9w.shop.product.model.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}
