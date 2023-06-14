package com.shop.admin.product.find.repository;

import com.shop.admin.product.find.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
