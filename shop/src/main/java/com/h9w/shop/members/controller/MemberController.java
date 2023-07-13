package com.h9w.shop.members.controller;

import com.h9w.shop.members.model.dto.MemberDTO;
import com.h9w.shop.common.model.ResponseDTO;
import com.h9w.shop.members.model.dto.SignInResponseDTO;
import com.h9w.shop.members.model.service.MemberService;
import org.springframework.web.bind.annotation.*;

import static com.h9w.shop.common.Address.FRONT_ADDRESS;

@CrossOrigin(originPatterns = FRONT_ADDRESS)
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping("login")
    public ResponseDTO<SignInResponseDTO> login(@RequestBody MemberDTO loginInfo) {

        return service.logIn(loginInfo);
    }

    @PostMapping("signup")
    public ResponseDTO<?> signup(@RequestBody MemberDTO memberInfo) {

        return service.signUp(memberInfo);
    }
}
