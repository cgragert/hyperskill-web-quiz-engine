package engine.api.quiz;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface QuizRestResource {

    @GetMapping(path = "api/quizzes")
    ResponseEntity<Page<QuizDto>> getQuizzes(@RequestParam("page") final int page);

    @GetMapping(path = "api/quizzes/{id}")
    ResponseEntity<QuizDto> getQuiz(@PathVariable(required = false) final Integer id);

    @PostMapping(path = "api/quizzes")
    ResponseEntity<QuizDto> addQuiz(
            @RequestBody @Valid final QuizDto quizDTO,
            @AuthenticationPrincipal UserDetails userDetails);

    @PostMapping(path = "api/quizzes/{id}/solve")
    ResponseEntity<QuizFeedback> solveQuiz(
            @PathVariable final int id,
            @RequestBody final QuizSolution solution,
            @AuthenticationPrincipal UserDetails userDetails);

    @DeleteMapping(path = "api/quizzes/{id}")
    ResponseEntity<Void> deleteQuiz(
            @PathVariable final int id,
            @AuthenticationPrincipal UserDetails userDetails);

    @GetMapping(path = "api/quizzes/completed")
    ResponseEntity<Page<QuizCompletionDto>> getCompletedQuizzes(
            @RequestParam("page") final int page,
            @AuthenticationPrincipal UserDetails userDetails);

}
