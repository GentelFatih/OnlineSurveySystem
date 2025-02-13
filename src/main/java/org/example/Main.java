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

        // Kérdőívek listába helyezése
        List<Survey> surveys = Arrays.asList(survey1, survey2, survey3);

        try (Scanner scanner = new Scanner(System.in)) {
            // Iterálunk a kérdőíveken
            for (Survey survey : surveys) {
                System.out.println("Kérdőív: " + survey.getTitle());  // A kérdőív címe
                boolean previousQuestionAnsweredYes = false; // Az előző kérdés "IGEN" válasza

                // Iterálunk a kérdéseken
                for (int i = 0; i < survey.getQuestions().size(); i++) {
                    Question question = survey.getQuestions().get(i);

                    // Ha a kérdés feltételes (hasCondition), akkor ellenőrizzük az előző válaszát
                    if (question.hasCondition() && !previousQuestionAnsweredYes) {
                        continue; // Ha az előző kérdésre nem "igen" a válasz, kihagyjuk ezt a kérdést
                    }

                    // Kérdés megjelenítése
                    question.displayQuestion();

                    // Válaszok kezelése kérdéstípus alapján
                    if (question instanceof PickMoreQuestion) {
                        // `PickMoreQuestion` speciális válaszkezelése
                        PickMoreQuestion pickMoreQuestion = (PickMoreQuestion) question;
                        System.out.println("Adja meg a választott lehetőségek számát (vesszővel elválasztva, pl.: 1,3): ");
                        String input = scanner.nextLine(); // Felhasználó válaszainak beolvasása
                        List<Integer> selectedIndexes = QuestionAnswerManager.parsePickMoreAnswer(input, pickMoreQuestion);

                        // Válaszok feldolgozása
                        QuestionAnswerManager.processPickMoreAnswer(survey, i, selectedIndexes);
                        System.out.println();

                    } else {
                        // Egyéb kérdések (Yes/No, Scale) válaszainak kezelése
                        System.out.println("Válassza ki a választ (1-" + question.getAnswers().size() + "): ");
                        int answerIndex = scanner.nextInt();
                        scanner.nextLine(); // Felszabadítja az inputot a következő beolvasáshoz

                        if (answerIndex > 0 && answerIndex <= question.getAnswers().size()) {
                            // Válasz feldolgozása
                            QuestionAnswerManager.processAnswer(survey, i, answerIndex - 1);
                            System.out.println();

                            // Eldöntendő kérdés esetén az előző válasz mentése
                            if (question instanceof YesNoQuestion && answerIndex == 1) { // 1 = IGEN válasz
                                previousQuestionAnsweredYes = true;
                            }
                        } else {
                            System.out.println("Érvénytelen válasz. Kérem válasszon a megadott tartományban.");
                        }
                    }
                }
                System.out.println();  // Külön sor a kérdőívek között
            }
        } catch (Exception e) {
            System.out.println("Hiba történt a válaszok begyűjtése közben. Kérem próbálja újra.");
        }
    }
}
