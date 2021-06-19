package edu.jpahiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "is_done")
    private Boolean isDone = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Todo() {
    }

    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Todo(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id) && Objects.equals(title, todo.title) && Objects.equals(description, todo.description) && Objects.equals(isDone, todo.isDone) && Objects.equals(user, todo.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, isDone, user);
    }

    @Override
    public String toString() {
        return "\n\tTodo{" +
                "id='" + id + '\'' +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}
