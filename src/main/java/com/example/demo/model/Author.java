package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter @Setter
public class Author {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id long id;
    private String name;
    @OneToMany
    private List<Book> books;

    public Author() {
    }

    public Author(Long id, String name, List<Book> books){
        this.id=id;
        this.name=name;
        this.books=books;
    }

//    public Long getId(){
//        return id;
//    }
//
//    public void setId(Long id){
//        this.id=id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }
}
