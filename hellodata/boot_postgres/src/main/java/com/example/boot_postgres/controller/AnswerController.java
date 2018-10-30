package com.example.boot_postgres.controller;

import com.example.boot_postgres.repository.AnswerRepository;
import com.example.boot_postgres.repository.QuestionRepository;
import com.example.boot_postgres.exception.ResourceNotFoundException;
import com.example.boot_postgres.model.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AnswerController {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions/{questionId}/answers")
    public List<Answer> getAnswersByQuestionId(@PathVariable Long questionId) {
        return answerRepository.findByQuestionId(questionId);
    }

    @PostMapping("/questions/{questionId/answers")
    public Answer addAnswer(@PathVariable Long questionId,
                            @Valid @RequestBody Answer answer) {
        return questionRepository.findById(questionId)
            .map(question -> {
                answer.setQuestion(question);
                return answerRepository.save(answer);
            }).orElseThrow(() -> new ResourceNotFoundException("Question not found for id " + questionId));
    }

    @PutMapping("/questions/{questionId}/answers/{answerId}")
    public Answer updateAnswer(@PathVariable Long questionId,
                               @PathVariable Long answerId,
                               @Valid @RequestBody Answer answerRequest) {
        if(!questionRepository.existsById(questionId)) {
            throw new ResourceNotFoundException("Question not found for id " + questionId);            
        }
        return answerRepository.findById(answerId)
           .map(answer -> {
              answer.setText(answerRequest.getText());
              return answerRepository.save(answer);
           }).orElseThrow(()-> new ResourceNotFoundException("Answer not found for id " + answerId));        
    }

    @DeleteMapping("/questions/{questionId}/answers/{answerId}")
    public ResponseEntity<?> deleteAnswer(@PathVariable Long questionId,
                                          @PathVariable Long answerId) {
        if(!questionRepository.existsById(questionId)) {
            throw new ResourceNotFoundException("Question not found with id " + questionId);
        }

        return answerRepository.findById(answerId)
                .map(answer -> {
                    answerRepository.delete(answer);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Answer not found with id " + answerId));

    }

}