package com.rined.crud.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String validateField, ConstraintValidatorContext constraintValidatorContext) {
        return Objects.nonNull(constraintValidatorContext)
                && validateField.matches("\\+?[0-9]+")
                && (validateField.length() > 8) && (validateField.length() < 14);
    }
}
