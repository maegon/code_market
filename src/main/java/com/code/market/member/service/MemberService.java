package com.code.market.member.service;

import com.code.market.member.entity.Member;
import com.code.market.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public Member join(String username, String password, String email, String nickname) {
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        member.setEmail(email);
        member.setNickname(nickname);
        member.setCreateDate(LocalDateTime.now());

        memberRepository.save(member);

        return member;
    }
}
