package project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.model.User;
import project.service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("config");

        UserService userService = context.getBean(UserService.class);

        userService.addUser(new User("User1", "password1", "firstname1", "lastname1"));

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }



        context.close();
    }
}
