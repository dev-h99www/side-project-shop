package com.h9w.shop.product.regist.service;

import com.h9w.shop.AdminApplication;
import com.h9w.shop.config.BeanConfiguration;
import com.h9w.shop.config.JpaCongifuration;
import com.h9w.shop.product.regist.dto.ProductCategoryDTO;
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
class ProductFindServiceTest {

    @Autowired
    private ProductRegistService service;

    @Test
    public void initTest() {
        assertNotNull(service);
    }

    @Test
    public void findAll_ProductCategories_test() {

        List<ProductCategoryDTO> categories = service.findAllProductCategories();

        assertNotNull(categories);

        categories.forEach(System.out::println);
    }
}