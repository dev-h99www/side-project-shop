package com.h9w.shop.purchase.model.repository;

import com.h9w.shop.purchase.model.dto.PageInfoDTO;
import com.h9w.shop.purchase.model.entity.Purchase;
import com.h9w.shop.purchase.model.entity.QProduct;
import com.h9w.shop.purchase.model.entity.QPurchase;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Pageable;
import java.util.List;

public class PurchaseRepositoryImpl implements PurchaseRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    public PurchaseRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Purchase> findAllBySearchInfo(PageInfoDTO searchInfo, Pageable pageable) {

        BooleanBuilder builder = new BooleanBuilder();

        builder.and(QPurchase.purchase.memberNo.eq(searchInfo.getUserNo()));

        if(searchInfo.getSearchValue() != null) {
            builder.and(QProduct.product.productName.contains(searchInfo.getSearchValue()));
        }

        if(searchInfo.getCategoryNo() != null) {
            builder.and(QProduct.product.productCategoryNo.eq(searchInfo.getCategoryNo()));
        }

        return jpaQueryFactory
                .select(QPurchase.purchase)
                .from(QPurchase.purchase)
                .join(QProduct.product).on(QPurchase.purchase.productNo.eq(QProduct.product.productNo))
                .where(builder)
                .orderBy(QPurchase.purchase.purchaseNo.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public Long findAllCountBySearchInfo(PageInfoDTO searchInfo) {
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(QPurchase.purchase.memberNo.eq(searchInfo.getUserNo()));

        if(searchInfo.getSearchValue() != null) {
            builder.and(QProduct.product.productName.contains(searchInfo.getSearchValue()));
        }

        if(searchInfo.getCategoryNo() != null) {
            builder.and(QProduct.product.productCategoryNo.eq(searchInfo.getCategoryNo()));
        }

        return jpaQueryFactory
                .select(QPurchase.purchase.purchaseNo.count())
                .from(QPurchase.purchase)
                .join(QProduct.product).on(QPurchase.purchase.productNo.eq(QProduct.product.productNo))
                .where(builder)
                .fetchOne();
    }
}
