package com.h9w.shop.purchase.model.service;

import com.h9w.shop.ShopApplication;
import com.h9w.shop.common.model.ResponseDTO;
import com.h9w.shop.config.BeanConfiguration;
import com.h9w.shop.config.JpaCongifuration;
import com.h9w.shop.purchase.model.dto.PageInfoDTO;
import com.h9w.shop.purchase.model.dto.PurchasesDTO;
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

    @Test
    public void findPurchases_test() {
        //given
        //조건 정보
        PageInfoDTO pageInfo = PageInfoDTO.builder().page(1).pageItemCount(10).totalItemCount(0).userNo(1).build();
        //상품 등록
        Product product = Product.builder().productNo(0l).productPrice(1000).productDate("2023-01-01").productCategoryNo(1).productStatusNo(1).productName("d").build();
        product.setProductNo(productRepo.save(product).getProductNo());

        //등록한 상품 구매
        RegistInfoDTO registInfo = RegistInfoDTO.builder().memberNo(1).productNo(product.getProductNo()).amount(1).totalPrice(1000).build();
        service.registPurchase(registInfo);

        //when
        //구매한 상품 조회
        ResponseDTO result = service.findPurchases(pageInfo);
        System.out.println(result.getData());
        assertEquals(1, ((PurchasesDTO) result.getData()).getPurchases().size());

        ((PurchasesDTO) result.getData()).getPurchases().forEach(System.out::println);
        System.out.println(result);
    }
}