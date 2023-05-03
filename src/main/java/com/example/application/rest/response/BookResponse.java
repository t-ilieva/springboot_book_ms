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
    private List<GenreResponse> genreResponses;
    private List<AuthorResponse> authorResponses;
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

    public List<GenreResponse> getGenres() {return genreResponses;}

    public void setGenres(List<GenreResponse> genres) {this.genreResponses = genres;}

    public List<AuthorResponse> getAuthors() {return authorResponses;}

    public void setAuthors(List<AuthorResponse> authors) {this.authorResponses = authors;}

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
