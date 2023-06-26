package com.h9w.shop.product.find.model.repository;

import com.h9w.shop.AdminApplication;
import com.h9w.shop.config.BeanConfiguration;
import com.h9w.shop.config.JpaCongifuration;
import com.h9w.shop.product.find.model.entity.Product;
import com.h9w.shop.product.find.model.entity.ProductStatus;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JpaCongifuration.class,
        AdminApplication.class
})
class ProductForFindRegistoryTest {

    @Autowired
    private ProductForFindRegistory repo;
    @Autowired
    private ProductStatusForFindRepository statusRepo;
    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void initTest() {

        assertNotNull(repo);
        assertNotNull(entityManager);
    }

    @Test
    public void contextLoads_test() {
        Product product = new Product();
        product.setProductNo(5);
    }

    @Test
    public void findAll_Test() {
        List<Product> products = repo.findAll();

        assertNotNull(products);

        products.forEach(System.out::println);

        Pageable pageable = PageRequest.of(1, 10);
        products = repo.findByProductCategory_ProductCategoryNoAndProductStatus_ProductStatusNo(1,1, pageable);

        assertNotNull(products);

        products.forEach(System.out::println);
    }

    @Test
    public void countByProductStatusNo_test() {

        assertDoesNotThrow(() -> repo.countByProductStatusNo(1));
    }
}