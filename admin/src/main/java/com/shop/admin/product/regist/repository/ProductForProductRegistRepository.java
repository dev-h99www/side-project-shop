package com.shop.admin.product.regist.repository;

import com.shop.admin.product.regist.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductForProductRegistRepository extends JpaRepository<Product, Integer> {
}
