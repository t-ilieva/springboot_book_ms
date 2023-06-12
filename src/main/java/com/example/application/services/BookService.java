package com.example.application.services;

import com.example.application.data.entities.Author;
import com.example.application.data.entities.Book;
import com.example.application.data.entities.Genre;
import com.example.application.data.repositories.AuthorRepository;
import com.example.application.data.repositories.BookRepository;
import com.example.application.data.repositories.GenreRepository;
import com.example.application.rest.request.AuthorRequest;
import com.example.application.rest.request.BookRequest;
import com.example.application.rest.request.GenreRequest;
import com.example.application.rest.response.AuthorResponse;
import com.example.application.rest.response.BookResponse;
import com.example.application.rest.transformers.AuthorTransformer;
import com.example.application.rest.transformers.BookTransformer;
import com.example.application.rest.transformers.GenreTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;


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

    public int createBook(BookRequest bookRequest){

        List<AuthorRequest> authorRequests = new ArrayList<>(bookRequest.getAuthors());
        List<Author> authors = new ArrayList<>();
        for (AuthorRequest a:authorRequests) {

            Optional<Author> author;

            if(authorService.getByName(a.getFirstName(), a.getLastName()).isEmpty()){
                int id = authorService.createAuthor(a);
                author = authorService.getById(id).map(AuthorTransformer::toAuthorEntity);
            }
            else {
                author = authorService.getByName(a.getFirstName(), a.getLastName())
                        .map(AuthorTransformer::toAuthorEntity);
            }

            authors.add(author.get());

        }

        List<GenreRequest> genreRequests = new ArrayList<>(bookRequest.getGenres());
        List<Genre> genres = new ArrayList<>();

        Optional<Genre> genre;

        for (GenreRequest g:genreRequests) {
            if(genreService.getByName(g.getName()).isEmpty()){
                int id = genreService.createGenre(g);
                genre = genreService.getById(id).map(GenreTransformer::toGenreEntity);
            }
            else {
                genre = genreService.getByName(g.getName())
                        .map(GenreTransformer::toGenreEntity);
            }
            genres.add(genre.get());
        }

        Book book = BookTransformer.toBookEntity(bookRequest);
        book.setAuthors(new ArrayList<>());
        authors.forEach(a -> book.getAuthors().add(a));
        book.setGenres(genres);
        return bookRepository.save(book).getId();
    }
}
