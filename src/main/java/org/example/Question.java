package org.example;

import java.util.List;

public abstract class Question<T extends Answer> {

    private String text;                // A kérdés szövege
    private boolean isRequired;         // Kötelező-e válaszolni
    private boolean hasCondition;       // Feltételes-e a kérdés
    private List<T> answers;            // A kérdéshez tartozó válaszlehetőségek
    private T userAnswer;               // A felhasználó által adott válasz

    public Question(String text, boolean isRequired, boolean hasCondition, List<T> answers) {
        this.text = text;
        this.isRequired = isRequired;
        this.hasCondition = hasCondition;
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public boolean hasCondition() {
        return hasCondition;
    }

    public List<T> getAnswers() {
        return answers;
    }

    public T getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(T userAnswer) {
        this.userAnswer = userAnswer;
    }

    // Kérdés megjelenítése


    public void displayQuestion() {
        System.out.println(getText());
        for (int i = 0; i < getAnswers().size(); i++) {
            Answer answer = getAnswers().get(i);
            if (answer != null) {
                answer.displayAnswer(i);
            } else {
                System.out.println("Hiba: Üres válasz a listában.");
            }
        }
    }
}
