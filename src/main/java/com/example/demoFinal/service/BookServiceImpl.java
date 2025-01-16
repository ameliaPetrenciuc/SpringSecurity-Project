package com.example.demoFinal.service;

import com.example.demoFinal.dto.BookDto;
import com.example.demoFinal.mapper.CarteMapper;
import com.example.demoFinal.model.Book;
import com.example.demoFinal.model.User;
import com.example.demoFinal.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;
    private final CarteMapper bookMapper;

    @Override
    public BookDto getBookById(Integer id) {
        return bookMapper.bookEntityToDto(bookRepository.findById(id).orElse(null));
    }

    @Override
    public Book findBookByID(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book findBookByTitle(String title) {
        return bookRepository.findByTitle(title).orElse(null);
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookMapper.bookListEntityToDto(bookRepository.findAll());
    }

    @Override
    public BookDto createBook(Book book) {
        return bookMapper.bookEntityToDto(bookRepository.save(book));
    }

    @Override
    public BookDto updateBook(Book book) {
        return bookMapper.bookEntityToDto(bookRepository.save(book));
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }
}

