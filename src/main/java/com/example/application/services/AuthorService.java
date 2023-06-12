package com.example.application.services;

import com.example.application.data.entities.Author;
import com.example.application.data.repositories.AuthorRepository;
import com.example.application.rest.request.AuthorRequest;
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

    public Optional<AuthorResponse> getByName(String firstName, String lastname){
        return authorRepository.
                findByName(firstName, lastname).
                map(AuthorTransformer::toAuthorResponse);
    }

    public void deleteAuthor(int id){
        authorRepository.deleteById(id);
    }

    public int createAuthor(AuthorRequest authorRequest){
        Author author = AuthorTransformer.toAuthorEntity(authorRequest);
        return authorRepository.save(author).getId();
    }
}
