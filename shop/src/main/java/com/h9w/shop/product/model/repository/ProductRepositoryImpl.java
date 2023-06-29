package com.h9w.shop.product.model.repository;

import com.h9w.shop.product.model.dto.PageInfoDTO;
import com.h9w.shop.product.model.entity.Product;
import com.h9w.shop.product.model.entity.QProduct;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    public ProductRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Long findProductsCountBySearchInfos(PageInfoDTO searchInfo) {
        BooleanBuilder builder = new BooleanBuilder();

        if(searchInfo.getSearchValue() != null) {
            builder.and(QProduct.product.productName.contains(searchInfo.getSearchValue()));
        }

        if(searchInfo.getCategoryNo() != null) {
            builder.and(QProduct.product.productCategory.productCategoryNo.eq(searchInfo.getCategoryNo()));
        }

        if(searchInfo.getStatusNo() != null) {
            builder.and(QProduct.product.productStatus.productStatusNo.eq(searchInfo.getStatusNo()));
        }

        return jpaQueryFactory
                .select(QProduct.product.count())
                .from(QProduct.product)
                .where(builder)
                .fetchOne();
    }

    @Override
    public List<Product> findProductsBySearchInfos(PageInfoDTO searchInfo, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        if(searchInfo.getSearchValue() != null) {
            builder.and(QProduct.product.productName.contains(searchInfo.getSearchValue()));
        }

        if(searchInfo.getCategoryNo() != null) {
            builder.and(QProduct.product.productCategory.productCategoryNo.eq(searchInfo.getCategoryNo()));
        }

        if(searchInfo.getStatusNo() != null) {
            builder.and(QProduct.product.productStatus.productStatusNo.eq(searchInfo.getStatusNo()));
        }


        return jpaQueryFactory
                .select(QProduct.product)
                .from(QProduct.product)
                .where(builder)
                .orderBy(QProduct.product.productNo.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }
}
