package engine.api.quiz;

import engine.service.quiz.QuizService;
import engine.service.quiz.completion.QuizCompletionService;
import engine.service.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizRestResourceBean implements QuizRestResource {

    private final QuizService quizService;
    private final QuizCompletionService quizCompletionService;

    @Autowired
    public QuizRestResourceBean(final QuizService quizService, final QuizCompletionService quizCompletionService) {
        this.quizService = quizService;
        this.quizCompletionService = quizCompletionService;
    }

    @Override
    public ResponseEntity<Page<QuizDto>> getQuizzes(final int page) {
        return ResponseEntity.ok(quizService.getQuizzes(page));
    }

    @Override
    public ResponseEntity<QuizDto> getQuiz(final Integer id) {
        return ResponseEntity.ok(quizService.getQuiz(id));
    }

    @Override
    public ResponseEntity<QuizDto> addQuiz(final QuizDto quizDTO, final UserDetails userDetails) {
        final User user = new User().setEmail(userDetails.getUsername()).setPassword(userDetails.getPassword());
        return ResponseEntity.ok(quizService.addQuiz(quizDTO, user));
    }

    @Override
    public ResponseEntity<QuizFeedback> solveQuiz(final int id, final QuizSolution solution, final UserDetails userDetails) {
        final QuizFeedback quizFeedback = quizService.solveQuiz(id, solution);
        if (quizFeedback.isSuccess()) {
            final User user = new User().setEmail(userDetails.getUsername()).setPassword(userDetails.getPassword());
            quizCompletionService.completeQuiz(id, user);
        }
        return ResponseEntity.ok(quizFeedback);
    }

    @Override
    public ResponseEntity<Void> deleteQuiz(final int id, final UserDetails userDetails) {
        final User user = new User().setEmail(userDetails.getUsername()).setPassword(userDetails.getPassword());
        quizService.deleteQuiz(id, user);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Page<QuizCompletionDto>> getCompletedQuizzes(final int page, final UserDetails userDetails) {
        final User user = new User().setEmail(userDetails.getUsername()).setPassword(userDetails.getPassword());
        return ResponseEntity.ok(quizCompletionService.getCompletedQuizzes(page, user));
    }
}
