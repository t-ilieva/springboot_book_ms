package com.example.application.rest.transformers;

import com.example.application.data.entities.Genre;
import com.example.application.rest.request.GenreRequest;
import com.example.application.rest.response.GenreResponse;

public class GenreTransformer {

    public static GenreResponse toGenreResponse(Genre genre){
        GenreResponse genreResponse = new GenreResponse();
        genreResponse.setId(genre.getId());
        genreResponse.setName(genre.getName());

        return genreResponse;
    }

    public static Genre toGenreEntity(GenreRequest genreRequest){
        Genre genre = new Genre();
        genre.setName(genreRequest.getName());

        return genre;
    }

    public static Genre toGenreEntity(GenreResponse genreResponse){
        Genre genre = new Genre();
        genre.setId(genreResponse.getId());
        genre.setName(genreResponse.getName());

        return genre;
    }
}
