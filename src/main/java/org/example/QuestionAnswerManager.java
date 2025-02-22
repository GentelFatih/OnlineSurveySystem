package org.example;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionAnswerManager {

    public static void processYesNoAnswer(YesNoQuestion question, Scanner scanner) {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println("Válassza ki a választ (1-" + question.getAnswers().size() + "): ");
                int answerIndex = scanner.nextInt() - 1; // 1-alapú indexet kezelünk
                scanner.nextLine(); // Tisztítja a bemenetet

                // Érvényességi ellenőrzés
                ErrorHandling.checkValidIndex(question.getAnswers(), answerIndex, "Érvénytelen válaszindex!");

                // Válasz feldolgozása
                YesNoAnswer selectedAnswer = question.getAnswers().get(answerIndex);
                question.setUserAnswer(selectedAnswer);
                System.out.println("Válasz mentve: " + selectedAnswer.getText());
                System.out.println();
                valid = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine(); // Hibás bemenet tisztítása
            }
        }
    }

    public static void processScaleAnswer(ScaleQuestion question, Scanner scanner) {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println("Válassza ki a választ (1-" + question.getAnswers().size() + "): ");
                int answerIndex = scanner.nextInt() - 1; // 1-alapú indexet kezelünk
                scanner.nextLine(); // Tisztítja a bemenetet

                // Érvényességi ellenőrzés
                ErrorHandling.checkValidIndex(question.getAnswers(), answerIndex, "Érvénytelen válaszindex!");

                // Válasz feldolgozása
                ScaleAnswer selectedAnswer = question.getAnswers().get(answerIndex);
                question.setUserAnswer(selectedAnswer);
                System.out.println("Válasz mentve: " + selectedAnswer.getText());
                valid = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine(); // Hibás bemenet tisztítása
            }
        }
    }

    public static void processMultipleAnswers(PickMoreQuestion question, Survey survey, Scanner scanner) {
        while (true) {
            try {
                System.out.println("Adja meg a választott lehetőségek számát (vesszővel elválasztva, pl.: 1,3): ");
                String input = scanner.nextLine();

                List<Integer> selectedIndexes = ErrorHandling.parsePickMoreAnswer(input, question.getAnswers().size());

                List<String> selectedTexts = new ArrayList<>();
                for (int index : selectedIndexes) {
                    Answer answer = question.getAnswers().get(index);
                    question.addSelectedAnswer(answer);
                    selectedTexts.add(answer.getText().toLowerCase());
                }

                System.out.println("Választott lehetőségek:");
                for (Answer answer : question.getSelectedAnswers()) {
                    System.out.println("- " + answer.getText());
                }

                // Ha a válaszok között szerepel "sport" vagy "egyéb", akkor megkeressük a Survey-ben az ExplicitQuestion-t
                if (selectedTexts.contains("sport") || selectedTexts.contains("egyéb:")) {
                    for (Question<?> q : survey.getQuestions()) {
                        if (q instanceof ExplicitQuestion) {
                            processExplicitAnswers((ExplicitQuestion) q, scanner);
                            break;
                        }
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void processExplicitAnswers(ExplicitQuestion question, Scanner scanner) {
        try {
            System.out.println(question.getText());
            String input = scanner.nextLine();

            // Az inputból ExplicitAnswer példányt hozunk létre
            ExplicitAnswer explicitAnswer = new ExplicitAnswer(input);

            question.setUserAnswer(explicitAnswer);
            System.out.println("Válasz mentve: " + explicitAnswer.getText());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}