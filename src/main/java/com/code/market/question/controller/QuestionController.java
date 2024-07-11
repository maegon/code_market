package com.code.market.question.controller;

import com.code.market.member.entity.Member;
import com.code.market.member.service.MemberService;
import com.code.market.product.entity.Product;
import com.code.market.product.service.ProductService;
import com.code.market.question.entity.Question;
import com.code.market.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;
    private final ProductService productService;
    private final MemberService memberService;

    @PostMapping("/create/{id}")
    public String create(@PathVariable("id") Long id, Principal principal, @RequestParam("content") String content) {
        Product product = productService.getProduct(id);
        Member member = memberService.findByUserName(principal.getName());

        questionService.create(product, member, content);

        return "redirect:/product/detail/" + id;
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable("id") Long id, Model model) {
        Question question = questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question/modify";
    }

    @PostMapping("/modify/{id}")
    public String modify(@PathVariable("id") Long id, Principal principal, @RequestParam("content") String content) {
        Question question = questionService.getQuestion(id);
            questionService.modify(question, content);
            long productId = question.getProduct().getId();

        return "redirect:/product/detail/" + productId;
    }
}
