package org.example;

import java.util.ArrayList;
import java.util.List;

public class Survey {
    private String title;  // A felmérés címe
    private List<Question<?>> questions;  // A kérdések listája

    public Survey(String title, List<Question<?>> questions) {
        this.title = title;
        this.questions = questions != null ? questions : new ArrayList<>();
    }

    public void addQuestion(Question<?> question) {
        questions.add(question);
    }

    public String getTitle() {
        return title;
    }

    public List<Question<?>> getQuestions() {
        return questions;
    }

    public void displaySurvey() {
        System.out.println("Felmérés: " + title);
        for (Question<?> question : questions) {
            question.displayQuestion();
        }
    }
}