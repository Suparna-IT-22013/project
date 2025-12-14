package com.example.careercounselor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class QuizResponse {
    @JsonProperty("skills")
    private List<String> skills;

    public QuizResponse() {
    }


    public QuizResponse(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}