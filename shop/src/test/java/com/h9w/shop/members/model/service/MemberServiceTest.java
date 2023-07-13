package com.h9w.shop.members.model.service;

import com.h9w.shop.ShopApplication;
import com.h9w.shop.config.BeanConfiguration;
import com.h9w.shop.config.JpaCongifuration;
import com.h9w.shop.members.model.dto.MemberDTO;
import com.h9w.shop.common.model.ResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JpaCongifuration.class,
        ShopApplication.class
})
class MemberServiceTest {

    @Autowired private MemberService service;
    @Autowired private ModelMapper mapper;

    @Test
    public void initTest() {

        assertNotNull(service);
    }

    @Test
    @Transactional
    @DisplayName("회원가입 성공 테스트")
    public void signUp_success_test() {
        //given
        MemberDTO signUpInfo = MemberDTO.builder().memberNo(0).memberId("user03@gmail.com")
                .memberName("유저03").memberPassword("user03").memberRole(null).build();

        //when
        ResponseDTO response = service.signUp(signUpInfo);

        //then
        assertNotNull(response);
        assertTrue(response.isResult());

        System.out.println(response);
    }

    @Test
    @DisplayName("회원가입 실패 테스트")
    @Transactional
    public void signUp_fail_test() {
        //given
        MemberDTO signUpInfo = MemberDTO.builder().memberNo(0).memberId("user03@gmail.com")
                .memberName("유저03").memberPassword("user03").memberRole(null).build();

        //when
        service.signUp(signUpInfo);
        ResponseDTO response = service.signUp(signUpInfo);


        //then
        assertNotNull(response);
        assertFalse(response.isResult());

        System.out.println(response);
    }

    @Test
    @DisplayName("이메일 없을 시 로그인 실패 테스트")
    public void login_fail_email_not_extist_test() {
        //given
        MemberDTO loginInfo = new MemberDTO();

        //when
        ResponseDTO response = service.logIn(loginInfo);

        //then
        assertNotNull(response);
        assertFalse(response.isResult());
        assertEquals(response.getMessage(), "Email not exist");

        System.out.println(response);

    }

    @Test
    @DisplayName("비밀번호 불일치 로그인 실패 테스트")
    @Transactional
    void login_fail_password_not_match_test() {

        //given
        MemberDTO signUpInfo = MemberDTO.builder().memberNo(0).memberId("user03@gmail.com")
                .memberName("유저03").memberPassword("user03").memberRole(null).build();

        MemberDTO loginInfo = new MemberDTO();
        loginInfo.setMemberId("user03@gmail.com");

        //when
        service.signUp(signUpInfo);

        ResponseDTO response = service.logIn(loginInfo);

        //then
        assertNotNull(response);
        assertFalse(response.isResult());
        assertEquals(response.getMessage(), "Password does not match");

        System.out.println(response);
    }

    @Test
    @DisplayName("로그인 성공 테스트")
    @Transactional
    void login_success_test() {

        //given
        MemberDTO signUpInfo = MemberDTO.builder().memberNo(0).memberId("user03@gmail.com")
                .memberName("유저03").memberPassword("user03").memberRole(null).build();

        MemberDTO loginInfo = new MemberDTO();
        loginInfo.setMemberId("user03@gmail.com");
        loginInfo.setMemberPassword("user03");

        //when
        service.signUp(signUpInfo);

        ResponseDTO response = service.logIn(loginInfo);

        //then
        assertNotNull(response);
        assertNotNull(response.getData());
        assertTrue(response.isResult());
        assertEquals(response.getMessage(), "Login Success");

        System.out.println(response);
    }
}