package engine.api.quiz;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class QuizCompletionDto {

    @JsonProperty("id")
    private int quizId;

    @JsonProperty("completedAt")
    private Date completedAt;

    public int getQuizId() {
        return quizId;
    }

    public QuizCompletionDto setQuizId(final int quizId) {
        this.quizId = quizId;
        return this;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public QuizCompletionDto setCompletedAt(final Date completedAt) {
        this.completedAt = completedAt;
        return this;
    }
}
