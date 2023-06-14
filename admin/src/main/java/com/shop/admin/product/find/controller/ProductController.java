package com.shop.admin.product.find.controller;

import com.shop.admin.product.find.entity.Product;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("")
    public String getProduct() {

        return "return";
    }
    @PostMapping("/product/regist")
    public String registProduct(@RequestBody Product registInfo) {

        System.out.println(registInfo);

        return "regist";
    }
}
