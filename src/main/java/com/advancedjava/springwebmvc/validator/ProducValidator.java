package com.advancedjava.springwebmvc.validator;

import com.advancedjava.springwebmvc.entity.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProducValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "product.name", "You must specify a name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "unitPrice", "product.unitPrice", "You must specify a price");
    }
}
