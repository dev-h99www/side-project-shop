package com.h9w.shop.product.model.repository;

import com.h9w.shop.product.model.entity.Product;
import com.h9w.shop.product.model.entity.QProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

public class ProductCategoryRepositoryImpl implements ProductCategoryRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public ProductCategoryRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Product> getProductsByStatusNo(int productStatusNo) {

        return jpaQueryFactory
                .select(QProduct.product)
                .from(QProduct.product)
                .where(QProduct.product.productStatus.productStatusNo.eq(productStatusNo))
                .fetch();
    }
}
