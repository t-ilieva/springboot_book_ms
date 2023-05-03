package com.example.application.services;

import com.example.application.data.entities.Genre;
import com.example.application.data.repositories.GenreRepository;
import com.example.application.rest.request.GenreRequest;
import com.example.application.rest.response.GenreResponse;
import com.example.application.rest.transformers.GenreTransformer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<GenreResponse> getAll(){
        return genreRepository.
                findAll().
                stream().
                map(GenreTransformer::toGenreResponse).
                collect(Collectors.toList());
    }

    public Optional<GenreResponse> getById(int id){
        return genreRepository.
                findById(id).
                map(GenreTransformer::toGenreResponse);
    }

    public void deleteGenre(int id){
        genreRepository.deleteById(id);
    }

    public int createGenre(GenreRequest genreRequest){
        Genre genre = GenreTransformer.toGenreEntity(genreRequest);
        return genreRepository.save(genre).getId();
    }
}
