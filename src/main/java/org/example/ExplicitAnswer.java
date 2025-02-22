package org.example;

import java.util.Scanner;

public class ExplicitAnswer extends Answer{
    public ExplicitAnswer(String text) {
        super(text);
    }

    @Override
    public void displayAnswer(int index) {

    }
//    public static String createExplicitAnswer() {
//        String userInput;
//        try (Scanner scanner = new Scanner(System.in)) {
//            userInput = scanner.nextLine();
//
//        }
//        return "Válasz: " + userInput;
//    }

}
