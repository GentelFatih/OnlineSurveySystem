package org.example;

public abstract class Answer {
    protected String text;

    public Answer(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    // Absztrakt metódus, amelyet az alosztályoknak implementálniuk kell
    public abstract void displayAnswer(int index);
}