package org.example.tests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.example.*;

class YesNoQuestionTest {
    @Test
    void testYesNoQuestionAnswerSelection() {
        List<YesNoAnswer> answers = Arrays.asList(
                new YesNoAnswer("Igen"),
                new YesNoAnswer("Nem")
        );
        YesNoQuestion question = new YesNoQuestion("Szeretsz sportolni?", true, false, false, answers);

        YesNoAnswer yesAnswer = new YesNoAnswer("Igen");
        question.setUserAnswer(yesAnswer);

        assertEquals("Igen", question.getUserAnswer().getText());
    }
}
