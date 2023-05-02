package com.example.application.rest.transformers;

import com.example.application.data.entities.Book;
import com.example.application.rest.request.BookRequest;
import com.example.application.rest.response.BookResponse;
import com.example.application.rest.response.DeactivationReasonResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

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
