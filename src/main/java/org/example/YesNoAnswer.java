package org.example;

import java.util.ArrayList;
import java.util.List;

public class YesNoAnswer extends Answer {

    public YesNoAnswer(String text) {
        super(text);
    }

    @Override
    public void displayAnswer(int index) {
        System.out.println((index + 1) + ". " + getText());
    }

    // Létrehoz egy előre definiált "igen" és "nem" válaszlistát
    public static List<YesNoAnswer> createYesNoAnswers() {
        List<YesNoAnswer> answers = new ArrayList<>();
        answers.add(new YesNoAnswer("Igen"));
        answers.add(new YesNoAnswer("Nem"));
        return answers;
    }
}