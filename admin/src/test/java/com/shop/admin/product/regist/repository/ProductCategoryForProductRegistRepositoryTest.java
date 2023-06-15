package com.shop.admin.product.regist.repository;

import com.shop.admin.AdminApplication;
import com.shop.admin.config.BeanConfiguration;
import com.shop.admin.config.JpaCongifuration;
import com.shop.admin.product.regist.entity.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JpaCongifuration.class,
        AdminApplication.class
})
class ProductCategoryForProductRegistRepositoryTest {

    @Autowired
    private ProductCategoryForProductRegistRepository repo;

    @Test
    public void initTest() {

        assertNotNull(repo);
    }

    @Test
    public void findAll_Test() {

        List<ProductCategory> categories = repo.findAll();

        assertNotNull(categories);

        categories.forEach(System.out::println);
    }
}