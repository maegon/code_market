package com.code.market.member.entity;

import com.code.market.base.BaseEntity;
import com.code.market.question.entity.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Member extends BaseEntity {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String isActive;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Question> questionList;
}
