package engine.service.quiz.completion;

import engine.api.quiz.QuizCompletionDto;
import engine.service.common.Mapper;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class QuizCompletionMappingService implements Mapper<QuizCompletion, QuizCompletionDto> {
    @Override
    public QuizCompletion mapToEntity(final QuizCompletionDto quizCompletionDto) {
        return null;
    }

    @Override
    public QuizCompletionDto mapToDto(final QuizCompletion quizCompletion) {
        return new QuizCompletionDto()
                .setQuizId(quizCompletion.getQuizId())
                .setCompletedAt(quizCompletion.getCompletedAt());
    }

    @Override
    public Collection<QuizCompletionDto> mapToDtos(final Collection<QuizCompletion> quizCompletions) {
        return null;
    }
}
