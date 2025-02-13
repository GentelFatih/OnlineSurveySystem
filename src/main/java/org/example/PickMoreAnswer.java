package org.example;

import java.util.ArrayList;
import java.util.List;

public class PickMoreAnswer extends Answer {

    public PickMoreAnswer(String text) {
        super(text);
    }

    @Override
    public void displayAnswer(int index) {
        System.out.println((index + 1) + ". " + getText());
    }



    // Létrehoz egy válaszlistát tömegközlekedési eszközökre példaként
    public static List<PickMoreAnswer> createPickMoreAnswers() {
        List<PickMoreAnswer> answers = new ArrayList<>();
        answers.add(new PickMoreAnswer("Busz"));
        answers.add(new PickMoreAnswer("Villamos"));
        answers.add(new PickMoreAnswer("Metró"));
        answers.add(new PickMoreAnswer("Troli"));
        answers.add(new PickMoreAnswer("Hév"));
        answers.add(new PickMoreAnswer("Vonat"));

        return answers;
    }
}
