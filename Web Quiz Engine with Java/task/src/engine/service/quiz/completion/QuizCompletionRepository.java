package engine.service.quiz.completion;

import engine.service.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizCompletionRepository extends PagingAndSortingRepository<QuizCompletion, Integer> {

    @Query("select e from QuizCompletion e where e.user = :user order by e.completedAt desc")
    Page<QuizCompletion> findByUser(@Param("user") final User user, final Pageable pageable);
}
