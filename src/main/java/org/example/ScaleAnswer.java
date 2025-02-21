package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScaleAnswer extends Answer {

    public ScaleAnswer(String text) {
        super(text);
    }

    @Override
    public void displayAnswer(int index) {
        System.out.println((index + 1) + ". " + getText());
    }

    // Létrehoz egy skálázott válaszokból álló listát (pl. 1-től 5-ig)
    public static List<ScaleAnswer> createScaleAnswers() {
        List<ScaleAnswer> answers = new ArrayList<>();
        answers.add(new ScaleAnswer("Rossz"));
        answers.add(new ScaleAnswer("Közepes"));
        answers.add(new ScaleAnswer("Jó"));
        return answers;
    }
}
