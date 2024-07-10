package com.code.market.market.answer.entity;

import com.code.market.market.question.entity.Question;
import com.code.market.member.entity.Member;
import jakarta.persistence.Entity;

@Entity
public class Answer {
    private String comment;
    private Member member;
    private Question question;
}
