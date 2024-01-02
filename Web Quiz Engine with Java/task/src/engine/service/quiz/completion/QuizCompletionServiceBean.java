package engine.service.quiz.completion;

import engine.api.quiz.QuizCompletionDto;
import engine.service.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

import static engine.service.common.ServiceConstant.PAGE_SIZE;

@Service
public class QuizCompletionServiceBean implements QuizCompletionService {

    private final QuizCompletionRepository quizCompletionRepository;
    private final QuizCompletionMappingService quizCompletionMappingService;

    @Autowired
    public QuizCompletionServiceBean(
            final QuizCompletionRepository quizCompletionRepository,
            final QuizCompletionMappingService quizCompletionMappingService) {
        this.quizCompletionRepository = quizCompletionRepository;
        this.quizCompletionMappingService = quizCompletionMappingService;
    }

    @Override
    public Page<QuizCompletionDto> getCompletedQuizzes(final int page, final User user) {
        return quizCompletionRepository.findByUser(user, PageRequest.of(page, PAGE_SIZE))
                .map(quizCompletionMappingService::mapToDto);
    }

    @Override
    public void completeQuiz(final int id, final User user) {
        QuizCompletion quizCompletion = new QuizCompletion();
        quizCompletion.setQuizId(id);
        quizCompletion.setUser(user);
        quizCompletion.setCompletedAt(new Date());
        quizCompletionRepository.save(quizCompletion);
    }
}
