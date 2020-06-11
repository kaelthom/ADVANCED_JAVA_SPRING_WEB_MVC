package com.advancedjava.springwebmvc.validator;

import com.advancedjava.springwebmvc.entity.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    private final String passwordConfirm;

    public UserValidator(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "user.name.notempty", "Please provide a username");
        if (!passwordConfirm.equals(((User) o).getPassword())) {
            errors.rejectValue("password", "password.notsame", "passwords are different");
            errors.rejectValue("confirmPassword", "password.notsame", "passwords are different");
        }
    }
}
