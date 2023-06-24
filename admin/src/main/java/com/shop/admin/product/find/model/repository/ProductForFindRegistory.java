package com.shop.admin.product.find.model.repository;

import com.shop.admin.product.find.model.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductForFindRegistory extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT COUNT(*)\n" +
            "FROM TBL_PRODUCT A\n" +
            "WHERE A.PRODUCT_STATUS_NO = :productStatusNo",
            nativeQuery = true)
    int countByProductStatusNo(int productStatusNo);

    List<Product> findByProductCategory_ProductCategoryNoAndProductStatus_ProductStatusNo(int productCategoryNo, int productStatusNo, Pageable pageable);
}
