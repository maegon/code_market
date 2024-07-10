package com.code.market.question.controller;

import com.code.market.member.entity.Member;
import com.code.market.member.service.MemberService;
import com.code.market.product.entity.Product;
import com.code.market.product.service.ProductService;
import com.code.market.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;
    private final ProductService productService;
    private final MemberService memberService;

    @PostMapping("/create/{id}")
    public String create(@PathVariable("id") Long id,
                         Principal principal,
                         @RequestParam("content") String content) {
        Product product = productService.getProduct(id);
        Member member = memberService.findByUserName(principal.getName());

        questionService.create(product, member, content);

        return "redirect:/product/detail/" + id;
    }
}
