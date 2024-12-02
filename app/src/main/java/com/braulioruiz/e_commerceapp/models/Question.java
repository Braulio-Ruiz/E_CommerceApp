package com.braulioruiz.e_commerceapp.models;

/**
 * Modelo que representa una pregunta en el foro.
 */
public class Question {
    private String questionText;
    private String askedBy;

    public Question(String questionText, String askedBy) {
        this.questionText = questionText;
        this.askedBy = askedBy;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAskedBy() {
        return askedBy;
    }
}
