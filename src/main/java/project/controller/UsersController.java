package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.User;
import project.repository.UserRepository;

@Controller
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }


    @GetMapping(value = "/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    /**
     * Маппинги для добавляения нового пользователя
     */
    @GetMapping(value = "/users/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping(value = "/users/new")
    public String saveUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "changeconfirm";
    }

    /**
     * Мапы для изменения пользователя
     */

    @GetMapping(value = "/users/change/id")
    public String changeUserById(@RequestParam(value = "id", required = true) Long id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        return "change";
    }

    @PostMapping(value = "/users/change/id")
    public String saveChangesInUser(@ModelAttribute User user, @RequestParam Long id) {
        userRepository.save(user);
        return "changeconfirm";
    }

    /**
     * Маппинги для удаления
     */

    @GetMapping(value = "/users/delete/id")
    public String deleteUserById(@RequestParam(value = "id", required = true) Long id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        return "delete";
    }

    @PostMapping(value = "/users/delete/id")
    public String deletingUserById(@RequestParam(value = "id", required = true) Long id) {
        userRepository.deleteById(id);
        return "changeconfirm";
    }
}
