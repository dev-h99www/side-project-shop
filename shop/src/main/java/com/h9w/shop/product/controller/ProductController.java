package com.h9w.shop.product.controller;

import com.h9w.shop.common.model.ResponseDTO;
import com.h9w.shop.product.model.dto.PageInfoDTO;
import com.h9w.shop.product.model.dto.ProductCategoryDTO;
import com.h9w.shop.product.model.dto.ProductDTO;
import com.h9w.shop.product.model.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.h9w.shop.common.Address.FRONT_ADDRESS;

@CrossOrigin(originPatterns = FRONT_ADDRESS)
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    /**
     * findProductsBySearchCondition: 페이지 출력 조건을 입력받아 해당 페이지의 상품을 조회 후 반환
     * @param pageInfo: 현재 페이지, 전체 상품 개수, 한 페이지에 출력할 상품 개수 및 검색 조건
     * @return ResponseDTO: 조회 결과, 결과 메세지, 결과에 따른 데이터(상품의 정보 리스트)를 반환
     * */
    @GetMapping
    public ResponseDTO findProductsBySearchCondition(@ModelAttribute("pageInfo") PageInfoDTO pageInfo) {

        return service.findProductsBySearchCondition(pageInfo.setValueToObject());
    }

    /**
     * getCategories: 상품의 모든 카테고리를 조회 후 반환
     * @return List<ProductCategoryDTO>: 모든 카테고리를 반환
     * */
    @GetMapping("categories")
    public List<ProductCategoryDTO> getCategories() {

        return service.findAllProductCategories();
    }

    /**
     * registProduct : 상품 등록 정보를 전달받아 등록 후 등록에 대한 결과 반환
     * @param registInfo: 상품의 이름, 가격 카테고리
     * @return ResponseDTO: 상품 등록에대한 성공 실패 여부와 그에따른 메세지를 반환
     * */
    @PostMapping("regist")
    public ResponseDTO registProduct(@RequestBody ProductDTO registInfo) {

        return service.registProduct(registInfo);
    }

    /**
     * findProductByProductNo: 상품 번호를 전달받아 해당 상품의 정보를 조회 후 반환
     * @param productNo: 조회하려는 상품의 번호
     * @return ResponseDTO: 조회 성공여부와 해당 상품의 정보를 반환
     * */
    @GetMapping("{productNo}")
    public ResponseDTO findProductByProductNo(@PathVariable("productNo") int productNo) {

        return service.findProductByProductNo(productNo);
    }
}
