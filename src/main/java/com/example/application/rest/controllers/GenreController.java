package com.example.application.rest.controllers;

import com.example.application.rest.request.GenreRequest;
import com.example.application.rest.response.GenreResponse;
import com.example.application.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("")
    public ResponseEntity<List<GenreResponse>> getAll(){
        List<GenreResponse> allGenres = genreService.getAll();

        return ResponseEntity.ok(allGenres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreResponse> getById(@PathVariable("id") int id){
        Optional<GenreResponse> genreResponse = genreService.getById(id);
        if (genreResponse.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(genreResponse.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenreResponse> delete(@PathVariable("id") int id){
        genreService.deleteGenre(id);

         return ResponseEntity.
                 noContent().
                 build();
    }

    @PutMapping()
    public ResponseEntity<GenreRequest> create(@RequestBody GenreRequest genreRequest,
                                         UriComponentsBuilder builder){
        int genreId = genreService.createGenre(genreRequest);

        URI location = builder.path("/genres/{id}").
                buildAndExpand(genreId).toUri();
        return ResponseEntity.
                created(location).
                build();
    }


}
