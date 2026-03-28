package com.workshop.bookshelf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.workshop.bookshelf.model.Book;
import com.workshop.bookshelf.service.BookService;

import jakarta.servlet.http.HttpServletResponse;

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

    //Step 2: Book List
    @GetMapping("/books")
    public String listBooks(Model model){
        
        //1. Fetch data from the service layer
        List<Book> allBooks = bookService.findAll();
        

        //2. Add it to the Model under the key "books"
        //  The template accesses it with $(books)
        model.addAttribute("books", allBooks);

        // 3. Return the view name (resolves to templates/books.html)
        return "books";

    }

    //Step 3: Book Detail Page
    @GetMapping("/books/{id}") // {id} is a URL placeholder
    public String bookDetail(@PathVariable Long id, Model model, HttpServletResponse response){ //Spring extracts "2" from /books/2
        return bookService.findById(id)
                            .map(book -> {
                                model.addAttribute("book", book);
                                return "book-detail"; //resolves to templates/book-detail.html
                            })
                            .orElseGet(() -> {
                                response.setStatus(404);
                                return "error/404"; // resolves to templates/error/404.html
                            });
    }
}
