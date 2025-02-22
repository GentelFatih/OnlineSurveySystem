package org.example;

import java.util.ArrayList;
import java.util.List;

public class PickMoreQuestion extends Question<PickMoreAnswer> {
    private List<Answer> selectedAnswers = new ArrayList<>();

    public PickMoreQuestion(String text) {
        super(text);
    }

    public PickMoreQuestion(String text, boolean isRequired, boolean hasCondition,boolean isExplicable, List<PickMoreAnswer> answers) {
        super(text, isRequired, hasCondition, isExplicable, answers);
    }

    public void addSelectedAnswer(Answer answer) {
        this.selectedAnswers.add(answer);
    }

    public List<Answer> getSelectedAnswers() {
        return this.selectedAnswers;
    }

    public void setSelectedAnswers(List<Answer> selectedAnswers) {

    }

    @Override
    public void displayQuestion() {
        System.out.println(getText());

        // A válaszlehetőségek kiírása
        // Mivel a PickMoreAnswers osztály az Answer osztályból öröklődik,
        // így a getAnswers() metódussal elérhetjük az Answer típusú válaszokat,
        // és azok belső displayAnswer() metódusát hívhatjuk
        for (int i = 0; i < getAnswers().size(); i++) {
            getAnswers().get(i).displayAnswer(i);  // Az Answer típusú válaszok kiírása
        }

    }


}