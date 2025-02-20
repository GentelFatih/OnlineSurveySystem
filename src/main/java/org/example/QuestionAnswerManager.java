package org.example;

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

    public static void processMultipleAnswers(PickMoreQuestion question, Scanner scanner) {
        while (true) {
            try {
                System.out.println("Adja meg a választott lehetőségek számát (vesszővel elválasztva, pl.: 1,3): ");
                String input = scanner.nextLine();

                // Parse az inputot
                List<Integer> selectedIndexes = ErrorHandling.parsePickMoreAnswer(input, question.getAnswers().size());

                // Mentjük a kiválasztott válaszokat
                for (int index : selectedIndexes) {
                    question.addSelectedAnswer(question.getAnswers().get(index));
                }

                // Kiírjuk a kiválasztott válaszokat
                System.out.println("Választott lehetőségek:");
                for (Answer answer : question.getSelectedAnswers()) {
                    System.out.println("- " + answer.getText());
                }
                break; // Ha minden rendben van, kilépünk a ciklusból
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}