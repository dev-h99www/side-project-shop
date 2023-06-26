package com.h9w.shop.product.model.repository;

import com.h9w.shop.product.model.entity.Product;

import java.util.List;

public interface ProductCategoryRepositoryCustom {

    public List<Product> getProductsByStatusNo(int productStatusNo);
}
