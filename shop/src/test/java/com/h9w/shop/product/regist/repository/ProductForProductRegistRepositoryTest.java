package com.h9w.shop.product.regist.repository;

import com.h9w.shop.AdminApplication;
import com.h9w.shop.config.BeanConfiguration;
import com.h9w.shop.config.JpaCongifuration;
import com.h9w.shop.product.regist.entity.Product;
import javax.transaction.Transactional;
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