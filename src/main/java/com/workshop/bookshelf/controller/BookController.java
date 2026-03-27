package com.workshop.bookshelf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.workshop.bookshelf.service.BookService;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    //Step 1: Home Page
    @GetMapping("/")
    public String home(){
        return "index";
    }
}
