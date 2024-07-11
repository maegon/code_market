package com.code.market.global.initData;

import com.code.market.member.entity.Member;
import com.code.market.member.repository.MemberRepository;
import com.code.market.member.service.MemberService;
import com.code.market.product.repository.ProductRepository;
import com.code.market.product.service.ProductService;
import com.code.market.question.repository.QuestionRepository;
import com.code.market.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Profile("dev")
public class Dev {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public ApplicationRunner init(MemberService memberService, QuestionService questionService, ProductService productService) {
        return args -> {
            Member m1 = memberService.join("admin", "admin", "admin@test.com", "admin");
            Member m2 = memberService.join("user1", "user1", "user1@test.com", "user1");
            Member m3 = memberService.join("user2", "user2", "user2@test.com", "user2");

            for (int i = 1; i<=200; i++) {
                String name = String.format("테스트 상품 : [%03d]", i);
                int price = 1;
                productService.create(name, price);
            }

            questionService.create(productService.getProduct(1), m2, "비전공자도 들어도 수업진도 따라갈 수 있나요?");
            questionService.create(productService.getProduct(1), m3, "많이 비싼가요?");
            questionService.create(productService.getProduct(2), m3, "많이 어렵나요?");
            questionService.create(productService.getProduct(2), m2, "배고파요 저녁 뭐 먹을까요?");
        };
    }
}
