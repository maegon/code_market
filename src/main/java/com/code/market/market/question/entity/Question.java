package com.code.market.market.question.entity;

import com.code.market.market.base.BaseEntity;
import com.code.market.member.entity.Member;
import com.code.market.product.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Question extends BaseEntity {
    private String subject;
    private String content;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Product product;
}
