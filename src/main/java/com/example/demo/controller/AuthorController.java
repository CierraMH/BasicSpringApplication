package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.services.AuthorService;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//import static sun.security.pkcs11.wrapper.Functions.getId;

@RestController
@RequestMapping("/authors")
public class AuthorController {
//    @Autowired
    private AuthorService authorService;
    //save
    @PostMapping("/save-authors")
    public Author saveAuthor(@Validated @RequestBody Author author){
        return authorService.saveAuthor(author);
    }
    //READ
    @GetMapping ("/read-authors")
    public List<Author> readAuthor_List() {
        return authorService.readAuthor_List() /*"id: " + getId() + " Author Name: " + author.getName() + "A Books written by this Author are: " + author.getBooks()*/;
    }
    //update
    @PutMapping("/update-authors/{id}")
    public Author updateAuthor(@RequestBody Author author, @PathVariable("id") Long id){
        return authorService.updateAuthor(author, id);
    }
    //delete
    @DeleteMapping("/delete-authors/{id}")
    public String deleteAuthorByName(@PathVariable("id") Long id){
        authorService.deleteAuthorByName(id);
        return "Deleted!";
    }
}
