package com.code.market.member.repository;

import com.code.market.member.entity.Member;
import com.code.market.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
