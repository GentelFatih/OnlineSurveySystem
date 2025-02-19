package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Question<T extends Answer> {

    private String text;                // A kérdés szövege
    private boolean isRequired;         // Kötelező-e válaszolni
    private boolean hasCondition;       // Feltételes-e a kérdés
    private List<T> answers;            // A kérdéshez tartozó válaszlehetőségek
    protected T userAnswer;               // A felhasználó által adott válasz

    public Question(String text, boolean isRequired, boolean hasCondition, List<? extends T> answers) {
        this.text = text;
        this.isRequired = isRequired;
        this.hasCondition = hasCondition;
        this.answers = answers != null ? new ArrayList<>(answers) : new ArrayList<>();
    }

    public Question(String text) {
        this.text = text;
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
        this.userAnswer =  userAnswer;
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
