package com.shop.admin.product.find.model.service;

import com.shop.admin.product.find.model.dto.PageInfoDTO;
import com.shop.admin.product.find.model.dto.ProductDTO;
import com.shop.admin.product.find.model.entity.Product;
import com.shop.admin.product.find.model.repository.ProductForFindRegistory;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductFindService {

    private final ModelMapper mapper;
    private final ProductForFindRegistory productRepo;

    public ProductFindService(ModelMapper mapper, ProductForFindRegistory productRepo) {
        this.mapper = mapper;
        this.productRepo = productRepo;
    }

    public List<ProductDTO> findAllProducts(PageInfoDTO pageInfo) {

        Pageable pageable = PageRequest.of(pageInfo.getPage() < 0? 0: pageInfo.getPage() - 1, pageInfo.getPageItemCount(), Sort.by("productNo").descending());
//        Page<Product> products = productRepo.findAll(pageable);
//        products.map(product -> mapper.map(product, ProductDTO.class)).stream().collect(Collectors.toList());
//        return productRepo.findAll().stream().map(product -> mapper.map(product, ProductDTO.class)).collect(Collectors.toList());

        return productRepo.findAll(pageable).map(product -> mapper.map(product, ProductDTO.class)).stream().collect(Collectors.toList());
    }

    public long findProductsCount() {

        return productRepo.count();
    }

    public ProductDTO findProductByProductNo(int productNo) {

        return mapper.map(productRepo.findById(productNo).get(), ProductDTO.class);
    }
}
