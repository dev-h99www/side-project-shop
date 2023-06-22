package com.shop.admin.members.model.service;

import com.shop.admin.common.EncryptHelper;
import com.shop.admin.members.model.repository.MemberForMembersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final ModelMapper mapper;
    private final EncryptHelper encrypt;
    private final MemberForMembersRepository memberRepo;

    @Autowired
    public MemberService(ModelMapper mapper, EncryptHelper encrypt, MemberForMembersRepository memberRepo) {
        this.mapper = mapper;
        this.encrypt = encrypt;
        this.memberRepo = memberRepo;
    }
}
