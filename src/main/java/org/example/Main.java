package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Kérdőívek létrehozása
        Survey survey1 = SurveyCreator.createEmployeeSatisfactionSurvey();
        Survey survey2 = SurveyCreator.createHygieneSatisfactionSurvey();
        Survey survey3 = SurveyCreator.createWorkplaceAccessibilitySurvey();
        Survey survey4 = SurveyCreator.createPersonalQuestionsSurvey();

        // Kérdőívek listába helyezése
        List<Survey> surveys = Arrays.asList(survey1, survey2, survey3, survey4);

        try (Scanner scanner = new Scanner(System.in)) {
            // Iterálunk a kérdőíveken
            for (Survey survey : surveys) {
                System.out.println("Kérdőív: " + survey.getTitle()); // A kérdőív címe
                boolean previousQuestionAnsweredYes = false; // Előző kérdés válasz



                for (Question<?> question : survey.getQuestions()) {
                    // Ha a kérdés feltételes (hasCondition), ellenőrizzük az előző válaszokat
                    if (question.hasCondition() && !previousQuestionAnsweredYes) {
                        continue; // Ha az előző válasz nem IGEN, ugorjunk a következő kérdésre
                    }

                    // Kérdés megjelenítése
                    question.displayQuestion();

                    // Kérdés típusa alapján feldolgozzuk a válaszokat
                    if (question instanceof YesNoQuestion) {
                        System.out.println();
                        QuestionAnswerManager.processYesNoAnswer((YesNoQuestion) question, scanner);
                        previousQuestionAnsweredYes = question.getUserAnswer() != null &&
                                question.getUserAnswer().getText().equalsIgnoreCase("Igen");
                    } else if (question instanceof ScaleQuestion) {
                        System.out.println();
                        QuestionAnswerManager.processScaleAnswer((ScaleQuestion) question, scanner);
                    } else if (question instanceof PickMoreQuestion) {
                        System.out.println();
                        QuestionAnswerManager.processMultipleAnswers((PickMoreQuestion) question, survey, scanner);

                    } else if (question instanceof ExplicitQuestion) {
                        System.out.println();
                        QuestionAnswerManager.processExplicitAnswers((ExplicitQuestion) question, scanner);

                    }
                }
                System.out.println(); // Kérdőívek között külön sor
            }
        } catch (Exception e) {
            System.out.println("Hiba történt: " + e.getMessage());
        }
    }
}