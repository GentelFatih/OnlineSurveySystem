package org.example;

import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;

public class QuestionAnswerManager {

    /**
     * Egyszerű válasz feldolgozása YesNoQuestion és ScaleQuestion esetén.
     *
     * @param question   A kérdés objektum (YesNoQuestion vagy ScaleQuestion).
     * @param answerIndex A felhasználó által választott válasz indexe.
     */
    public static void processYesNoAnswer(YesNoQuestion question, int answerIndex) {
        ErrorHandling.checkNullAnswerList(question.getAnswers(), "A válaszok listája null értékű!");
        ErrorHandling.checkEmptyAnswerList(question.getAnswers(), "A válaszok listája üres!");
        ErrorHandling.checkValidIndex(question.getAnswers(), answerIndex, "Érvénytelen válaszindex!");

        // A minden ellenőrzés sikeres -> válasz beállítása
        YesNoAnswer selectedAnswer = question.getAnswers().get(answerIndex);
        question.setUserAnswer(selectedAnswer);
        System.out.println("Válasz mentve: " + selectedAnswer.getText());
        }



    public static void processScaleAnswer(ScaleQuestion question, int answerIndex) {
        ErrorHandling.checkNullAnswerList(question.getAnswers(), "A válaszok listája null értékű!");
        ErrorHandling.checkEmptyAnswerList(question.getAnswers(), "A válaszok listája üres!");
        ErrorHandling.checkValidIndex(question.getAnswers(), answerIndex, "Érvénytelen válaszindex!");

        // A minden ellenőrzés sikeres -> válasz beállítása
        ScaleAnswer selectedAnswer = question.getAnswers().get(answerIndex);
        question.setUserAnswer(selectedAnswer);
        System.out.println("Válasz mentve: " + selectedAnswer.getText());
    }

    public static void processMultipleAnswers(PickMoreQuestion question, List<Integer> selectedIndexes) {
        ErrorHandling.checkNullAnswerList(question.getAnswers(), "A válaszok listája null értékű");
        ErrorHandling.checkEmptyAnswerList(question.getAnswers(), "A válaszok listája üres!");

        // kiválasztott indexek ellenőrzése
        for (int index : selectedIndexes) {
            ErrorHandling.checkValidIndex(question.getAnswers(), index, "Érvénytelen válaszindex: " + index);
            question.addSelectedAnswer(question.getAnswers().get(index));

        }
        System.out.println("Kiválasztott opciók: ");
        question.getSelectedAnswers().forEach(answer -> System.out.println("- " + answer.getText()));
    }

    /**
     * PickMoreQuestion válaszainak indexeit dolgozza fel a felhasználói inputból.
     *
     * @param input         A felhasználói input (vesszővel elválasztott számok).
     * @param maxAnswerSize Az elérhető válaszok maximális száma.
     * @return A felhasználó által választott válaszok indexeinek listája.
     */
    public static List<Integer> parsePickMoreAnswer(String input, int maxAnswerSize) {
        List<Integer> selectedIndexes = new ArrayList<>();
        try {
            String[] tokens = input.split(",");
            for (String token : tokens) {
                int index = Integer.parseInt(token.trim()) - 1; // Az input 1-alapú
                if (index >= 0 && index < maxAnswerSize) {
                    selectedIndexes.add(index);
                } else {
                    System.out.println("Érvénytelen válaszindex: " + (index + 1));
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Hibás formátum. Kérem, csak számokat adjon meg!");
        }
        return selectedIndexes;
    }
}
