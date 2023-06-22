package com.shop.admin.members.controller;

import com.shop.admin.members.model.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import static com.shop.admin.common.Address.FRONT_ADDRESS;

@CrossOrigin(originPatterns = FRONT_ADDRESS)
@RestController
@RequestMapping("/members")
public class MemberController {

    @PostMapping("login")
    public String loginCheck(@RequestBody MemberDTO loginInfo) {

        System.out.println(loginInfo);

        return "success";
    }
}
