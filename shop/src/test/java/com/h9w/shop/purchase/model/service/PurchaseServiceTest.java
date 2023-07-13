package com.h9w.shop.purchase.model.service;

import com.h9w.shop.ShopApplication;
import com.h9w.shop.common.model.ResponseDTO;
import com.h9w.shop.config.BeanConfiguration;
import com.h9w.shop.config.JpaCongifuration;
import com.h9w.shop.purchase.model.dto.RegistInfoDTO;
import com.h9w.shop.purchase.model.entity.Product;
import com.h9w.shop.purchase.model.repository.ProductForPurchaseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JpaCongifuration.class,
        ShopApplication.class
})
@Transactional
class PurchaseServiceTest {
    @Autowired
    private PurchaseService service;
    @Autowired
    private ProductForPurchaseRepository productRepo;

    @Test
    public void initTest() {
        assertNotNull(service);
    }

    @Test
    public void registPurchase_test() {

        Product product = Product.builder().productNo(0l).productPrice(1000).productDate("2023-01-01").productCategoryNo(1).productStatusNo(1).productName("d").build();
        productRepo.save(product);

        RegistInfoDTO registInfo = RegistInfoDTO.builder().memberNo(1).productNo(product.getProductNo()).amount(1).totalPrice(1000).build();

        assertDoesNotThrow( () -> {
            ResponseDTO result = service.registPurchase(registInfo);
            System.out.println(result);
        });
    }
}