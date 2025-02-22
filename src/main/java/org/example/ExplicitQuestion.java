package org.example;

public class ExplicitQuestion extends Question<ExplicitAnswer> {
    private String userExplicitAnswer;  // Új mező a szöveges válasz tárolására

    public ExplicitQuestion(String text, boolean isRequired, boolean hasCondition, boolean isExplicable) {
        super(text, isRequired, hasCondition, isExplicable, null);
    }

    public ExplicitQuestion(String text) {
        super(text, false, false, true, null);
    }

    @Override
    public void displayQuestion() {
        System.out.println(getText() + " (Kifejtős válasz)");
    }

    // Szöveges válasz beállítása
    public void setUserExplicitAnswer(String answer) {
        this.userExplicitAnswer = answer;
    }

    // Szöveges válasz lekérdezése
    public String getUserExplicitAnswer() {
        return userExplicitAnswer;
    }
}