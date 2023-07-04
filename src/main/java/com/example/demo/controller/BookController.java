package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired private BookRepository bookRepository;
    @Autowired private AuthorRepository authorRepository;

    //form to create new book
    @GetMapping("/create")
    public String bookForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorRepository.findAll());
        return "BookForm";
    }

    //save/create
    @PostMapping
    public String saveBook(@ModelAttribute Book saveBooks){
        bookRepository.save(saveBooks);
        return "redirect:/books";
    }
    //Read
    @GetMapping
    public String readBookList(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "BookList";
    }
    //book Id
    @GetMapping("/{id}")
    public String readBooksById(@PathVariable Long id, Model model){
        Book book = bookRepository.findById(id).orElseThrow();
        model.addAttribute("book", book);
        return "read-bookID";
    }
    //update form
    @GetMapping("/{id}/update")
    public String updateBookForm(@PathVariable Long id, Model model){
        Book book = bookRepository.findById(id).orElseThrow();
        authorRepository.findById(id).orElseThrow();
        model.addAttribute("book", book);
        model.addAttribute("authors", authorRepository.findAll());
        return "BookForm";
    }

    //update
    @PutMapping("/{id}")
    public String updateBook(@PathVariable("id") Long id, @RequestBody Book bookUpdate){
        bookRepository.findById(id).map(book -> {
            book.setTitle(bookUpdate.getTitle());
            book.setAuthor(bookUpdate.getAuthor());
            return bookRepository.save(book);
        }).orElseThrow();
        return "redirect:/books";
    }
    //delete
    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable("id") Long id){
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}
