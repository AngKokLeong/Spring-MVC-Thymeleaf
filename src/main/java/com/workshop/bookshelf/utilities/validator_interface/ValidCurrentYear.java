package com.workshop.bookshelf.utilities.validator_interface;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.workshop.bookshelf.utilities.validator.ValidCurrentYearValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidCurrentYearValidator.class)
public @interface ValidCurrentYear{

    String message() default "Year must be less than or equal to %s";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}