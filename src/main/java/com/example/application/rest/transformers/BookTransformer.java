package com.example.application.rest.transformers;

import com.example.application.data.entities.Book;
import com.example.application.data.entities.Genre;
import com.example.application.rest.request.BookRequest;
import com.example.application.rest.response.AuthorResponse;
import com.example.application.rest.response.BookResponse;
import com.example.application.rest.response.DeactivationReasonResponse;
import com.example.application.rest.response.GenreResponse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BookTransformer {

    private static final SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    public static BookResponse toBookResponse(Book book){
        BookResponse bookResponse = new BookResponse();
        bookResponse.setId(book.getId());
        bookResponse.setAmount(book.getAmount());
        bookResponse.setTitle(book.getTitle());
        bookResponse.setYear(book.getYear());
        bookResponse.setPublisher(book.getPublisher());
        bookResponse.setLanguage(book.getLanguage());
        bookResponse.setStatus(book.getStatus());
        bookResponse.setDeactivationDescription(book.getDeactivationDescription());
        bookResponse.setDateAdded(DATE_TIME_FORMATTER.format(book.getDateAdded()));
        if(book.getDeactivationDate() != null){
            bookResponse.setDeactivationDate(DATE_TIME_FORMATTER.format(book.getDeactivationDate()));
        } else {
            bookResponse.setDeactivationDate(null);
        }

        if(book.getDeactivationReason() != null){
            DeactivationReasonResponse deactivationReasonResponse =
                    DeactivationReasonTransformer.toDeactivationReasonResponse(book.getDeactivationReason());

            bookResponse.setDeactivationReasonResponse(deactivationReasonResponse);
        } else {
            bookResponse.setDeactivationReasonResponse(null);
        }

        List<AuthorResponse> authors =
                book.
                getAuthors().
                stream().
                map(AuthorTransformer::toAuthorResponse).
                collect(Collectors.toList());
        bookResponse.setAuthors(authors);

        List<Genre> genres = book.getGenres();
        List<GenreResponse> genreResponses = new ArrayList<>();
        genres.forEach(genre -> genreResponses.add(GenreTransformer.toGenreResponse(genre)));

        bookResponse.setGenres(genreResponses);

        return bookResponse;
    }

    public Book toBookEntity(BookRequest bookRequest){
        Book book = new Book();
        book.setAmount(bookRequest.getAmount());
        book.setTitle(bookRequest.getTitle());
        book.setIsbn(bookRequest.getIsbn());
        book.setYear(bookRequest.getYear());
        book.setPublisher(bookRequest.getPublisher());
        book.setLanguage(bookRequest.getLanguage());
        book.setStatus(bookRequest.getStatus());
        book.setDateAdded(new Date());

        return book;
    }
}
