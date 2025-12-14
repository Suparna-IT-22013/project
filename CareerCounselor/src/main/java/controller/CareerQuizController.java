package com.example.careercounselor.controller;

import com.example.careercounselor.model.QuizResponse;
import com.example.careercounselor.service.JobSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job")
@CrossOrigin(origins = "*")
public class CareerQuizController {

    @Autowired
    private JobSuggestionService jobService;

    @PostMapping("/suggest")
    public ResponseEntity<List<String>> getSuggestions(@RequestBody QuizResponse response) {
        try {
            List<String> suggestions = jobService.suggestJobs(response.getSkills());
            return ResponseEntity.ok(suggestions);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}