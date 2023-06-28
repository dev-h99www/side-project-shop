package com.h9w.shop.product.model.repository;

import com.h9w.shop.product.model.dto.SearchInfoDTO;

public interface ProductRepositoryCustom {

    public Long findProductsCountBySearchInfos(SearchInfoDTO searchInfo);
}
