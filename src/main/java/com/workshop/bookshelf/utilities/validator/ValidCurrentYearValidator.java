package com.workshop.bookshelf.utilities.validator;

import java.time.LocalDateTime;

import com.workshop.bookshelf.utilities.validator_interface.ValidCurrentYear;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class ValidCurrentYearValidator implements ConstraintValidator<ValidCurrentYear, Integer> {
    
    
    private Integer currentYear;


    @Override
    public void initialize(ValidCurrentYear validCurrentYear){}


    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        if(value == null)
            return true;

        formatMessage(context);
        this.currentYear = value;

        return value <= currentDateTime.getYear();
        
    }

    private void formatMessage(ConstraintValidatorContext context){
        String message = context.getDefaultConstraintMessageTemplate();
        String formattedMessage = String.format(message, this.currentYear);

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(formattedMessage).addConstraintViolation();
    }
    

}
