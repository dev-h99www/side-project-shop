package com.h9w.shop;

import com.querydsl.core.support.QueryBase;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.h9w.shop.product.regist.entity.ProductCategory;
import com.h9w.shop.product.regist.repository.ProductCategoryForProductRegistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class HelloTest {

    @Autowired
    private ProductCategoryForProductRegistRepository categoryRepo;

    @Transactional
    @Test
    void product_category_regist_test() {
        ProductCategory category1 = new ProductCategory(0, "test1");
        ProductCategory category2 = new ProductCategory(0, "test2");
        ProductCategory category3 = new ProductCategory(0, "test3");
        ProductCategory category4 = new ProductCategory(0, "test4");

        categoryRepo.saveAll(Arrays.asList(category1, category2, category3, category4));

        List<ProductCategory> categories = categoryRepo.findAll();
        categories.forEach(System.out::println);

    }

    @Test
    void t2() {
        List<ProductCategory> categories = categoryRepo.getProductCategory(1);

        assertNotNull(categories);
        categories.forEach(System.out::println);
    }

    @PersistenceContext
    EntityManager em;

    @Test
    void contextLoads() {
        Hello hello = new Hello();

        em.persist(hello);

        em.flush();
        em.clear();
        QHello h = new QHello("moon"); // variable -> 별칭
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        Hello data = queryFactory
                .selectFrom(h)
                .fetchOne();
        assertEquals(data, hello);
        assertEquals(data.getId(), hello.getId());

        QHello hello1 = QHello.hello;
        JPAQuery query = new JPAQuery(em);
//        QueryBase hellos = query.from(hello1).where(hello1.name.eq("moon"));

    }

}