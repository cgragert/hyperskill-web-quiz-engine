package engine.service.quiz.completion;

import engine.service.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "quiz_completion")
public class QuizCompletion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "quiz_id")
    private int quizId;

    @Column(name = "completed_at")
    private Date completedAt;

    @ManyToOne
    @JoinColumn(name = "completed_by")
    private User user;

    public int getId() {
        return id;
    }

    public QuizCompletion setId(final int id) {
        this.id = id;
        return this;
    }

    public int getQuizId() {
        return quizId;
    }

    public QuizCompletion setQuizId(final int quizId) {
        this.quizId = quizId;
        return this;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public QuizCompletion setCompletedAt(final Date completedAt) {
        this.completedAt = completedAt;
        return this;
    }

    public User getUser() {
        return user;
    }

    public QuizCompletion setUser(final User user) {
        this.user = user;
        return this;
    }
}
