package com.code.market.product.entity;

import com.code.market.base.BaseEntity;
import com.code.market.cart.entity.Cart;
import com.code.market.market.entity.Market;
import com.code.market.question.entity.Question;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Product extends BaseEntity {
    private String name;
    private String description;
    private int price;
    private int hitCount;
    private String isActive;

    @ManyToOne
    private Market market;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private List<Question> questionList;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private List<Cart> cartList;
}
