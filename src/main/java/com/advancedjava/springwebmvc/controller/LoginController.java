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
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/login/add/")
    public String getAddUserForm(@ModelAttribute("userObject") User user, Model model) {
        if (user == null) {
            user = new User();
        }
        model.addAttribute("message", "Vous voulez ajouter un utilisateur");
        return "modifyuser";
    }

    @PostMapping("/login/add/")
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


}
