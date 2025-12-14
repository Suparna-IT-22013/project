package com.example.banglaquiz.controller;

import com.example.banglaquiz.model.QuizScore;
import com.example.banglaquiz.model.Student;
import com.example.banglaquiz.repository.QuizScoreRepository;
import com.example.banglaquiz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("studentId")
public class QuizController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private QuizScoreRepository quizScoreRepository;

    // ✅ Show login page on root path
    @GetMapping("/")
    public String showLoginPage() {
        return "student-login";
    }

    // ✅ Process login and validate student ID
    @PostMapping("/login")
    public String login(@RequestParam String studentId, Model model) {
        if (studentRepository.existsByStudentId(studentId)) {
            model.addAttribute("studentId", studentId); // Store in session
            return "redirect:/quiz";
        } else {
            model.addAttribute("error", "এই ছাত্র আইডি অনুমোদিত নয়!");
            return "error";
        }
    }

    // ✅ Display the quiz form only if student is logged in
    @GetMapping("/quiz")
    public String showQuiz(@ModelAttribute("studentId") String studentId, Model model) {
        if (studentId == null || studentId.isEmpty()) {
            model.addAttribute("error", "আপনি বৈধ ছাত্র নন। অনুগ্রহ করে লগইন করুন।");
            return "error";
        }
        return "quiz";
    }

    // ✅ Process quiz submission
    @PostMapping("/submit")
    public String submitQuiz(@ModelAttribute("studentId") String studentId,
                             @RequestParam String q1,
                             @RequestParam String q2,
                             Model model) {

        int score = 0;
        if (q1.equals("ঢাকা")) score += 13;
        if (q2.equals("পাইথন")) score += 13;

        QuizScore quizScore = new QuizScore();
        quizScore.setStudentId(studentId);
        quizScore.setScore(score);
        quizScoreRepository.save(quizScore);

        model.addAttribute("score", score);
        return "result";
    }
}
