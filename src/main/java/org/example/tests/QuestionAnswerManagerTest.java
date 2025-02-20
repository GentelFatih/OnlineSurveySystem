package org.example.tests;

import org.example.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class QuestionAnswerManagerTest {

    @Test
    void testProcessYesNoAnswer() {
        // Tesztelünk egy valid esetet
        YesNoQuestion question = new YesNoQuestion("Tetszett a termék?", true, false, Arrays.asList(
                new YesNoAnswer("Igen"),
                new YesNoAnswer("Nem")
        ));
        QuestionAnswerManager.processYesNoAnswer(question, 0);
        assertEquals("Igen", question.getUserAnswer().getText());
    }



    @Test
    void testProcessYesNoAnswerEmptyList() {
        // Tesztelünk egy üres válaszlistát
        YesNoQuestion question = new YesNoQuestion("Tetszett a termék?", true, false, null);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            QuestionAnswerManager.processYesNoAnswer(question, 0);
        });
        assertEquals("A válaszok listája üres!", exception.getMessage());
    }

    @Test
    void testProcessYesNoAnswerInvalidIndex() {
        // Tesztelünk egy érvénytelen indexet
        YesNoQuestion question = new YesNoQuestion("Tetszett a termék?", true, false, Arrays.asList(
                new YesNoAnswer("Igen"),
                new YesNoAnswer("Nem")
        ));
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            QuestionAnswerManager.processYesNoAnswer(question, 5);
        });
        assertEquals("Érvénytelen válaszindex!", exception.getMessage());
    }

    @Test
    void testProcessScaleAnswer() {
        // Tesztelünk egy valid esetet skálás kérdéshez
        ScaleQuestion question = new ScaleQuestion("Mennyire értékelted ezt a szolgáltatást?", true, false, Arrays.asList(
                new ScaleAnswer("Rossz"),
                new ScaleAnswer("Közepes"),
                new ScaleAnswer("Jó")
        ));
        QuestionAnswerManager.processScaleAnswer(question, 2);
        assertEquals("Jó", question.getUserAnswer().getText());
    }

    @Test
    void testProcessScaleAnswerInvalidIndex() {
        // Tesztelünk egy érvénytelen indexet skálás kérdéshez
        ScaleQuestion question = new ScaleQuestion("Mennyire értékelted ezt a szolgáltatást?", true, false, Arrays.asList(
                new ScaleAnswer("Rossz"),
                new ScaleAnswer("Közepes"),
                new ScaleAnswer("Jó")
        ));
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            QuestionAnswerManager.processScaleAnswer(question, 5);
        });
        assertEquals("Érvénytelen válaszindex!", exception.getMessage());
    }
}