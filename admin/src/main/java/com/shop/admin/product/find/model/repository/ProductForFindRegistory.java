package com.shop.admin.product.find.model.repository;

import com.shop.admin.product.find.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductForFindRegistory extends JpaRepository<Product, Integer> {
}
