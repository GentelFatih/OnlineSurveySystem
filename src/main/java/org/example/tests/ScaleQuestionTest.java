package org.example.tests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.example.*;

import java.util.Arrays;
import java.util.List;

class ScaleQuestionTest {
    @Test
    void testScaleQuestionAnswerSelection() {
        // Előre definiált válaszok
        List<ScaleAnswer> answers = Arrays.asList(
                new ScaleAnswer("Rossz"),
                new ScaleAnswer("Közepes"),
                new ScaleAnswer("Jó")
        );

        // ScaleQuestion létrehozása
        ScaleQuestion question = new ScaleQuestion("Mennyire értékeled ezt a szolgáltatást?", true, false, false, answers);

        // Felhasználói válasz kiválasztása (az egyik előre definiált válasz)
        ScaleAnswer selectedAnswer = answers.get(2); // "Jó"
        question.setUserAnswer(selectedAnswer);

        // Ellenőrzés
        assertEquals("Jó", question.getUserAnswer().getText());
    }
}