package com.example.application.rest.controllers;

import com.example.application.rest.request.AuthorRequest;
import com.example.application.rest.response.AuthorResponse;
import com.example.application.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/{first_name}/{last_name}")
    public ResponseEntity<AuthorResponse> getByName(@PathVariable("first_name") String firstName, @PathVariable("last_name") String lastName){
        Optional<AuthorResponse> authorResponse = authorService.getByName(firstName, lastName);
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

    @PostMapping()
    public ResponseEntity<AuthorRequest> create(@RequestBody AuthorRequest authorRequest,
                                                UriComponentsBuilder builder){
        int authorId = authorService.createAuthor(authorRequest);

        URI location = builder.path("/authors/{id}").
                buildAndExpand(authorId).toUri();
        return ResponseEntity.
                created(location).
                build();
    }
}
