package com.example.application.rest.response;

import com.example.application.data.entities.Author;
import com.example.application.data.entities.Genre;
import java.util.List;

public class BookResponse {

    private int id;
    private int amount;
    private String title;
    private int year;
    private String publisher;
    private List<Genre> genres;
    private List<Author> authors;
    private String dateAdded;
    private String language;
    private String status;
    private String deactivationDate;
    private String deactivationDescription;
    private DeactivationReasonResponse deactivationReasonResponse;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public int getAmount() {return amount;}

    public void setAmount(int amount) {this.amount = amount;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public int getYear() {return year;}

    public void setYear(int year) {this.year = year;}

    public String getPublisher() {return publisher;}

    public void setPublisher(String publisher) {this.publisher = publisher;}

    public List<Genre> getGenres() {return genres;}

    public void setGenres(List<Genre> genres) {this.genres = genres;}

    public List<Author> getAuthors() {return authors;
    }

    public void setAuthors(List<Author> authors) {this.authors = authors;}

    public String getDateAdded() {return dateAdded;}

    public void setDateAdded(String dateAdded) {this.dateAdded = dateAdded;}

    public String getLanguage() {return language;}

    public void setLanguage(String language) {this.language = language;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public String getDeactivationDate() {return deactivationDate;}

    public void setDeactivationDate(String deactivationDate) {this.deactivationDate = deactivationDate;}

    public String getDeactivationDescription() {return deactivationDescription;}

    public void setDeactivationDescription(String deactivationDescription) {this.deactivationDescription = deactivationDescription;}

    public DeactivationReasonResponse getDeactivationReasonResponse() {return deactivationReasonResponse;}

    public void setDeactivationReasonResponse(DeactivationReasonResponse deactivationReasonResponse) {this.deactivationReasonResponse = deactivationReasonResponse;}
}
