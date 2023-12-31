package com.h9w.shop.product.model.service;

import com.h9w.shop.ShopApplication;
import com.h9w.shop.config.BeanConfiguration;
import com.h9w.shop.config.JpaCongifuration;
import com.h9w.shop.common.model.ResponseDTO;
import com.h9w.shop.product.model.dto.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JpaCongifuration.class,
        ShopApplication.class
})
class ProductServiceTest {

    @Autowired ProductService service;

    @Test
    public void initTest() {
        assertNotNull(service);
    }

    @Test
    @Transactional
    @DisplayName("상품등록 테스트")
    public void registProduct_test() {
        //given
        ProductStatusDTO productStatus = ProductStatusDTO.builder().productStatusNo(1).productStatusName("진행중").build();
        ProductCategoryDTO productCategory = ProductCategoryDTO.builder().productCategoryNo(1).productCategoryName("음식").build();

        ProductDTO registInfo = ProductDTO.builder().productNo(0).productDate("2021-05-12 11:22:10").productName("test1").productPrice(10000)
                .productCategory(productCategory).productStatus(productStatus).build();

        //when
        ResponseDTO response = service.registProduct(registInfo);

        //given
        assertNotNull(response);
        assertNotNull(response.getData());
        assertTrue(response.isResult());
        assertEquals(response.getMessage(), "regist success");

        System.out.println(response);
    }

    @Test
    @Transactional
    @DisplayName("상품등록 실패 테스트")
    public void registProduct_fail_test() {
        //given
        ProductDTO registInfo = new ProductDTO();

        //when
        ResponseDTO response = service.registProduct(registInfo);

        //given
        assertNotNull(response);
        assertFalse(response.isResult());
        assertEquals(response.getMessage(), "regist failed");
        System.out.println(response);

    }

    @Test
    @DisplayName("카테고리 조회 테스트")
    public void findAllProductCategorires_test() {
        //when
        List<ProductCategoryDTO> categories = service.findAllProductCategories();

        //then
        assertNotNull(categories);

        categories.forEach(System.out::println);
    }

    @Test
    @DisplayName("상품 상태 조회 테스트")
    public void findAllProductStatus_test() {
        //when
        List<ProductStatusDTO> statusList = service.findAllProductStatus();

        //then
        assertNotNull(statusList);

        statusList.forEach(System.out::println);
    }

    @Test
    @DisplayName("상품번호로 상품 상세조회 테스트")
    public void findProductByProductNo_test() {
        //given
        int productNo = 10;

        //when
        ResponseDTO result = service.findProductByProductNo(productNo);

        //then
        assertNotNull(result);
        System.out.println(result);
    }

    @Test
    @DisplayName("조건 없이 상품 조회 테스트")
    public void findProductsBySearchCondition_test1() {
        //given
        int page = 1;
        PageInfoDTO pageInfo = PageInfoDTO.builder().page(page).pageItemCount(10).totalItemCount(0).build();

        //when
        ResponseDTO result = service.findProductsBySearchCondition(pageInfo);

        //then
        assertNotNull(result);

        System.out.println(result);
    }

    @Test
    @DisplayName("카테고리, 상태, 검색어 조건으로 상품 조회 테스트")
    public void findProductsBySearchCondition_test2() {
        //given
        int page = 1;
        PageInfoDTO pageInfo = PageInfoDTO.builder().page(page).pageItemCount(10).totalItemCount(17).searchValue("테스트").categoryNo(1).statusNo(1).build();

        //when
        ResponseDTO result = service.findProductsBySearchCondition(pageInfo);

        //then
        assertNotNull(result);

        System.out.println(result);
    }
}