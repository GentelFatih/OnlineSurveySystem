package org.example.tests;

import org.example.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionAnswerManagerTest {

    @Test
    void testProcessYesNoAnswerValidIndex() {
        List<YesNoAnswer> answers = Arrays.asList(
                new YesNoAnswer("Igen"),
                new YesNoAnswer("Nem")
        );
        YesNoQuestion question = new YesNoQuestion("Tetszett a termék?", true, false, false, answers);

        // Szimulált érvényes választás
        YesNoAnswer selectedAnswer = answers.get(0);
        question.setUserAnswer(selectedAnswer); // Közvetlenül állítjuk be a választ
        assertEquals("Igen", question.getUserAnswer().getText());
    }

    @Test
    void testProcessYesNoAnswerInvalidIndex() {
        List<YesNoAnswer> answers = Arrays.asList(
                new YesNoAnswer("Igen"),
                new YesNoAnswer("Nem")
        );
        YesNoQuestion question = new YesNoQuestion("Tetszett a termék?", true, false, false, answers);

        // Érvénytelen index kezelés
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            question.getAnswers().get(5); // Hozzáférés nem létező indexhez
        });

        assertEquals("Index 5 out of bounds for length 2", exception.getMessage());
    }

    @Test
    void testProcessScaleAnswerValidIndex() {
        List<ScaleAnswer> answers = Arrays.asList(
                new ScaleAnswer("Rossz"),
                new ScaleAnswer("Közepes"),
                new ScaleAnswer("Jó")
        );
        ScaleQuestion question = new ScaleQuestion("Hogyan értékeli a szolgáltatást?", true, false, false, answers);

        // Szimulált érvényes választás
        ScaleAnswer selectedAnswer = answers.get(2);
        question.setUserAnswer(selectedAnswer); // Közvetlenül állítjuk be a választ
        assertEquals("Jó", question.getUserAnswer().getText());
    }

    @Test
    void testProcessScaleAnswerInvalidIndex() {
        List<ScaleAnswer> answers = Arrays.asList(
                new ScaleAnswer("Rossz"),
                new ScaleAnswer("Közepes"),
                new ScaleAnswer("Jó")
        );
        ScaleQuestion question = new ScaleQuestion("Hogyan értékeli a szolgáltatást?", true, false, false, answers);

        // Érvénytelen index kezelés
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            question.getAnswers().get(10); // Hozzáférés nem létező indexhez
        });

        assertEquals("Index 10 out of bounds for length 3", exception.getMessage());
    }

    @Test
    void testProcessMultipleAnswersValidIndexes() {
        List<PickMoreAnswer> answers = Arrays.asList(
                new PickMoreAnswer("Busz"),
                new PickMoreAnswer("Villamos"),
                new PickMoreAnswer("Metró")
        );
        PickMoreQuestion question = new PickMoreQuestion("Mely közlekedési eszközöket használja?", true, false, false, answers);

        // Szimulált válaszok kiválasztása
        List<PickMoreAnswer> selectedAnswers = Arrays.asList(
                answers.get(0),
                answers.get(2)
        );

        for (PickMoreAnswer answer : selectedAnswers) {
            question.addSelectedAnswer(answer);
        }

        // Ellenőrzések
        List<Answer> savedAnswers = question.getSelectedAnswers();
        assertEquals(2, savedAnswers.size());
        assertEquals("Busz", savedAnswers.get(0).getText());
        assertEquals("Metró", savedAnswers.get(1).getText());
    }

    @Test
    void testProcessMultipleAnswersInvalidIndex() {
        List<PickMoreAnswer> answers = Arrays.asList(
                new PickMoreAnswer("Busz"),
                new PickMoreAnswer("Villamos"),
                new PickMoreAnswer("Metró")
        );
        PickMoreQuestion question = new PickMoreQuestion("Mely közlekedési eszközöket használja?", true, false, false, answers);

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            question.getAnswers().get(5); // Hozzáférés nem létező indexhez
        });

        assertEquals("Index 5 out of bounds for length 3", exception.getMessage());
    }
}