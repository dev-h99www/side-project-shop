package com.h9w.shop.members.model.repository;

import com.h9w.shop.AdminApplication;
import com.h9w.shop.config.BeanConfiguration;
import com.h9w.shop.config.JpaCongifuration;
import com.h9w.shop.members.model.entity.Member;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {
        BeanConfiguration.class,
        JpaCongifuration.class,
        AdminApplication.class
})
class MemberForMembersRepositoryTest {

    @Autowired
    private MemberForMembersRepository repo;

    @Test
    public void initTest() {
        assertNotNull(repo);
    }

    @Test
    @Transactional
    public void signupTest() {
        Member newMember = Member.builder().memberId("user01@gmail.com").memberName("유저01").memberPassword("$2a$12$B5JhT9DH4NJDXdZ31y2I8uYPqty/y0GkdtqZiyFy3.8uwkXPUUEuW").memberRole("ROLE_USER").memberNo(0).build();

        assertDoesNotThrow(() -> repo.save(newMember));
    }
}