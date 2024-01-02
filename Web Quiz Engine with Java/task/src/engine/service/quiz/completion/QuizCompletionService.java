package engine.service.quiz.completion;

import engine.api.quiz.QuizCompletionDto;
import engine.service.user.User;
import org.springframework.data.domain.Page;

public interface QuizCompletionService {

    Page<QuizCompletionDto> getCompletedQuizzes(final int page, final User user);

    void completeQuiz(int id, User user);
}
