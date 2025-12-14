package com.example.careercounselor.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class JobSuggestionService {

    public List<String> suggestJobs(List<String> skills) {
        if (skills == null || skills.isEmpty()) {
            return List.of("Career Counselor Consultation Recommended");
        }

        Set<String> jobs = new HashSet<>();

        for (String skill : skills) {
            if (skill == null) continue;

            String normalizedSkill = skill.toLowerCase().trim();
            switch (normalizedSkill) {
                case "cp":
                    jobs.add("Software Engineer");
                    jobs.add("Competitive Programming Coach");
                    break;
                case "ml":
                    jobs.add("Machine Learning Engineer");
                    jobs.add("Data Scientist");
                    jobs.add("AI Research Scientist");
                    break;
                case "research":
                    jobs.add("Research Scientist");
                    jobs.add("Academic Researcher");
                    jobs.add("R&D Engineer");
                    break;
                case "developing":
                    jobs.add("Web Developer");
                    jobs.add("Mobile App Developer");
                    jobs.add("Full Stack Developer");
                    break;
                case "memorizing":
                    jobs.add("Database Administrator");
                    jobs.add("Legal Assistant");
                    jobs.add("Medical Coding Specialist");
                    break;
                case "patience":
                    jobs.add("Teacher");
                    jobs.add("Healthcare Professional");
                    jobs.add("Customer Service Manager");
                    break;
                case "secure":
                    jobs.add("Government Job");
                    jobs.add("Banking Sector");
                    jobs.add("Public Service");
                    jobs.add("BCS Cadre");
                    break;
                case "sports":
                    jobs.add("Sports Coach");
                    jobs.add("Physical Therapist");
                    jobs.add("Sports Journalist");
                    break;
                case "language":
                    jobs.add("Translator");
                    jobs.add("Interpreter");
                    jobs.add("Language Teacher");
                    jobs.add("International Relations Officer");
                    break;
                case "noskill":
                    jobs.add("Entry Level Positions");
                    jobs.add("Apprenticeship Programs");
                    jobs.add("Skill Development Courses");
                    break;
                case "lazy":
                    jobs.add("Remote Work Opportunities");
                    jobs.add("Flexible Schedule Jobs");
                    jobs.add("Social Media Manager");
                    break;
                case "marriage":
                    jobs.add("Marriage");
                    jobs.add("Find a supportive partner");
                    jobs.add("Focus on family life");
                    break;
                default:
                    break;
            }
        }

        if (jobs.isEmpty()) {
            jobs.add("Freelancer");
            jobs.add("Entrepreneur");
            jobs.add("General Business Roles");
        }

        return new ArrayList<>(jobs);
    }
}