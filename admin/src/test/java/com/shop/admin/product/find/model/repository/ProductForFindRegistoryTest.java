package com.shop.admin.product.find.model.repository;

import com.shop.admin.AdminApplication;
import com.shop.admin.config.BeanConfiguration;
import com.shop.admin.config.JpaCongifuration;
import com.shop.admin.product.find.model.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

    @Test
    public void initTest() {

        assertNotNull(repo);
    }

    @Test
    public void findAll_Test() {
        List<Product> products = repo.findAll();

        assertNotNull(products);

        products.forEach(System.out::println);
    }
}