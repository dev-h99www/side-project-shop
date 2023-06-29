package com.h9w.shop.product.model.repository;

import com.h9w.shop.product.model.dto.PageInfoDTO;
import com.h9w.shop.product.model.dto.SearchInfoDTO;
import com.h9w.shop.product.model.entity.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductRepositoryCustom {

    public Long findProductsCountBySearchInfos(SearchInfoDTO searchInfo);

    List<Product> findProductsBySearchInfos(SearchInfoDTO searchInfo, Pageable pageable);
}
