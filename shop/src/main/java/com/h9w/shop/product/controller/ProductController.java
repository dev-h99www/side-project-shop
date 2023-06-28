package com.h9w.shop.product.controller;

import com.h9w.shop.members.model.dto.ResponseDTO;
import com.h9w.shop.product.model.dto.PageInfoDTO;
import com.h9w.shop.product.model.dto.ProductCategoryDTO;
import com.h9w.shop.product.model.dto.ProductDTO;
import com.h9w.shop.product.model.dto.SearchInfoDTO;
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

    @GetMapping("regist")
    public List<ProductCategoryDTO> getProduct() {

        System.out.println("getmapping product/regist calls");

        return service.findAllProductCategories();
    }

    @PostMapping("regist")
    public ResponseDTO registProduct(@RequestBody ProductDTO registInfo) {

        return service.registProduct(registInfo);
    }

    @GetMapping("counts")
    public long finaProductsCount(@ModelAttribute("searchInfo") SearchInfoDTO searchInfo) {

        return service.findProductsCount(searchInfo);
    }

    @GetMapping
    public List<ProductDTO> findAllProducts(@ModelAttribute("pageInfo") PageInfoDTO pageInfo) {

        List<ProductDTO> list = service.findAllProducts(pageInfo);
        return service.findAllProducts(pageInfo);
    }

    @GetMapping("{productNo}")
    public ProductDTO findProductByProductNo(@PathVariable("productNo") int productNo) {

        return service.findProductByProductNo(productNo);
    }
}
