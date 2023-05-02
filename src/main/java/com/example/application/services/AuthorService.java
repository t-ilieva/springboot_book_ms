package com.example.application.services;

import com.example.application.data.entities.Author;
import com.example.application.data.repositories.AuthorRepository;
import com.example.application.rest.response.AuthorResponse;
import com.example.application.rest.transformers.AuthorTransformer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorResponse> getAll(){
        return authorRepository.
                findAll().
                stream().
                map(AuthorTransformer::toAuthorResponse).
                collect(Collectors.toList());
    }

    public Optional<AuthorResponse> getById(int id){
        return authorRepository.
                findById(id).
                map(AuthorTransformer::toAuthorResponse);
    }

    public void deleteAuthor(int id){
        authorRepository.deleteById(id);
    }

//    public void createAuthor(String firstName, String lastName){
//        Author author = new Author();
//
//        authorRepository.save(author);
//
//    }

   //public AuthorResponse findByName(String firstName, String lastName){
    //    return authorRepository.findByName(firstName, lastName);

   //}
}
