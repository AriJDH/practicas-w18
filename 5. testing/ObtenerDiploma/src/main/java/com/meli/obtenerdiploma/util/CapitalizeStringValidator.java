package com.meli.obtenerdiploma.util;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CapitalizeStringValidator implements ConstraintValidator<CapitalizeStringConstraint, String> {

    @Override
    public void initialize(CapitalizeStringConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Character.isUpperCase(value.charAt(0));
    }


}
