package com.h9w.shop.purchase.controller;

import com.h9w.shop.common.model.ResponseDTO;
import com.h9w.shop.purchase.model.dto.PageInfoDTO;
import com.h9w.shop.purchase.model.dto.RegistInfoDTO;
import com.h9w.shop.purchase.model.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.h9w.shop.common.Address.FRONT_ADDRESS;

@CrossOrigin(originPatterns = FRONT_ADDRESS)
@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService service;

    @Autowired
    public PurchaseController(PurchaseService service) {
        this.service = service;
    }


    /**
     * @param registInfo: 상품 등록에 필요한 상품번호, 구매 수량, 구매자 번호, 총 가격을 전달받는다
     * */
    @PostMapping
    public ResponseDTO registPurchase(@RequestBody RegistInfoDTO registInfo) {

        return service.registPurchase(registInfo);
    }

    @GetMapping
    public ResponseDTO findPurchases(@RequestBody PageInfoDTO searchInfo) {

        System.out.println(searchInfo);
        return service.findPurchases(searchInfo);
    }
}
