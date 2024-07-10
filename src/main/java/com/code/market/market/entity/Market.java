package com.code.market.market.entity;

import com.code.market.market.base.BaseEntity;
import com.code.market.member.entity.Member;
import com.code.market.product.entity.Product;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Market extends BaseEntity {
    private String email;
    private String name;
    private String info;
    private Member member;
    private List<Product> productList;
}