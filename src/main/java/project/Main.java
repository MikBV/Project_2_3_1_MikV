package project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.model.User;
import project.service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext("config");

        String[] beanNames = context.getBeanDefinitionNames();
        System.out.println("Loaded beans: ");
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        UserService userService = context.getBean(UserService.class);
        User user1 = new User("User1", "password1", "firstname1", "lastname1");
        userService.addUser(user1);

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }
        userService.removeUser(user1);


        context.close();
    }
}
