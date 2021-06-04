package edu.jpahiber;

import edu.jpahiber.model.Todo;
import edu.jpahiber.model.User;
import edu.jpahiber.service.TodoService;
import edu.jpahiber.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
