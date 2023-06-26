package com.h9w.shop.members.model.repository;

import com.h9w.shop.members.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberForMembersRepository extends JpaRepository<Member, Integer> {
    boolean existsByMemberId(String memberId);

    Member findByMemberId(String memberId);
}
