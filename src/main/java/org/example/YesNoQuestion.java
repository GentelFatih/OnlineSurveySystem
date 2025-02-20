package org.example;

import java.util.ArrayList;
import java.util.List;

public class YesNoQuestion extends Question<YesNoAnswer> {
    private Answer selectedAnswer;


    public YesNoQuestion(String text, boolean isRequired, boolean hasCondition, List<YesNoAnswer> answers) {
        super(text, isRequired, hasCondition, answers != null ? answers : new ArrayList<>());
    }



    @Override
    public void displayQuestion() {
        System.out.println(getText());  // Kérdés szövegének megjelenítése
        for (int i = 0; i < getAnswers().size(); i++) {
            getAnswers().get(i).displayAnswer(i); // Válaszok számokkal
        }
    }


}