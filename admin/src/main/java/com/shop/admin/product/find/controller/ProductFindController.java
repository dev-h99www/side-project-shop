package com.shop.admin.product.find.controller;

import com.shop.admin.product.find.model.dto.PageInfoDTO;
import com.shop.admin.product.find.model.dto.ProductDTO;
import com.shop.admin.product.find.model.service.ProductFindService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.shop.admin.common.Address.FRONT_ADDRESS;

@CrossOrigin(originPatterns = FRONT_ADDRESS)
@RestController
@RequestMapping("/products")
public class ProductFindController {

    private final ProductFindService service;

    public ProductFindController(ProductFindService service) {
        this.service = service;
    }

    @GetMapping("counts")
    public long finaProductsCount(@PathVariable("productStatusNo") int productStatusNo) {

        return service.findProductsCount(productStatusNo);
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
