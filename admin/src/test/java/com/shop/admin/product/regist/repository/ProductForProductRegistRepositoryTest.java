package com.shop.admin.product.regist.repository;

import com.shop.admin.AdminApplication;
import com.shop.admin.config.BeanConfiguration;
import com.shop.admin.config.JpaCongifuration;
import com.shop.admin.product.regist.entity.Product;
import jakarta.transaction.Transactional;
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
class ProductForProductRegistRepositoryTest {

    @Autowired
    private ProductForProductRegistRepository repo;

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

    @Test
    @Transactional
    public void registTest() {
        Product product = Product.builder().productPrice(1000).productStatusNo(1).productName("테스트용").productDate("2021-05-12 11:22:10").productCategoryNo(1).productNo(0).build();
        assertDoesNotThrow(() ->repo.save(product));

    }
}