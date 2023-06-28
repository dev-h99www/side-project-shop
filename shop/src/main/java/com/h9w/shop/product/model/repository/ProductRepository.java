package com.h9w.shop.product.model.repository;

import com.h9w.shop.product.model.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>, ProductRepositoryCustom {
}
