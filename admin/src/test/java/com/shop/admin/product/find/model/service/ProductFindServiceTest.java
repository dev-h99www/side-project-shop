package com.shop.admin.product.find.model.service;

import com.shop.admin.AdminApplication;
import com.shop.admin.config.BeanConfiguration;
import com.shop.admin.config.JpaCongifuration;
import com.shop.admin.product.find.model.dto.PageInfoDTO;
import com.shop.admin.product.find.model.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        AdminApplication.class,
        JpaCongifuration.class,
        BeanConfiguration.class
})
class ProductFindServiceTest {
    @Autowired
    private ProductFindService service;

    @Test
    public void initTest() {

        assertNotNull(service);
    }

    @Test
    public void findAll_Test() {
        PageInfoDTO pageInfo = PageInfoDTO.builder().page(1).pageItemCount(10).totalItemCount(1).type("").build();
        List<ProductDTO> products = service.findAllProducts(pageInfo);

        assertNotNull(products);

        products.forEach(System.out::println);
    }
}