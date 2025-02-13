package org.example;

import java.util.List;

public class Survey {
    private String title;  // A felmérés címe
    private List<Question> questions;  // A kérdések listája

    // Konstruktor: a felmérés címe
    public Survey(String title, List<Question> questions) {
        this.title = title;
        this.questions = questions;
    }

    // Kérdés hozzáadása a felméréshez
    public void addQuestion(Question question) {
        questions.add(question);
    }

    // Getter a kérdések listájához
    public List<Question> getQuestions() {
        return questions;
    }

    public String getTitle() {
        return title;
    }

    // A felmérés megjelenítése
    public void displaySurvey() {
        System.out.println("Felmérés: " + title);  // Felmérés címe

        // Debug üzenet a kérdések listájának megjelenítése előtt
        System.out.println("Kérdések megjelenítése kezdődik...");

        for (Question question : questions) {
            question.displayQuestion();  // A kérdések és válaszok kiírása
        }
    }

    @Override
    public String toString() {
        return "Survey{" +
                "title='" + title + '\'' +
                ", questions=" + questions +
                '}';
    }
}