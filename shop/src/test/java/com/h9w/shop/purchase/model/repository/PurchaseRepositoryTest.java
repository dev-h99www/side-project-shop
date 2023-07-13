package com.h9w.shop.purchase.model.repository;

import com.h9w.shop.ShopApplication;
import com.h9w.shop.config.BeanConfiguration;
import com.h9w.shop.config.JpaCongifuration;
import com.h9w.shop.purchase.model.entity.Product;
import com.h9w.shop.purchase.model.entity.Purchase;
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
class PurchaseRepositoryTest {

    @Autowired
    private PurchaseRepository repo;
    @Autowired
    private ProductForPurchaseRepository productRepo;

    @Test
    public void initTest() {
        assertNotNull(repo);
    }

    @Test
    public void save_test() {
        Product product = Product.builder().productNo(0l).productPrice(1000).productDate("2023-01-01").productCategoryNo(1).productStatusNo(1).productName("d").build();
        productRepo.save(product);

        Purchase registInfo = Purchase.builder().amount(1).productNo(product.getProductNo()).totalPrice(1000).memberNo(1).orderDate("2023-01-01").build();

        assertDoesNotThrow( () -> repo.save(registInfo));

        System.out.println(registInfo);
    }
}