package com.example.demoFinal.mapper;

import com.example.demoFinal.dto.BookDto;
import com.example.demoFinal.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@RequiredArgsConstructor
@Component
public class CarteMapper {

    public BookDto bookEntityToDto(Book book){
        return BookDto.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }

    public List<BookDto> bookListEntityToDto(List<Book> books){
        return books.stream()
                .map(book -> bookEntityToDto(book))
                .toList();
    }

    public Book bookDtoToEntity(BookDto bookDto){
        return Book.builder()
                .title(bookDto.title())
                .author(bookDto.author())
                .build();
    }

    public List<Book> bookListDtoToEntity(List<BookDto> bookDtos){
        return bookDtos.stream()
                .map(bookDto -> bookDtoToEntity(bookDto))
                .toList();
    }
}