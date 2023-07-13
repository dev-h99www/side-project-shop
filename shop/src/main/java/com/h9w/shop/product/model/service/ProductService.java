package com.h9w.shop.product.model.service;

import com.h9w.shop.common.model.ResponseDTO;
import com.h9w.shop.product.model.dto.*;
import com.h9w.shop.product.model.entity.Product;
import com.h9w.shop.product.model.repository.ProductCategoryRepository;
import com.h9w.shop.product.model.repository.ProductRepository;
import com.h9w.shop.product.model.repository.ProductStatusRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ProductService {

    private final ModelMapper mapper;
    private final ProductCategoryRepository categoryRepo;
    private final ProductStatusRepository statusRepo;
    private final ProductRepository productRepo;


    public ProductService(ModelMapper mapper, ProductCategoryRepository categoryRepo, ProductStatusRepository statusRepo, ProductRepository productRepo) {
        this.mapper = mapper;
        this.categoryRepo = categoryRepo;
        this.statusRepo = statusRepo;
        this.productRepo = productRepo;
    }

    public ResponseDTO findProductsBySearchCondition(PageInfoDTO pageInfo) {
        try {
            pageInfo.setTotalItemCount(productRepo.findProductsCountBySearchInfos(pageInfo).intValue());
            Pageable pageable = PageRequest.of(pageInfo.getPage() < 0? 0: pageInfo.getPage() - 1, pageInfo.getPageItemCount());

            List<Product> products = productRepo.findProductsBySearchInfos(pageInfo, pageable);

            ProductsDTO result = ProductsDTO.builder().products(products.stream().map(product -> mapper.map(product, ProductDTO.class)).collect(Collectors.toList()))
                    .pageInfo(pageInfo.setObjectToValue()).build();

            return ResponseDTO.setSuccess("find products success", result);
        } catch(Exception e) {

            return ResponseDTO.setFailed("error occurred");
        }
    }

    public ResponseDTO findProductByProductNo(int productNo) {

        try {

            return ResponseDTO.setSuccess("find product success", mapper.map(productRepo.findById(productNo).get(), ProductDTO.class));
        } catch(Exception e) {

            return ResponseDTO.setFailed("find product error");
        }
    }

    public List<ProductStatusDTO> findAllProductStatus() {

        return statusRepo.findAll().stream().map(productStatus -> mapper.map(productStatus, ProductStatusDTO.class)).collect(Collectors.toList());
    }
    public List<ProductCategoryDTO> findAllProductCategories() {

        return categoryRepo.findAll().stream().map(category -> mapper.map(category, ProductCategoryDTO.class)).collect(Collectors.toList());
    }

    public ResponseDTO registProduct(ProductDTO registInfo) {
        int registNo = productRepo.save(mapper.map(registInfo, Product.class)).getProductNo();
        Product product = productRepo.findById(registNo).get();

        if(!productNullCheck(product)) {
            productRepo.deleteById(registNo);

            return ResponseDTO.setFailed("regist failed");
        }
        return ResponseDTO.setSuccess("regist success", mapper.map(product, ProductDTO.class));
    }

    private boolean productNullCheck(Product product) {

        return product.getProductCategory() != null
                && product.getProductDate() != null && !product.getProductDate().equals("")
                && product.getProductName() != null && !product.getProductName().equals("")
                && product.getProductPrice() != 0
                && product.getProductCategory() != null
                && product.getProductStatus() != null;
    }
}
