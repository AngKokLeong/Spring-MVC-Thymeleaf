package com.workshop.bookshelf.model;

public class Book {
    
    private Long id;
    private String title;
    private String author;
    private int year;
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
