package com.h9w.shop.purchase.model.repository;

import com.h9w.shop.purchase.model.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
