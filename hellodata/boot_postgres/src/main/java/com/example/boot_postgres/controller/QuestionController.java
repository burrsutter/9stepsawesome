package com.example.boot_postgres.controller;

import com.example.boot_postgres.repository.QuestionRepository;
import com.example.boot_postgres.model.Question;
import com.example.boot_postgres.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

@RestController
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions")
    public Page<Question> getQuestions(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @GetMapping("/questions/{questionId}")
    public Question getQuestion(@PathVariable Long questionId) {
        return questionRepository.findById(questionId)
        .map(question -> {            
            return question;
        }).orElseThrow(() -> new ResourceNotFoundException("YOUR Question not found with id " + questionId));

    }
    @PostMapping("/questions")
    public Question createQuestion(@Valid @RequestBody Question question) {
        return questionRepository.save(question);
    }

    @PutMapping("/questions/{questionId}")
    public Question updateQuestion(@PathVariable Long questionId,
                                   @Valid @RequestBody Question questionRequest) {
        return questionRepository.findById(questionId)
            .map(question -> {
                question.setTitle(questionRequest.getTitle());
                question.setDescription(questionRequest.getDescription());
                return questionRepository.save(question);
            }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
    }

    @DeleteMapping("/questions/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
        return questionRepository.findById(questionId)
            .map(question -> {
                questionRepository.delete(question);
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
    }
}