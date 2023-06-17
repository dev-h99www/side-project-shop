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
    public long finaProductsCount() {

        return service.findProductsCount();
    }

    @GetMapping
    public List<ProductDTO> findAllProducts(@ModelAttribute("pageInfo") PageInfoDTO pageInfo) {

        return service.findAllProducts(pageInfo);
    }
}
