package com.code.market.question.service;

import com.code.market.member.entity.Member;
import com.code.market.product.entity.Product;
import com.code.market.question.entity.Question;
import com.code.market.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public void create(Product product, Member member, String content) {
        Question question = new Question();
        question.setProduct(product);
        question.setMember(member);
        question.setContent(content);
        questionRepository.save(question);
    }
}
