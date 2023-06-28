package com.example.demo.services;

import com.example.demo.model.Author;
import java.util.List;

public interface AuthorService {
    //save
    Author saveAuthor(Author author);
    //read
    List<Author> readAuthor_List();
    //update
    Author updateAuthor(Author author, Long id);
    //delete
    void deleteAuthorByName(Long id);
}
