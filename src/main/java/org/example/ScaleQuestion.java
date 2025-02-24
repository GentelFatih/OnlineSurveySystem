package org.example;

import java.util.ArrayList;
import java.util.List;

public class ScaleQuestion extends Question<ScaleAnswer> {

    public ScaleQuestion(String text, boolean isRequired, boolean hasCondition, boolean isExplicable, List<ScaleAnswer> answers) {
        super(text, isRequired, hasCondition, isExplicable, answers != null ? answers : new ArrayList<>());
    }

    @Override
    public void displayQuestion() {
        System.out.println(getText()); // A kérdés szövegének kiírása

        // A válaszlehetőségek kiírása
        for (int i = 0; i < getAnswers().size(); i++) {
            getAnswers().get(i).displayAnswer(i); // Minden válasz kiírása a displayAnswer metódussal
        }
    }
}
