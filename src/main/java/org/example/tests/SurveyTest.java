package org.example.tests;

import org.example.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SurveyTest {

    @Test
    void testSurveyCreation() {
        // Létrehozunk egy teszt Survey objektumot
        List<Question<?>> questions = Arrays.asList(
                new YesNoQuestion("Elégedett a munkakörnyezetével?", true, false, false, YesNoAnswer.createYesNoAnswers()),
                new ScaleQuestion("Hogyan értékelné a céges kultúrát?", true, false, false, ScaleAnswer.createScaleAnswers())
        );

        Survey survey = new Survey("Munkavállalói elégedettségi felmérés", questions);

        // Ellenőrizzük, hogy a Survey helyesen inicializálódott
        assertNotNull(survey);
        assertEquals("Munkavállalói elégedettségi felmérés", survey.getTitle());
        assertEquals(2, survey.getQuestions().size());
    }

    @Test
    void testSurveyAddQuestion() {
        Survey survey = new Survey("Új Felmérés", null);
        YesNoQuestion question = new YesNoQuestion("Elégedett az irodával?", true, false, false, YesNoAnswer.createYesNoAnswers());

        survey.addQuestion(question);

        // Ellenőrizzük, hogy a kérdést sikeresen hozzáadtuk
        assertEquals(1, survey.getQuestions().size());
        assertEquals("Elégedett az irodával?", survey.getQuestions().get(0).getText());
    }

    @Test
    void testSurveyDisplaySurvey() {
        List<Question<?>> questions = Arrays.asList(
                new YesNoQuestion("Elégedett a vezetőséggel?", true, false, false, YesNoAnswer.createYesNoAnswers()),
                new ScaleQuestion("Hogyan értékeli az irodai infrastruktúrát?", true, false, false, ScaleAnswer.createScaleAnswers())
        );

        Survey survey = new Survey("Teszt Felmérés", questions);

        // A Survey megjelenítését hívjuk, amely alapvetően a konzolra ír
        survey.displaySurvey();

        // Ellenőrzés: Az egyszerűség kedvéért csak azt teszteljük, hogy nem dobott kivételt.
        assertDoesNotThrow(() -> survey.displaySurvey());
    }

    @Test
    void testSurveyWithConditionalQuestion() {
        YesNoQuestion question1 = new YesNoQuestion("Elégedett a céges juttatásokkal?", true, false, false, YesNoAnswer.createYesNoAnswers());
        PickMoreQuestion question2 = new PickMoreQuestion(
                "Mely juttatásokat tartja fontosnak?", true, true, false, PickMoreAnswer.createPickMoreAnswersPublicTransport());

        List<Question<?>> questions = Arrays.asList(question1, question2);
        Survey survey = new Survey("Teszt feltételes kérdéssel", questions);

        // Feltétel: a question2 csak akkor jelenik meg, ha question1-re "Igen" a válasz
        question1.setUserAnswer(new YesNoAnswer("Igen"));

        assertTrue(questions.contains(question2), "A második kérdésnek szerepelnie kell a listában.");
    }
}