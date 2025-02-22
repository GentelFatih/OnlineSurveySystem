package org.example.tests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.example.*;

// QuestionTest
class QuestionTest {
    @Test
    void testQuestionCreation() {
        List<YesNoAnswer> answers = Arrays.asList(
                new YesNoAnswer("Igen"),
                new YesNoAnswer("Nem")
        );
        YesNoQuestion question = new YesNoQuestion("Szereted a kávét?", true, false, false, answers);
        assertEquals("Szereted a kávét?", question.getText());
        assertEquals(2, question.getAnswers().size());
    }
}
