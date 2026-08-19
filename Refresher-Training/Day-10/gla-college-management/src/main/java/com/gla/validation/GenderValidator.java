package com.gla.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenderValidator
        implements ConstraintValidator<ValidGender, String> {

    @Override
    public boolean isValid(
            String gender,
            ConstraintValidatorContext context) {

        if (gender == null || gender.isBlank()) {
            return true;
        }

        return gender.equalsIgnoreCase("Male")
                || gender.equalsIgnoreCase("Female")
                || gender.equalsIgnoreCase("Other");
    }
}