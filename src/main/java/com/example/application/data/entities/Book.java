package com.example.application.data.entities;
import jakarta.persistence.*;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int amount;
    private String title;
    private String isbn;
    private int year;
    private String publisher;
    private String status;
    @Column(name = "date_added")
    private Date dateAdded;
    @Column(name = "deactivation_date")
    private Date deactivationDate;
    @Column(name = "deactivation_description")
    private String deactivationDescription;
    private String language;

    @ManyToMany(mappedBy = "books")
    private List<Genre> genres;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @ManyToOne
    @JoinColumn(name = "deactivation_reason_id")
    private DeactivationReason deactivationReason;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDeactivationDate() {
        return deactivationDate;
    }

    public void setDeactivationDate(Date deactivationDate) {
        this.deactivationDate = deactivationDate;
    }

    public String getDeactivationDescription() {
        return deactivationDescription;
    }

    public void setDeactivationDescription(String deactivationDescription) {
        this.deactivationDescription = deactivationDescription;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public DeactivationReason getDeactivationReason() {
        return deactivationReason;
    }

    public void setDeactivationReason(DeactivationReason deactivationReason) {
        this.deactivationReason = deactivationReason;
    }
}
