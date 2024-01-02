package engine.service.quiz;

import engine.api.quiz.QuizDto;
import engine.api.quiz.QuizFeedback;
import engine.api.quiz.QuizSolution;
import engine.service.common.UnauthorizedOperationException;
import engine.service.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
class QuizServiceBean implements QuizService {

    private static final int PAGE_SIZE = 10;
    private final QuizRepository quizRepository;
    private final QuizMappingService quizMappingService;

    @Autowired
    public QuizServiceBean(final QuizRepository quizRepository, final QuizMappingService quizMappingService) {
        this.quizRepository = quizRepository;
        this.quizMappingService = quizMappingService;
    }

    @Override
    public Page<QuizDto> getQuizzes(final int page) {
        return quizRepository.findAll(PageRequest.of(page, PAGE_SIZE)).map(quizMappingService::mapToDto);
    }

    @Override
    public QuizDto getQuiz(final Integer id) throws NoSuchElementException {
        return quizMappingService.mapToDto(quizRepository.findById(id).orElseThrow());
    }

    @Override
    public QuizDto addQuiz(final QuizDto quizDTO, final User user) {
        final Quiz entity = quizMappingService.mapToEntity(quizDTO);
        entity.setUser(user);
        return quizMappingService.mapToDto(quizRepository.save(entity));
    }

    @Override
    public QuizFeedback solveQuiz(final int id, final QuizSolution solution) throws NoSuchElementException {
        final QuizFeedback answer = new QuizFeedback();
        if (solved(quizRepository.findById(id).orElseThrow(), solution)) {
            answer.setSuccess(true).setFeedback("Congratulations, you're right!");
        } else {
            answer.setFeedback("Wrong answer! Please, try again.");
        }
        return answer;
    }

    @Override
    public void deleteQuiz(final int id, final User user) throws UnauthorizedOperationException {
        final Quiz quiz = quizRepository.findById(id).orElseThrow();
        if (!quiz.getUser().equals(user)) {
            throw new UnauthorizedOperationException();
        }
        quizRepository.delete(quiz);
    }

    private boolean solved(final Quiz quiz, final QuizSolution solution) {
        final Set<Integer> correctAnswers = quiz.getAnswers() == null ? Set.of() : new HashSet<>(quiz.getAnswers());
        final Set<Integer> selections = solution.getAnswer() == null ? Set.of() : Set.of(solution.getAnswer());
        if (correctAnswers.size() != selections.size()) {
            return false;
        }
        for (final Integer correctAnswer : correctAnswers) {
            if (!selections.contains(correctAnswer)) {
                return false;
            }
        }
        return true;
    }
}
