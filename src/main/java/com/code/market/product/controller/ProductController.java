package com.code.market.product.controller;

import com.code.market.product.entity.Product;
import com.code.market.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    @GetMapping("/list")
    public String list(Model model) {
        List<Product> productLit = productService.getList();
        model.addAttribute("productList", productLit);
        return "product/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") long id, Model model) {
        Product product = productService.getProduct(id);

        model.addAttribute("product", product);

        return "product/detail";
    }
}
