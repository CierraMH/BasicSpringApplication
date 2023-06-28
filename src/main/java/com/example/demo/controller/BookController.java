package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.services.BookService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;
    //save
    @PostMapping("/books")
    public Book saveBook(@Validated @RequestBody Book book){
        return bookService.saveBook(book);
    }
    //Read
    @GetMapping("/books")
    public List<Book> readBook_List() {
        return bookService.readBook_List() /*"id: " + getId() + " Author Name: " + author.getName() + "A Books written by this Author are: " + author.getBooks()*/;
    }
    //update
    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") Long id){
        return bookService.updateBook(book, id);
    }
    //delete
    @DeleteMapping("/books/{id}")
    public String deleteBookByTitle(@PathVariable("id") Long id){
        bookService.deleteBookByTitle(id);
        return "Book Deleted!";
    }
}
