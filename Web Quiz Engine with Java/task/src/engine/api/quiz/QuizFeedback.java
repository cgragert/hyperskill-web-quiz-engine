package engine.api.quiz;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuizFeedback {
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("feedback")
    private String feedback;

    public boolean isSuccess() {
        return success;
    }

    public QuizFeedback setSuccess(final boolean success) {
        this.success = success;
        return this;
    }

    public String getFeedback() {
        return feedback;
    }

    public QuizFeedback setFeedback(final String feedback) {
        this.feedback = feedback;
        return this;
    }
}
