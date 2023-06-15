package com.shop.admin.product.regist.service;

import com.shop.admin.product.regist.dto.ProductCategoryDTO;
import com.shop.admin.product.regist.dto.ProductDTO;
import com.shop.admin.product.regist.entity.Product;
import com.shop.admin.product.regist.repository.ProductCategoryForProductRegistRepository;
import com.shop.admin.product.regist.repository.ProductForProductRegistRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductRegistService {

    private final ModelMapper mapper;
    private final ProductCategoryForProductRegistRepository productCategoryRepo;
    private final ProductForProductRegistRepository productRepo;

    @Autowired
    public ProductRegistService(ModelMapper mapper, ProductCategoryForProductRegistRepository productCategoryRepo, ProductForProductRegistRepository productRepo) {
        this.mapper = mapper;
        this.productCategoryRepo = productCategoryRepo;
        this.productRepo = productRepo;
    }

    public List<ProductCategoryDTO> findAllProductCategories() {

        return productCategoryRepo.findAll().stream().map(category -> mapper.map(category, ProductCategoryDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public ProductDTO registProduct(ProductDTO registInfo) {

        int registNo = productRepo.save(mapper.map(registInfo, Product.class)).getProductNo();

        return mapper.map(productRepo.findById(registNo).get(), ProductDTO.class);
    }
}
