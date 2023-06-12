package com.example.application.rest.controllers;

import com.example.application.rest.request.BookRequest;
import com.example.application.rest.response.BookResponse;
import com.example.application.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public ResponseEntity<List<BookResponse>> getAll(){
        List<BookResponse> allBooks = bookService.getAll();

        return ResponseEntity.ok(allBooks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getById(@PathVariable("id") int id){
        Optional<BookResponse> bookResponse = bookService.getById(id);
        if (bookResponse.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(bookResponse.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookResponse> delete(@PathVariable("id") int id){
        bookService.deleteBook(id);

        return ResponseEntity.
                noContent().
                build();
    }

    @PostMapping()
    public ResponseEntity<BookRequest> create(@RequestBody BookRequest bookRequest,
                                              UriComponentsBuilder builder){

        int bookId = bookService.createBook(bookRequest);

        URI location = builder.path("/books/{id}").
                buildAndExpand(bookId).toUri();
        return ResponseEntity.
                created(location).
                build();
    }
}
