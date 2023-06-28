package com.h9w.shop.product.model.service;

import com.h9w.shop.members.model.dto.ResponseDTO;
import com.h9w.shop.product.model.dto.*;
import com.h9w.shop.product.model.entity.Product;
import com.h9w.shop.product.model.repository.ProductCategoryRepository;
import com.h9w.shop.product.model.repository.ProductRepository;
import com.h9w.shop.product.model.repository.ProductStatusRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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

//    /** params : 상품의 카테고리, 상태, 검색어
//     *  return : 조회되는 row의 갯수
//     *
//     *  comments : 상품의 카테고리, 상태, 검색어 를 입력받아 조회되는 row 수를 반환한다.
//     * */
//    public Long findProductsCount(SearchInfoDTO searchInfo) {
//
//        return productRepo.findProductsCountBySearchInfos(searchInfo);
//    }

    public ResponseDTO findProductsBySearchCondition(PageInfoDTO pageInfo) {

        Pageable pageable = PageRequest.of(pageInfo.getPage() < 0? 0: pageInfo.getPage() - 1, pageInfo.getPageItemCount(), Sort.by("productNo").descending());
//        Page<Product> products = productRepo.findAll(pageable);
//        products.map(product -> mapper.map(product, ProductDTO.class)).stream().collect(Collectors.toList());
//        return productRepo.findAll().stream().map(product -> mapper.map(product, ProductDTO.class)).collect(Collectors.toList());
//        productRepo.findAll(pageable).map(product -> mapper.map(product, ProductDTO.class)).stream().collect(Collectors.toList())
        return null;
    }

    public ProductDTO findProductByProductNo(int productNo) {

        return mapper.map(productRepo.findById(productNo).get(), ProductDTO.class);
    }

    public List<ProductStatusDTO> findAllProductStatus() {

        return statusRepo.findAll().stream().map(productStatus -> mapper.map(productStatus, ProductStatusDTO.class)).collect(Collectors.toList());
    }
    public List<ProductCategoryDTO> findAllProductCategories() {

        return categoryRepo.findAll().stream().map(category -> mapper.map(category, ProductCategoryDTO.class)).collect(Collectors.toList());
    }

    @Transactional
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
