package engine.service.quiz;

import engine.service.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> options = new ArrayList<>();

    @ElementCollection(fetch = FetchType.LAZY)
    private List<Integer> answers = new ArrayList<>();

    public int getId() {
        return id;
    }

    public Quiz setId(final int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Quiz setTitle(final String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public Quiz setText(final String text) {
        this.text = text;
        return this;
    }

    public List<String> getOptions() {
        return options;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public User getUser() {
        return user;
    }

    public Quiz setUser(final User user) {
        this.user = user;
        return this;
    }
}
