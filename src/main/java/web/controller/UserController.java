package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import web.model.User;

import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {
    private UserServiceImpl userService;
    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    List<User> users = userService.listAllUsers();

    @GetMapping("/users")
    public String ListUsers(Model model) {
        model.addAttribute("users", users);
        System.out.println(users);
        return "users";
    }
}
