package org.example;


import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class SurveyTest {

    private Survey survey;

    @BeforeEach
    void setUp() {
        // Létrehozunk egy tesztkérdőívet
        survey = new Survey("Minta Kérdőív", new ArrayList<>());

        // Hozzáadunk különböző kérdéseket
        YesNoQuestion yesNoQuestion = new YesNoQuestion("Elégedett vagy az irodával?", true, false,
                Arrays.asList(new YesNoAnswer("Igen"), new YesNoAnswer("Nem")));

        ScaleQuestion scaleQuestion = new ScaleQuestion("Milyen az irodai környezet?", true, false,
                Arrays.asList(new ScaleAnswer("Nagyon rossz"), new ScaleAnswer("Rossz"), new ScaleAnswer("Átlagos"),
                        new ScaleAnswer("Jó"), new ScaleAnswer("Kiváló")));

        PickMoreQuestion pickMoreQuestion = new PickMoreQuestion("Milyen közlekedési módokat használsz?", true, false,
                PickMoreAnswer.createPickMoreAnswers());

        survey.addQuestion(yesNoQuestion);
        survey.addQuestion(scaleQuestion);
        survey.addQuestion(pickMoreQuestion);
    }

    @Test
    void testYesNoQuestionAnswer() {
        YesNoQuestion question = (YesNoQuestion) survey.getQuestions().get(0);
        QuestionAnswerManager.processYesNoAnswer(question, 0);
        assertNotNull(question.getUserAnswer());
        assertEquals("Igen", question.getUserAnswer().getText());
    }

    @Test
    void testScaleQuestionAnswer() {
        ScaleQuestion question = (ScaleQuestion) survey.getQuestions().get(1);
        QuestionAnswerManager.processScaleAnswer(question, 2);
        assertNotNull(question.getUserAnswer());
        assertEquals("Átlagos", question.getUserAnswer().getText());
    }

    @Test
    void testPickMoreQuestionAnswer() {
        PickMoreQuestion question = (PickMoreQuestion) survey.getQuestions().get(2);
        List<Integer> selectedIndexes = Arrays.asList(0, 2); // Pl. Busz és Metró
        QuestionAnswerManager.processMultipleAnswers(question, selectedIndexes);
        assertEquals(2, question.getSelectedAnswers().size());
        assertEquals("Busz", question.getSelectedAnswers().get(0).getText());
        assertEquals("Metró", question.getSelectedAnswers().get(1).getText());
    }
}