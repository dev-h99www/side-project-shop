package com.h9w.shop.product.model.repository;

import com.h9w.shop.ShopApplication;
import com.h9w.shop.config.BeanConfiguration;
import com.h9w.shop.config.JpaCongifuration;
import com.h9w.shop.product.model.dto.PageInfoDTO;
import com.h9w.shop.product.model.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
class ProductRepositoryTest {
    @Autowired private ProductRepository repo;

    @Test
    public void initTest() {
        assertNotNull(repo);
    }

    @Test
    @DisplayName("상품 갯수 조회 테스트1 : 조건 없이 모든 갯수 조회")
    public void findProductsCountBySearchInfos_test1(){
        //given
        PageInfoDTO searchInfo = new PageInfoDTO();

        //when
        Long counts = repo.findProductsCountBySearchInfos(searchInfo);

        //then
        assertNotNull(counts);

        System.out.println(counts);

    }

    @Test
    @DisplayName("상품 갯수 조회 테스트2 : 카테고리번호 조건 넣어 갯수 조회")
    public void findProductsCountBySearchInfos_test2(){
        //given
        PageInfoDTO searchInfo = new PageInfoDTO();
        searchInfo.setCategoryNo(3);

        //when
        Long counts = repo.findProductsCountBySearchInfos(searchInfo);

        //then
        assertNotNull(counts);

        System.out.println(counts);

    }

    @Test
    @DisplayName("상품 갯수 조회 테스트3 : 카테고리와 상태 조건 넣어 갯수 조회")
    public void findProductsCountBySearchInfos_test3(){
        //given
        PageInfoDTO searchInfo = PageInfoDTO.builder().page(1).totalItemCount(10).pageItemCount(5).searchValue(null).categoryNo(3).statusNo(2).build();

        //when
        Long counts = repo.findProductsCountBySearchInfos(searchInfo);

        //then
        assertNotNull(counts);

        System.out.println(counts);

    }

    @Test
    @DisplayName("상품 갯수 조회 테스트4 : 카테고리와 상태 검색어 조건 넣어 갯수 조회")
    public void findProductsCountBySearchInfos_test4(){
        //given
        PageInfoDTO searchInfo = PageInfoDTO.builder().page(1).totalItemCount(10).pageItemCount(5).searchValue("상품").categoryNo(3).statusNo(2).build();

        //when
        Long counts = repo.findProductsCountBySearchInfos(searchInfo);

        //then
        assertNotNull(counts);

        System.out.println(counts);

    }

    @Test
    @DisplayName("상품 조회 테스트1 : 조건 없이 모든 상품 조회")
    public void findProductsBySearchInfos_test1(){
        //given
        int page = 1;
        PageInfoDTO pageInfo = PageInfoDTO.builder().page(page).pageItemCount(10).totalItemCount(17).searchValue("").categoryNo(0).statusNo(0).build();
        Pageable pageable = PageRequest.of(pageInfo.getPage() < 0? 0: pageInfo.getPage() - 1, pageInfo.getPageItemCount(), Sort.by("productNo").ascending());
        //when
        List<Product> products = repo.findProductsBySearchInfos(pageInfo, pageable);

        //then
        assertNotNull(products);
        products.forEach(System.out::println);

    }

    @Test
    @DisplayName("상품 조회 테스트2 : 카테고리와 상태 검색어 조건 넣어 상품 조회")
    public void findProductsBySearchInfos_test2(){
        //given
        int page = 1;
        PageInfoDTO pageInfo = PageInfoDTO.builder().page(page).pageItemCount(10).totalItemCount(17).searchValue("테스트").categoryNo(1).statusNo(1).build();
        Pageable pageable = PageRequest.of(pageInfo.getPage() < 0? 0: pageInfo.getPage() - 1, pageInfo.getPageItemCount(), Sort.by("productNo").ascending());
        //when
        List<Product> products = repo.findProductsBySearchInfos(pageInfo, pageable);

        //then
        assertNotNull(products);
        products.forEach(System.out::println);

    }
}