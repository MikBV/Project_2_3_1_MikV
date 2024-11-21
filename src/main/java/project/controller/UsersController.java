package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.service.UserService;
import project.service.UserServiceImpl;

@Controller
public class UsersController {
    @GetMapping(value = "/users")
    public String index(Model model) {
        UserService userService = new UserServiceImpl();
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
}
