package com.example.demo.services;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService{
    private BookRepository bookRepository;
    //save
    @Override
    public Book saveBook(Book book){
    return bookRepository.save(book);
    }
    //read
    @Override
    public List<Book> readBook_List(){
        return (List<Book>) bookRepository.findAll();
    }
    //update
    @Override
    public Book updateBook(Book book, Long id){
        Book bookRepo = bookRepository.findById(id).get();
        if (Objects.nonNull(book.getTitle()) && !"".equalsIgnoreCase(book.getTitle())) {
        bookRepo.setTitle(book.getTitle());
        }
        if (Objects.nonNull(book.getAuthor().getBooks()) && !"".equalsIgnoreCase(book.getAuthor().getBooks().toString())) {
            bookRepo.setTitle(book.getAuthor().getBooks().toString());
        }
        return bookRepository.save(bookRepo);
    }
    //delete
    @Override
    public void deleteBookByTitle(Long id){
        bookRepository.deleteById(id);
    }
}
