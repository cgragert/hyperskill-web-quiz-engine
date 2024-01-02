package engine.service.quiz;

import engine.api.quiz.QuizDto;
import engine.api.quiz.QuizFeedback;
import engine.api.quiz.QuizSolution;
import engine.service.common.UnauthorizedOperationException;
import engine.service.user.User;
import org.springframework.data.domain.Page;

import java.util.NoSuchElementException;

public interface QuizService {
    Page<QuizDto> getQuizzes(final int page);

    QuizDto getQuiz(final Integer id) throws NoSuchElementException;

    QuizDto addQuiz(final QuizDto quizDTO, final User user);

    QuizFeedback solveQuiz(final int id, final QuizSolution selectedOption);

    void deleteQuiz(final int id, final User user) throws UnauthorizedOperationException;
}
