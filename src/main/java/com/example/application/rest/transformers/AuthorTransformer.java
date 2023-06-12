package com.example.application.rest.transformers;

import com.example.application.data.entities.Author;
import com.example.application.rest.request.AuthorRequest;
import com.example.application.rest.response.AuthorResponse;

import java.util.Optional;

public class AuthorTransformer {

    public static AuthorResponse toAuthorResponse(Author author){
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setId(author.getId());
        authorResponse.setFirstName(author.getFirstName());
        authorResponse.setLastName(author.getLastName());

        return authorResponse;
    }

    public static Author toAuthorEntity(AuthorRequest authorRequest){
        Author author = new Author();
        author.setFirstName(authorRequest.getFirstName());
        author.setLastName(authorRequest.getLastName());

        return author;
    }

    public static Author toAuthorEntity(AuthorResponse authorResponse){
        Author author = new Author();
        author.setFirstName(authorResponse.getFirstName());
        author.setLastName(authorResponse.getLastName());
        author.setId(authorResponse.getId());

        return author;
    }
}
