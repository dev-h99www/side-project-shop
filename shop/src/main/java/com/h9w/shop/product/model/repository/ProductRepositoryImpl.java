package com.h9w.shop.product.model.repository;

import com.h9w.shop.product.model.dto.SearchInfoDTO;
import com.h9w.shop.product.model.entity.QProduct;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class ProductRepositoryImpl implements ProductRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    public ProductRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Long findProductsCountBySearchInfos(SearchInfoDTO searchInfo) {
        BooleanBuilder builder = new BooleanBuilder();

        if(searchInfo.getCategoryNo() != null) {
            builder.and(QProduct.product.productCategory.productCategoryNo.eq(searchInfo.getCategoryNo()));
        }

        if(searchInfo.getStatusNo() != null) {
            builder.and(QProduct.product.productStatus.productStatusNo.eq(searchInfo.getStatusNo()));
        }

        if(searchInfo.getSearchValue() != null) {
            builder.and(QProduct.product.productName.contains(searchInfo.getSearchValue()));
        }

        return jpaQueryFactory
                .select(QProduct.product.count())
                .from(QProduct.product)
                .where(builder)
                .fetchOne();
    }
}
