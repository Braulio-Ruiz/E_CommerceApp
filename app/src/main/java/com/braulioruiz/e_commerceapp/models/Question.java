package com.braulioruiz.e_commerceapp.models;

/**
 * Modelo que representa una pregunta en el foro.
 */
public class Question {
    private String id;
    private String questionText;
    private String askedBy;
    private boolean isAnswered;
    private long timestamp;

    public Question(String id, String questionText, String askedBy, long timestamp) {
        if (questionText == null || questionText.trim().isEmpty()) {
            throw new IllegalArgumentException("Question text cannot be null or empty");
        }
        if (askedBy == null || askedBy.trim().isEmpty()) {
            throw new IllegalArgumentException("Asked by cannot be null or empty");
        }
        this.id = id;
        this.questionText = questionText;
        this.askedBy = askedBy;
        this.isAnswered = false; // Estado inicial
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAskedBy() {
        return askedBy;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Question{id='" + id + "', questionText='" + questionText + "', askedBy='" + askedBy +
                "', isAnswered=" + isAnswered + ", timestamp=" + timestamp + "}";
    }
}
