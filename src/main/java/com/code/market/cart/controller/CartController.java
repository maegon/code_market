package com.code.market.cart.controller;

import com.code.market.cart.service.CartService;
import com.code.market.member.entity.Member;
import com.code.market.member.service.MemberService;
import com.code.market.product.entity.Product;
import com.code.market.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final ProductService productService;
    private final MemberService memberService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/list")
    public String list() {
        return "cart/list";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/add/{id}")
    public String add(@PathVariable("id") Long id, Principal principal) {
        Product product = productService.getProduct(id);
        Member member = memberService.findByUserName(principal.getName());

        cartService.add(product, member);

        return "redirect:/cart/list";
    }
}
