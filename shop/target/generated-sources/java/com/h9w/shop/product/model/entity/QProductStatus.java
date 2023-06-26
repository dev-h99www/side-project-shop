package com.h9w.shop.product.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductStatus is a Querydsl query type for ProductStatus
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductStatus extends EntityPathBase<ProductStatus> {

    private static final long serialVersionUID = 1511009725L;

    public static final QProductStatus productStatus = new QProductStatus("productStatus");

    public final StringPath productStatusName = createString("productStatusName");

    public final NumberPath<Integer> productStatusNo = createNumber("productStatusNo", Integer.class);

    public QProductStatus(String variable) {
        super(ProductStatus.class, forVariable(variable));
    }

    public QProductStatus(Path<? extends ProductStatus> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductStatus(PathMetadata metadata) {
        super(ProductStatus.class, metadata);
    }

}

