package engine.api.quiz;

public class QuizSolution {

    private Integer[] answer;

    public Integer[] getAnswer() {
        return answer;
    }

    public QuizSolution setAnswer(final Integer[] answer) {
        this.answer = answer;
        return this;
    }
}
