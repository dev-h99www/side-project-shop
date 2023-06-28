package com.h9w.shop.product.model.repository;

import com.h9w.shop.product.model.dto.SearchInfoDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class ProductRepositoryImpl implements ProductRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    public ProductRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }


    @Override
    public Long findProductsCountBySearchInfos(SearchInfoDTO searchInfo) {
        return null;
    }
}
