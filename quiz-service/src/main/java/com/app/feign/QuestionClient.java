package com.app.feign;

import com.app.model.QuestionWrapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "question-service",
        fallback = QuestionClientFallback.class
)
public interface QuestionClient {

    @CircuitBreaker(name = "myCircuitBreaker")
    @GetMapping("/question/generate")
    List<QuestionWrapper> getQuestionsForQuiz(@RequestParam int num, @RequestParam String category);

    @CircuitBreaker(name = "myCircuitBreaker")
    @GetMapping("/question/correct-answer/{id}")
    String getCorrectAnswer(@PathVariable String id);

    @CircuitBreaker(name = "myCircuitBreaker")
    @GetMapping("/question/{id}")
    QuestionWrapper getQuestionById(@PathVariable String id);
}
