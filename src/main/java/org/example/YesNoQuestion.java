package org.example;

import java.util.List;

public class YesNoQuestion extends Question<YesNoAnswer> {
    private List<YesNoAnswer> answers; // Kifejezetten Yes/No válaszokat tárol

    public YesNoQuestion(String questionText, boolean isClosedEnded, boolean hasCondition, List<YesNoAnswer> answers) {
        super(questionText, isClosedEnded, hasCondition, answers);
        this.answers = answers;
    }

    public List<YesNoAnswer> getAnswers() {
        return answers;
    }

    @Override
    public void displayQuestion() {
        System.out.println(getText());  // Kérdés szövegének megjelenítése
        for (int i = 0; i < answers.size(); i++) {
            answers.get(i).displayAnswer(i); // Válaszok számokkal
        }
    }
}