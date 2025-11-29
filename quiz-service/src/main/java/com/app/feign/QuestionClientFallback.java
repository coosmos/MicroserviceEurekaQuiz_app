package com.app.feign;

import com.app.model.QuestionWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Slf4j
public class QuestionClientFallback implements QuestionClient {

    @Override
    public List<QuestionWrapper> getQuestionsForQuiz(int num, String category) {
        System.out.println(" Circuit Breaker open Question Service is down.");
        return new ArrayList<>();
    }

    @Override
    public String getCorrectAnswer(String id) {
       System.out.println(" Circuit Breaker open Question Service is down.");
        return "Question Service is unavailable. Please try again later.";
    }

    @Override
    public QuestionWrapper getQuestionById(String id) {
        System.out.println(" Circuit Breaker open Question Service is down.");
        return null;
    }
}