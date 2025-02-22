package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PickMoreAnswer extends Answer {

    public PickMoreAnswer(String text) {
        super(text);
    }

    @Override
    public void displayAnswer(int index) {
        System.out.println((index + 1) + ". " + getText());
    }



    // Létrehoz egy válaszlistát tömegközlekedési eszközökre példaként
    public static List<PickMoreAnswer> createPickMoreAnswersPublicTransport() {
        List<PickMoreAnswer> answers = new ArrayList<>();
        answers.add(new PickMoreAnswer("Busz"));
        answers.add(new PickMoreAnswer("Villamos"));
        answers.add(new PickMoreAnswer("Metró"));
        answers.add(new PickMoreAnswer("Troli"));
        answers.add(new PickMoreAnswer("Hév"));
        answers.add(new PickMoreAnswer("Vonat"));

        return answers;
    }
    public static List<PickMoreAnswer> createPickMoreAnswerHobbies() {
        List<PickMoreAnswer> answers = new ArrayList<>();
        answers.add(new PickMoreAnswer("Sport"));
        answers.add(new PickMoreAnswer("Olvasás"));
        answers.add(new PickMoreAnswer("Színház"));
        answers.add(new PickMoreAnswer("Film"));
        answers.add(new PickMoreAnswer("Zene"));
        answers.add(new PickMoreAnswer("Videojátékok"));
        answers.add(new PickMoreAnswer("Egyéb:"));

        return answers;
    }


}
