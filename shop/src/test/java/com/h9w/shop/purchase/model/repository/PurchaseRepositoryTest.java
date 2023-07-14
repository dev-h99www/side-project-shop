package com.h9w.shop.purchase.model.repository;

import com.h9w.shop.ShopApplication;
import com.h9w.shop.config.BeanConfiguration;
import com.h9w.shop.config.JpaCongifuration;
import com.h9w.shop.purchase.model.dto.PageInfoDTO;
import com.h9w.shop.purchase.model.entity.Product;
import com.h9w.shop.purchase.model.entity.Purchase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JpaCongifuration.class,
        ShopApplication.class
})
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

    @Test
    public void findAllCountBySearchInfo_test() {
        //given
        PageInfoDTO searchInfo = PageInfoDTO.builder().page(1).searchValue(null).pageItemCount(5).userNo(1).totalItemCount(0).categoryNo(0).statusNo(0).build();

        Product product = Product.builder().productNo(0l).productPrice(1000).productDate("2023-01-01").productCategoryNo(1).productStatusNo(1).productName("d").build();
        product.setProductNo(productRepo.save(product).getProductNo());


        Purchase registInfo = Purchase.builder().amount(1).productNo(product.getProductNo()).totalPrice(1000).memberNo(1).orderDate("2023-01-01").build();

        repo.save(registInfo);

        //when
        Long result = repo.findAllCountBySearchInfo(searchInfo.setValueToObject());

        //then
        assertEquals(1, result);
    }

    @Test
    public void findAllBySearchInfo_test() {
        //given
        PageInfoDTO searchInfo = PageInfoDTO.builder().page(1).searchValue(null).pageItemCount(5).userNo(1).totalItemCount(1).categoryNo(0).statusNo(0).build();
        Pageable pageable = PageRequest.of(searchInfo.getPage() < 0? 0: searchInfo.getPage() - 1, searchInfo.getPageItemCount());
        Product product = Product.builder().productNo(0l).productPrice(1000).productDate("2023-01-01").productCategoryNo(1).productStatusNo(1).productName("d").build();
        product.setProductNo(productRepo.save(product).getProductNo());
        Purchase registInfo = Purchase.builder().amount(1).productNo(product.getProductNo()).totalPrice(1000).memberNo(1).orderDate("2023-01-01").build();

        repo.save(registInfo);


        List<Purchase> result = repo.findAllBySearchInfo(searchInfo.setValueToObject(), pageable);

        assertEquals(1, result.size());
        System.out.println(result.get(0));

    }
}