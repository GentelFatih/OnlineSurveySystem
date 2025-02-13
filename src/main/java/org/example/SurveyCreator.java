package org.example;

import java.util.Arrays;
import java.util.List;

public class SurveyCreator {

    // Létrehoz egy EmployeeSatisfactionSurvey típusú felmérést
    public static Survey createEmployeeSatisfactionSurvey() {
        // Különböző típusú kérdések létrehozása
        Question question1 = new YesNoQuestion("Elégedett vagy a munkakörnyezeteddel?", true, false, YesNoAnswer.createYesNoAnswers());
        Question question2 = new ScaleQuestion("Hogyan értékeled a céges kultúrát?", true, false, ScaleAnswer.createScaleAnswers());


        // Kérdések listája
        List<Question> questions = Arrays.asList(question1, question2);

        // Visszaadja az EmployeeSatisfactionSurvey-t a kérdésekkel
        return new EmployeeSatisfactionSurvey("Munkavállalói Elégedettségi Felmérés", questions);
    }



    // Létrehoz egy HygieneSatisfactionSurvey típusú felmérést
    public static Survey createHygieneSatisfactionSurvey() {
        // Különböző típusú kérdések létrehozása
        Question question1 =
                new ScaleQuestion("Milyennek ítéled meg a fürdőszoba tisztaságát?", true, false, ScaleAnswer.createScaleAnswers());
        Question question2 =
                new ScaleQuestion("Milyennek tartod az iroda rendezettségét?", true, false, ScaleAnswer.createScaleAnswers());

        // Kérdések listája
        List<Question> questions = Arrays.asList(question1, question2);

        // Visszaadja a HygieneSatisfactionSurvey-t a kérdésekkel
        return new HygieneSatisfactionSurvey("Higiéniai Elégedettségi Felmérés", questions);
    }

    public static Survey createWorkplaceAccessibilitySurvey() {
        // Kérdések létrehozása
        Question question1 = new YesNoQuestion("Tömegközlekedéssel jár be az irodába?",
                true, false, YesNoAnswer.createYesNoAnswers());

        List<PickMoreAnswer> pickMoreAnswers = PickMoreAnswer.createPickMoreAnswers();
        Question question2 = new PickMoreQuestion(
                "Mely tömegközlekedési eszközöket veszi igénybe munkábamenetkor?",
                false, true,
                pickMoreAnswers
        );
        // A kérdések listája
        List<Question> questions = Arrays.asList(question1, question2);

        // Kérdőív objektum létrehozása és visszaadása
        return new WorkplaceAccessibilitySurvey("Munkahely Elérhetőségi Felmérés", questions);
    }
}
