package com.shop.admin.members.model.service;

import com.shop.admin.common.EncryptHelper;
import com.shop.admin.common.TokenProvider;
import com.shop.admin.members.model.dto.MemberDTO;
import com.shop.admin.members.model.dto.ResponseDTO;
import com.shop.admin.members.model.dto.SignInResponseDTO;
import com.shop.admin.members.model.entity.Member;
import com.shop.admin.members.model.repository.MemberForMembersRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final TokenProvider tokenProvider;
    private final ModelMapper mapper;
    private final EncryptHelper encrypt;
    private final MemberForMembersRepository memberRepo;

    @Autowired
    public MemberService(TokenProvider tokenProvider, ModelMapper mapper, EncryptHelper encrypt, MemberForMembersRepository memberRepo) {
        this.tokenProvider = tokenProvider;
        this.mapper = mapper;
        this.encrypt = encrypt;
        this.memberRepo = memberRepo;
    }

    @Transactional
    public ResponseDTO<?> signUp(MemberDTO memberInfo) {

        if(memberRepo.existsByMemberId(memberInfo.getMemberId())) {
            return ResponseDTO.setFailed("Existed Email");
        }

        Member signupInfo = mapper.map(memberInfo, Member.class);
        signupInfo.setMemberRole("ROLE_USER");
        signupInfo.setMemberPassword(encrypt.encrypt(memberInfo.getMemberPassword()));

        memberRepo.save(signupInfo);

        return ResponseDTO.setSuccess("Sign Up Success",
                /*mapper.map(signupInfo, MemberDTO.class)*/
                null);
    }

    public ResponseDTO<SignInResponseDTO> logIn(MemberDTO loginInfo) {

        int exprTime = 3600000;
        String memberId = loginInfo.getMemberId();

        if(!memberRepo.existsByMemberId(memberId)) {

            return ResponseDTO.setFailed("Email not exists");
        }

        Member memberInfo = memberRepo.findByMemberId(memberId);

        if(!encrypt.isMatch(loginInfo.getMemberPassword(), memberInfo.getMemberPassword())) {

            return ResponseDTO.setFailed("Password does not match");
        }

        MemberDTO member = mapper.map(memberInfo, MemberDTO.class);

        String token = tokenProvider.create(member);

        return ResponseDTO.setSuccess("Login Success", new SignInResponseDTO(token, exprTime, member));
    }
}
