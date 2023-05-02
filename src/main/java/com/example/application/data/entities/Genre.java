package com.example.application.data.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id",
            referencedColumnName = "id"))
    private List<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}