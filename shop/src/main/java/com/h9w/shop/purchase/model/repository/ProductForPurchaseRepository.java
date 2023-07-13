package com.h9w.shop.purchase.model.repository;

import com.h9w.shop.purchase.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductForPurchaseRepository extends JpaRepository<Product, Long> {
}
