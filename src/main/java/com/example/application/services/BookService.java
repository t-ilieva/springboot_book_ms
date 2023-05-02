package com.example.application.services;

import com.example.application.data.repositories.BookRepository;
import com.example.application.rest.response.BookResponse;
import com.example.application.rest.transformers.BookTransformer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponse> getAll(){
        return bookRepository.
                findAll().
                stream().
                map(BookTransformer::toBookResponse).
                collect(Collectors.toList());
    }

    public Optional<BookResponse> getById(int id){
        return bookRepository.
                findById(id).
                map(BookTransformer::toBookResponse);
    }

    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }
}
