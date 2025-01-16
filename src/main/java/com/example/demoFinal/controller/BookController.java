package com.example.demoFinal.controller;

import com.example.demoFinal.dto.BookDto;
import com.example.demoFinal.dto.UserDto;
import com.example.demoFinal.model.Book;
import com.example.demoFinal.model.RegistrationRequest;
import com.example.demoFinal.model.User;
import com.example.demoFinal.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public String getBooks(Model model) {
        List<BookDto> bookDtos = bookService.getAllBooks();
        model.addAttribute("title", "Books");
        model.addAttribute("books", bookDtos);
        return "books";
    }
//
//    @GetMapping("/users/{id}")
//    public UserDto getUserById(@PathVariable Integer id){
//        return userService.getUserById(id);
//    }

    @GetMapping({"/books/create"})
    public String displayCreateBookForm(Model model) {

        model.addAttribute("book", new Book());
        return "/book/create";
    }

    @PostMapping("/books/create")
    public String createBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {

        BookDto bookDto = bookService.createBook(book);
        redirectAttributes.addAttribute("registrationSuccess", "Success");

        return "redirect:/books";
    }

    @GetMapping("/books/delete")
    public String displayDeleteBookForm(Model model) {
        model.addAttribute("title", "Delete Book");
        model.addAttribute("books", this.bookService.getAllBooks());
        return "book/delete";
    }

    @PostMapping("/books/delete")
    public String processDeleteBookForm(@ModelAttribute("title") String[] titles) {
        if (titles != null) {
            for(String title : titles){
                Book bookOpt = bookService.findBookByTitle(title);
                if(bookOpt!=null) {
                    this.bookService.deleteBook(bookOpt);
                }
            }
        }
        return "redirect:/books";
    }

//    @GetMapping({"/users/update"})
//    public String displayEditUserForm(Model model) {
//        model.addAttribute("title", "Edit users");
//        model.addAttribute("users", this.userService.getAllUsers());
//        return "user/update";
//    }

}