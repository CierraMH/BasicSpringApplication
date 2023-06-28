package com.example.demo.services;

import com.example.demo.model.Book;
import java.util.List;

public interface BookService {
    //save
    Book saveBook(Book book);
    //read
    List<Book> readBook_List();
    //update
    Book updateBook(Book book, Long id);
    //delete
    void deleteBookByTitle(Long id);
}
