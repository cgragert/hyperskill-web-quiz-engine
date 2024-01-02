package engine.api.quiz;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

public class QuizDto {
    @JsonInclude(Include.NON_NULL)
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("title")
    @NotBlank
    private String title;

    @JsonProperty("text")
    @NotBlank
    private String text;

    @JsonProperty("options")
    @NotNull
    @Size(min = 2)
    private String[] options;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("answer")
    private Integer[] answer;

    public Integer getId() {
        return id;
    }

    public QuizDto setId(final Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public QuizDto setTitle(final String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public QuizDto setText(final String text) {
        this.text = text;
        return this;
    }

    public String[] getOptions() {
        return options;
    }

    public QuizDto setOptions(final String... options) {
        this.options = options;
        return this;
    }

    public Integer[] getAnswer() {
        return answer;
    }

    public QuizDto setAnswer(final Integer[] answer) {
        this.answer = answer;
        return this;
    }
}
