package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import web.model.User;

import web.service.UserService;


@Controller
//@RequestMapping(value = "/", produces = {"application/xml; charset=UTF-8"})
public class UserController {
    private UserService userService;


//    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String ListUsers(Model model) {
        model.addAttribute("users", userService.listAllUsers());
        System.out.println(userService.listAllUsers());
        return "users";
    }

    @GetMapping(value = {"/add"})
    public String newUser(Model model) {
//        model.addAttribute("add", true);
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

//    @PatchMapping(value = "/{id}")
    @PostMapping(value = "/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @GetMapping(value = "/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
