package com.advancedjava.springwebmvc.controller;

import com.advancedjava.springwebmvc.entity.User;
import com.advancedjava.springwebmvc.repository.UserRepository;
import com.advancedjava.springwebmvc.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @GetMapping("/users/{id}")
    public String getUserViaPathVariable(@PathVariable String id, Model model) {
        return returnJspUsersWithId(id, model);
    }

    private String returnJspUsersWithId(@PathVariable String id, Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("selectedUser", userRepository.findById(id));
        model.addAttribute("message", "le produit " + id + " a été recupéré");
        return "users";
    }

    @GetMapping("/users/add/")
    public String getAddUserForm(@ModelAttribute("userObject") User user, Model model) {
        if (user == null) {
            user = new User();
        }
        model.addAttribute("message", "Vous voulez ajouter un utilisateur");
        return "modifyuser";
    }

    @PostMapping("/users/add/")
    public String addUser(@Valid @ModelAttribute("userObject") User user, BindingResult result, Model model) {
        System.out.println(user);
        new UserValidator(user.getConfirmPassword()).validate(user, result);
        if (result.hasErrors()) {
            return "modifyuser";
        } else {
            userRepository.save(user);
        }
        model.addAttribute("message", "Un nouveau produit a été ajouté");
        return "redirect:/users/";
    }

    @GetMapping("/users/modify/{userId}")
    public String getUserFromForUserId(@PathVariable String userId, Model model) {
        model.addAttribute("message", "Le produit " + userId + " va être modifié");
        model.addAttribute("userObject", userRepository.findById(userId));
        return "modifyuser";
    }

    @PostMapping("/users/modify/{userId}")
    public String updateUser(@ModelAttribute("userObject") User user, @PathVariable String userId, Model model) {
        user.setUsername(userId);
        if (user.getUsername() != null) {
            userRepository.save(user);
        }
        model.addAttribute("message", "Le produit " + user.getUsername() + " a été modifié");
        return "redirect:/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable String id, Model model) {
        userRepository.deleteById(id);
        model.addAttribute("message", "Le utilisateur " + id + " a été supprimé");
        return "redirect:/users";
    }

}
