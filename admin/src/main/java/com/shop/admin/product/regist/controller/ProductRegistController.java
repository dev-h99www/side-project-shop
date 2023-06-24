package com.shop.admin.product.regist.controller;

import com.shop.admin.product.regist.dto.ProductCategoryDTO;
import com.shop.admin.product.regist.dto.ProductDTO;
import com.shop.admin.product.regist.service.ProductRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.shop.admin.common.Address.*;

@CrossOrigin(originPatterns = FRONT_ADDRESS)
@RestController
@RequestMapping("/products")
public class ProductRegistController {

    private final ProductRegistService service;

    @Autowired
    public ProductRegistController(ProductRegistService service) {
        this.service = service;
    }

    @GetMapping("regist")
    public List<ProductCategoryDTO> getProduct() {

        System.out.println("getmapping product/regist calls");

        return service.findAllProductCategories();
    }
    @PostMapping("regist")
    public ProductDTO registProduct(@RequestBody ProductDTO registInfo) {

        return service.registProduct(registInfo);
    }
}
