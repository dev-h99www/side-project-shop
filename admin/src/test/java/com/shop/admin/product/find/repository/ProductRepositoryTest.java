package com.shop.admin.product.find.repository;

import com.shop.admin.config.AdminApplication;
import com.shop.admin.config.JpaCongifuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        JpaCongifuration.class,
        AdminApplication.class
})
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repo;

    @Test
    @DisplayName("init test")
    public void initTest() {
        assertNotNull(repo);
    }

    @Test
    @DisplayName("find all test")
    public void findAll_test() {
        assertNotNull(repo.findAll());
    }
}