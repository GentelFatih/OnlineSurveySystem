package org.example;

import java.util.List;

public class PickMoreQuestion extends Question<PickMoreAnswer> {
    private List<PickMoreAnswer> answers;

    public PickMoreQuestion(String questionText, boolean isClosedEnded, boolean hasCondition, List<PickMoreAnswer> answers) {
        super(questionText, isClosedEnded, hasCondition, answers); // Az ősosztálynak nem adjuk át az answerList-et
        this.answers = answers; // Ezt itt külön kezeljük
    }

    public static void setUserAnswers(List<PickMoreAnswer> selectedAnswers) {
    }

    public List<PickMoreAnswer> getAnswers() {
        return answers; // Kifejezetten PickMoreAnswer típusú listát ad vissza
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