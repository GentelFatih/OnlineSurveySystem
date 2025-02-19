//package org.example;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class SurveyTest {
//
//    @Test
//    public void testSurveyCreation() {
//        Survey survey = SurveyCreator.createEmployeeSatisfactionSurvey();
//
//        // Ellenőrizzük, hogy a kérdőív nem null
//        assertNotNull(survey, "A kérdőív nem lehet null!");
//
//        // Ellenőrizzük, hogy a cím helyes
//        assertEquals("Employee Satisfaction Survey", survey.getTitle(), "A kérdőív címe nem egyezik!");
//
//        // Ellenőrizzük, hogy van legalább egy kérdés
//        assertTrue(survey.getQuestions().size() > 0, "A kérdőívnek legalább egy kérdést tartalmaznia kell!");
//    }
//
//    @Test
//    public void testYesNoQuestionHandling() {
//        YesNoQuestion question = new YesNoQuestion("Elégedett az irodai környezettel?");
//        question.addAnswer(new Answer("Igen"));
//        question.addAnswer(new Answer("Nem"));
//
//        // Ellenőrizzük, hogy a kérdés helyesen inicializálódott
//        assertEquals(2, question.getAnswers().size(), "A válaszok számának 2-nek kell lennie!");
//        assertEquals("Igen", question.getAnswers().get(0).getText(), "Az első válasz szövegének 'Igen'-nek kell lennie!");
//    }
//
//    @Test
//    public void testPickMoreQuestionHandling() {
//        PickMoreQuestion question = new PickMoreQuestion("Melyik juttatások fontosak önnek?");
//        question.addAnswer(new Answer("Egészségbiztosítás"));
//        question.addAnswer(new Answer("Ingyen ebéd"));
//        question.addAnswer(new Answer("Szabadnapok"));
//
//        // Válaszok feldolgozása
//        List<Integer> selectedIndexes = Arrays.asList(0, 2); // Kiválasztott válaszok: 1. és 3.
//        QuestionAnswerManager.processMultipleAnswers(question, selectedIndexes);
//
//        // Ellenőrizzük, hogy a helyes válaszokat választottuk ki
//        List<Answer> selectedAnswers = question.getSelectedAnswers();
//        assertEquals(2, selectedAnswers.size(), "A kiválasztott válaszok számának 2-nek kell lennie!");
//        assertEquals("Egészségbiztosítás", selectedAnswers.get(0).getText(), "Az első kiválasztott válasz nem megfelelő!");
//        assertEquals("Szabadnapok", selectedAnswers.get(1).getText(), "A második kiválasztott válasz nem megfelelő!");
//    }
//
//    @Test
//    public void testConditionalQuestions() {
//        YesNoQuestion question1 = new YesNoQuestion("Elégedett a munkahelyi infrastruktúrával?");
//        question1.addAnswer(new Answer("Igen"));
//        question1.addAnswer(new Answer("Nem"));
//
//        PickMoreQuestion question2 = new PickMoreQuestion("Mely fejlesztések lennének hasznosak?");
//        question2.addAnswer(new Answer("Gyorsabb internet"));
//        question2.addAnswer(new Answer("Több parkolóhely"));
//        question2.setCondition(question1); // Feltétel beállítása
//
//        // Válasz feldolgozása
//        QuestionAnswerManager.processAnswer(question1, 0); // "Igen" válasz
//        boolean shouldDisplay = question2.shouldDisplay();
//
//        // Ellenőrizzük, hogy a feltételes kérdés megjelenik-e
//        assertTrue(shouldDisplay, "A feltételes kérdésnek meg kell jelennie, ha az előző válasz 'Igen' volt!");
//    }
//
//    @Test
//    public void testProcessAnswer() {
//        YesNoQuestion question = new YesNoQuestion("Tetszik az új iroda?");
//        question.addAnswer(new Answer("Igen"));
//        question.addAnswer(new Answer("Nem"));
//
//        // Feldolgozzuk a választ
//        QuestionAnswerManager.processAnswer(question, 1); // A válasz: "Nem"
//
//        // Ellenőrizzük, hogy a megfelelő válasz lett kiválasztva
//        Answer selectedAnswer = question.getSelectedAnswer();
//        assertNotNull(selectedAnswer, "A kiválasztott válasz nem lehet null!");
//        assertEquals("Nem", selectedAnswer.getText(), "A kiválasztott válasz nem megfelelő!");
//    }
//}
