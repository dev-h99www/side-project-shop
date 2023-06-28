package com.h9w.shop.product.model.repository;

import com.h9w.shop.ShopApplication;
import com.h9w.shop.config.BeanConfiguration;
import com.h9w.shop.config.JpaCongifuration;
import com.h9w.shop.product.model.dto.SearchInfoDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

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
        SearchInfoDTO searchInfo = new SearchInfoDTO();

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
        SearchInfoDTO searchInfo = new SearchInfoDTO();
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
        SearchInfoDTO searchInfo = SearchInfoDTO.builder().searchValue(null).categoryNo(3).statusNo(2).build();

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
        SearchInfoDTO searchInfo = SearchInfoDTO.builder().searchValue("테스트").categoryNo(1).statusNo(1).build();

        //when
        Long counts = repo.findProductsCountBySearchInfos(searchInfo);

        //then
        assertNotNull(counts);

        System.out.println(counts);

    }
}