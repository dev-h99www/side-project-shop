package com.h9w.shop.purchase.model.repository;

import com.h9w.shop.purchase.model.entity.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {
}
