package engine.service.quiz;

import engine.api.quiz.QuizDto;
import engine.service.common.Mapper;
import engine.service.quiz.Quiz;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class QuizMappingService implements Mapper<Quiz, QuizDto> {

    @Override
    public Quiz mapToEntity(final QuizDto quizDTO) {
        final Quiz quiz = new Quiz()
                .setTitle(quizDTO.getTitle())
                .setText(quizDTO.getText());
        quiz.getOptions().addAll(List.of(quizDTO.getOptions()));
        final Integer[] answer = quizDTO.getAnswer();
        if (answer != null) {
            quiz.getAnswers().addAll(List.of(answer));
        }
        return quiz;
    }

    @Override
    public QuizDto mapToDto(final Quiz entity) {
        return new QuizDto()
                .setId(entity.getId())
                .setTitle(entity.getTitle())
                .setText(entity.getText())
                .setOptions(entity.getOptions().toArray(String[]::new));
    }

    @Override
    public Collection<QuizDto> mapToDtos(final Collection<Quiz> quizEntities) {
        return quizEntities.stream().map(this::mapToDto).toList();
    }
}
