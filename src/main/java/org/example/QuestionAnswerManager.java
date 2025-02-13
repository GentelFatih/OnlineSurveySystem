package org.example;

import java.util.ArrayList;
import java.util.List;

public class QuestionAnswerManager {

    /**
     * Egyetlen válasz feldolgozása (Yes/No, Scale kérdéseknél).
     */
    public static void processAnswer(Survey survey, int questionIndex, int answerIndex) {
        Question question = survey.getQuestions().get(questionIndex);
        List<? extends Answer> answers = question.getAnswers();
        Answer selectedAnswer = answers.get(answerIndex);

        // Válasz mentése vagy feldolgozása
        System.out.println("Válasz: " + selectedAnswer.getText());
        question.setUserAnswer(selectedAnswer);
    }

    /**
     * Több válasz feldolgozása (PickMoreQuestion esetén).
     */
    public static void processPickMoreAnswer(Survey survey, int questionIndex, List<Integer> selectedIndexes) {
        Question question = survey.getQuestions().get(questionIndex);
        if (question instanceof PickMoreQuestion) {
            PickMoreQuestion pickMoreQuestion = (PickMoreQuestion) question;
            List<PickMoreAnswer> selectedAnswers = new ArrayList<>();

            for (int index : selectedIndexes) {
                if (index > 0 && index <= pickMoreQuestion.getAnswers().size()) {
                    selectedAnswers.add(pickMoreQuestion.getAnswers().get(index - 1));
                } else {
                    System.out.println("Érvénytelen válaszindex: " + index);
                }
            }

            // Válaszok mentése
            PickMoreQuestion.setUserAnswers(selectedAnswers);
            System.out.println("Választott lehetőségek: ");
            for (PickMoreAnswer answer : selectedAnswers) {
                System.out.println("- " + answer.getText());
            }
        } else {
            System.out.println("Hiba: Nem PickMoreQuestion típusú kérdés.");
        }
    }

    /**
     * Válaszok elemzése PickMoreQuestion esetén.
     */
    public static List<Integer> parsePickMoreAnswer(String input, PickMoreQuestion question) {
        List<Integer> selectedIndexes = new ArrayList<>();
        try {
            String[] parts = input.split(",");
            for (String part : parts) {
                selectedIndexes.add(Integer.parseInt(part.trim()));
            }
        } catch (NumberFormatException e) {
            System.out.println("Hibás formátum: " + input);
        }
        return selectedIndexes;
    }
}
