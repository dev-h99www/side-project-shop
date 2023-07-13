package com.h9w.shop.purchase.model.service;

import com.h9w.shop.common.DateFormatting;
import com.h9w.shop.common.model.ResponseDTO;
import com.h9w.shop.purchase.model.dto.PurchaseDTO;
import com.h9w.shop.purchase.model.dto.RegistInfoDTO;
import com.h9w.shop.purchase.model.entity.Purchase;
import com.h9w.shop.purchase.model.entity.PurchaseHistory;
import com.h9w.shop.purchase.model.repository.PurchaseHistoryCategoryRepository;
import com.h9w.shop.purchase.model.repository.PurchaseHistoryRepository;
import com.h9w.shop.purchase.model.repository.PurchaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class PurchaseService {
    private final int HISTOCY_CATEGORY_PURCHASE = 1;
    private final int HISTOCY_CATEGORY_DELIVERY = 2;
    private final int HISTOCY_CATEGORY_CANCEL = 3;
    private final int HISTOCY_CATEGORY_DONE = 4;

    private final PurchaseRepository purchaseRepo;
    private final ModelMapper mapper;
    private final PurchaseHistoryRepository historyRepo;
    private final PurchaseHistoryCategoryRepository historyCategoryRepo;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepo, ModelMapper mapper, PurchaseHistoryRepository historyRepo, PurchaseHistoryCategoryRepository historyCategoryRepo) {
        this.purchaseRepo = purchaseRepo;
        this.mapper = mapper;
        this.historyRepo = historyRepo;
        this.historyCategoryRepo = historyCategoryRepo;
    }

    /* 구매정보를 상품구매의 비즈니스 로직을 담당하는 메소드
    * 1. 상품 구매 내역 테이블에 구매내역 추가
    * 2. 상품 구매 이력 테이블에 이력 추가
    *
    * */
    public ResponseDTO registPurchase(RegistInfoDTO registInfo) {

        try{
            //registInfo의 정보를 TBL_PAYMENT에 삽입
            Purchase registPurchase = Purchase.builder().productNo(registInfo.getProductNo()).memberNo(registInfo.getMemberNo())
                    .orderDate(DateFormatting.getDate()).amount(registInfo.getAmount()).totalPrice(registInfo.getTotalPrice()).build();

            purchaseRepo.save(registPurchase);

            //위에 생성된 구매 내역 번호를 참고하여 구매 이력 테이블에 삽입
            PurchaseHistory history = PurchaseHistory.builder().historyDate(DateFormatting.getDate()).purchaseNo(registPurchase.getPurchaseNo())
                    .purchaseHistoryCategoryNo(HISTOCY_CATEGORY_PURCHASE).build();

            historyRepo.save(history);

            return ResponseDTO.setSuccess("regist purchase success", mapper.map(registPurchase, PurchaseDTO.class));
        } catch(Exception e) {

            return ResponseDTO.setFailed("regist purchase fail");
        }
    }
}
