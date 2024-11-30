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

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }


    @GetMapping(value = "/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
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
        userService.addUser(user);
        return "changeconfirm";
    }

    /**
     * Мапы для изменения пользователя
     */

    @GetMapping(value = "/users/change/id")
    public String changeUserById(@RequestParam(value = "id", required = true) Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "change";
    }

    @PostMapping(value = "/users/change/id")
    public String saveChangesInUser(@ModelAttribute User user, @RequestParam Long id) {
        userService.updateUser(user);
        return "changeconfirm";
    }

    /**
     * Дубль метода через @RequestParam
     */
    /*
    @PostMapping(value = "/users/change/id")
    public String saveChangesInUser(@RequestParam Long id,
                                    @RequestParam String username,
                                    @RequestParam String password,
                                    @RequestParam String firstName,
                                    @RequestParam String lastName) {
        boolean checkUpdate = false;
        User user = userService.findUserById(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userService.updateUser(user, checkUpdate);
        if (checkUpdate) {
            return "cangeconfirm";
        }
        return "changesreject";
    }
    */

    /**
     * Маппинги для удаления
     */

    @GetMapping(value = "/users/delete/id")
    public String deleteUserById(@RequestParam(value = "id", required = true) Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "delete";
    }

    @PostMapping(value = "/users/delete/id")
    public String deletingUserById(@RequestParam(value = "id", required = true) Long id) {
        userService.removeUserById(id);
        return "changeconfirm";
    }
}
