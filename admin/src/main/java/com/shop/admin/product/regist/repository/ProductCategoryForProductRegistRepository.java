package com.shop.admin.product.regist.repository;

import com.shop.admin.product.regist.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryForProductRegistRepository extends JpaRepository<ProductCategory, Integer> {
}
