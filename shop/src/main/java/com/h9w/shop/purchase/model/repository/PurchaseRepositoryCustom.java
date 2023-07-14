package com.h9w.shop.purchase.model.repository;

import com.h9w.shop.purchase.model.dto.PageInfoDTO;
import com.h9w.shop.purchase.model.entity.Purchase;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PurchaseRepositoryCustom {
    List<Purchase> findAllBySearchInfo(PageInfoDTO searchInfo, Pageable pageable);

    Long findAllCountBySearchInfo(PageInfoDTO searchInfo);
}
