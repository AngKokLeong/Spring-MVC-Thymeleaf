package com.workshop.bookshelf.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class Book {
    
    private Long id;

    @NotBlank(message="Title should not be blank")
    @Size(max=150 , message="Title length should not exceed 150 characters")
    private String title;

    @NotBlank(message="Author should not be blank")
    private String author;

    @Min(value=1000, message="Year should not be lower than 1000")
    @Max(value=2026, message="Year should not exceed current year")
    private int year;

    @NotBlank(message="Genre should not be blank")
    private String genre;

    public Book(){}

    public Book(Long id, String title, String author, int year, String genre){
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public int getYear(){
        return this.year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public String getGenre(){
        return this.genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }


}
