package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.service.UserService;
import project.service.UserServiceImpl;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/users")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
}
