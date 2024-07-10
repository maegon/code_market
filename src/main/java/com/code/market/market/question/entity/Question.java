package com.code.market.market.question.entity;

import com.code.market.market.base.BaseEntity;
import com.code.market.member.entity.Member;
import com.code.market.product.entity.Product;
import jakarta.persistence.Entity;

@Entity
public class Question extends BaseEntity {
    private String title;
    private String body;
    private Member member;
    private Product product;
}
