package com.example.demoFinal.service;

import com.example.demoFinal.dto.BookDto;
import com.example.demoFinal.model.Book;

import java.util.List;

public interface BookService {
    BookDto getBookById(Integer id);

    Book findBookByID(Integer id);

    Book findBookByTitle(String name);

    List<BookDto> getAllBooks();

    BookDto createBook(Book book);

    BookDto updateBook(Book book);

    void deleteBook(Book book);
}
