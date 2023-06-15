package com.shop.admin.product.regist.service;

import com.shop.admin.AdminApplication;
import com.shop.admin.config.BeanConfiguration;
import com.shop.admin.config.JpaCongifuration;
import com.shop.admin.product.regist.dto.ProductCategoryDTO;
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
    private ProductFindService service;

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