package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.User;
import project.service.UserService;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/users/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @GetMapping(value = "/users/change/id")
    public String changeUserById(@RequestParam(value = "id", required = true) Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "change";
    }

    @PostMapping(value = "/users/change/id")
    public String saveChangesInUser(@ModelAttribute User user) {
        boolean checkUpdate = false;
        userService.updateUser(user, checkUpdate);
        if (checkUpdate) {
            return "cangeconfirm";
        }
        return "changesreject";
    }

    @GetMapping(value = "/users/delete/id")
    public String deleteUserById(@RequestParam(value = "id", required = true) Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "delete";
    }

}
