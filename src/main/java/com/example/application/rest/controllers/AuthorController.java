package com.example.application.rest.controllers;

import com.example.application.rest.response.AuthorResponse;
import com.example.application.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public ResponseEntity<List<AuthorResponse>> getAll(){
        List<AuthorResponse> allAuthors = authorService.getAll();

        return ResponseEntity.ok(allAuthors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getById(@PathVariable("id") int id){
        Optional<AuthorResponse> authorResponse = authorService.getById(id);
        if (authorResponse.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(authorResponse.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AuthorResponse> delete(@PathVariable("id") int id){
        authorService.deleteAuthor(id);

        return ResponseEntity.
                noContent().
                build();
    }
}
