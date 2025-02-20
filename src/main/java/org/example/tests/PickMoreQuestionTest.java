package org.example.tests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.example.*;

class PickMoreQuestionTest {
    @Test
    void testMultipleAnswersSelection() {
        PickMoreQuestion question = new PickMoreQuestion("Milyen sportokat szeretsz?");
        PickMoreAnswer football = new PickMoreAnswer("Foci");
        PickMoreAnswer basketball = new PickMoreAnswer("Kosárlabda");
        question.addSelectedAnswer(football);
        question.addSelectedAnswer(basketball);
        assertEquals(2, question.getSelectedAnswers().size());
    }
}