package com.shop.admin.members.model.repository;

import com.shop.admin.members.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberForMembersRepository extends JpaRepository<Member, Integer> {
    boolean existsByMemberId(String memberId);

    Member findByMemberId(String memberId);
}
