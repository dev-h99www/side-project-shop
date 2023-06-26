package com.h9w.shop.product.find.model.service;

import com.h9w.shop.AdminApplication;
import com.h9w.shop.config.BeanConfiguration;
import com.h9w.shop.config.JpaCongifuration;
import com.h9w.shop.product.find.model.dto.PageInfoDTO;
import com.h9w.shop.product.find.model.dto.ProductDTO;
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