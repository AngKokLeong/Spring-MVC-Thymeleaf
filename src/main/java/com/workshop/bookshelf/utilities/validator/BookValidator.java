package com.workshop.bookshelf.utilities.validator;

import java.time.LocalDateTime;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.workshop.bookshelf.model.Book;




public class BookValidator implements Validator{
    //Reference: https://docs.spring.io/spring-framework/reference/core/validation/validator.html

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        
        ValidationUtils.rejectIfEmpty(errors, "title", "title.empty");
        ValidationUtils.rejectIfEmpty(errors, "author", "author.empty");
        ValidationUtils.rejectIfEmpty(errors, "genre", "genre.empty");

        Book book = (Book)target;

        if (book.getTitle().length() > 150){
            errors.reject("book.title", "Book Title text length cannot exceed 150 characters");
        }else if (book.getAuthor().length() > 150){
            errors.reject("book.author", "Book Author text length cannot exceed 150 characters");
        }else if (book.getYear() > LocalDateTime.now().getYear()){
            errors.reject("book.year", "Year cannot exceed current year");
        }else if(book.getGenre().isBlank()){
            errors.reject("book.genre", "Genre cannot be blank");
        }

    }




}
