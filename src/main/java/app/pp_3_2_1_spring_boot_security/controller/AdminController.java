package app.pp_3_2_1_spring_boot_security.controller;

import app.pp_3_2_1_spring_boot_security.entity.User;
import app.pp_3_2_1_spring_boot_security.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private UserServiceImpl userService;


    @ModelAttribute("newUser")
    public User getPerson() { return new User(); }


    @GetMapping("/admin")
    public String showAllUsers(Model model){
        model.addAttribute("allUsers", userService.getAllUsers());
        return "admin";
    }

    @PostMapping("/admin")
    public String addNewUser(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("allUsers", userService.getAllUsers());
            return "admin";
        }
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PostMapping("admin/{id}/delete")
    public String deleteUser(@ModelAttribute("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("admin/{id}/edit")
    public String editUser(@ModelAttribute("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PostMapping("admin/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { return "edit"; }
        userService.updateUser(user);
        return "redirect:/admin";
    }

}