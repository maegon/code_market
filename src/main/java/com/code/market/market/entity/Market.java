package com.code.market.market.entity;

import com.code.market.base.BaseEntity;
import com.code.market.member.entity.Member;
import com.code.market.product.entity.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@SuperBuilder
public class Market extends BaseEntity {
    private String email;
    private String name;
    private String info;

    @OneToOne
    private Member member;

    @OneToMany(mappedBy = "market", cascade = CascadeType.REMOVE)
    private List<Product> productList;
}