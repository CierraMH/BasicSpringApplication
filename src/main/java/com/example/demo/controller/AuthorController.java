package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
  @Autowired private AuthorRepository authorRepository;

    //save/create
    @PostMapping
    public String saveAuthor(@ModelAttribute Author saveAuthors){
        authorRepository.save(saveAuthors);
        return "redirect:/authors";
    }
    //read authors
    @GetMapping
    public String readAuthors(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "readAuthors";
    }
    //read by ID
    @GetMapping("/{id}")
    public String readByID(@PathVariable("id") Long id, Model model){
        Author authorWithId = authorRepository.findById(id).orElseThrow();
        model.addAttribute("author", authorWithId);
        return "read-authorsID";
    }
    //update
    @PostMapping("/{id}")
    public String updateAuthor(@PathVariable("id") Long id, @RequestBody Author authorUpdate){
        authorRepository.findById(id).map(author -> {
            author.setName(authorUpdate.getName());
            return authorRepository.save(author);
        }).orElseThrow();
           return "redirect:/authors";
    }
    //delete
    @PostMapping("/{id}/delete")
    public String deleteAuthor(@PathVariable("id") Long id){
        authorRepository.deleteById(id);
        return "redirect:/authors";
    }

    //create form
    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("author", new Author());
        return "AuthorsForms";
    }
    //update form
    @GetMapping("/{id}/update")
    public String updateForm(@PathVariable Long id, Model model){
        Author author = authorRepository.findById(id).orElseThrow();
        model.addAttribute("author", author);
        return "AuthorsForms";
    }

}
