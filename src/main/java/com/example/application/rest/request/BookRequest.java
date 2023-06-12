package com.example.application.rest.request;

import com.example.application.data.entities.Author;
import com.example.application.data.entities.Genre;
import java.util.List;

public class BookRequest {

    private int amount;
    private String title;
    private String isbn;
    private int year;
    private String publisher;
    private String language;
    private String status;
    private List<GenreRequest> genres;
    private List<AuthorRequest> authors;

    public int getAmount() {return amount;}

    public void setAmount(int amount) {this.amount = amount;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getIsbn() {return isbn;}

    public void setIsbn(String isbn) {this.isbn = isbn;}

    public int getYear() {return year;}

    public void setYear(int year) {this.year = year;}

    public String getPublisher() {return publisher;}

    public void setPublisher(String publisher) {this.publisher = publisher;}

    public String getLanguage() {return language;}

    public void setLanguage(String language) {this.language = language;}

    public List<GenreRequest> getGenres() {return genres;}

    public void setGenres(List<GenreRequest> genres) {this.genres = genres;}

    public List<AuthorRequest> getAuthors() {return authors;}

    public void setAuthors(List<AuthorRequest> authors) {this.authors = authors;}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
