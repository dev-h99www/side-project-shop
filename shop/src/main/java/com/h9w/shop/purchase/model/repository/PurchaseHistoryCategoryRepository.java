package com.h9w.shop.purchase.model.repository;

import com.h9w.shop.purchase.model.entity.PurchaseHistoryCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseHistoryCategoryRepository extends JpaRepository<PurchaseHistoryCategory, Integer> {
}
