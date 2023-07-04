package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity

@Getter @Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    public Author( String name, List<Book> books){
        this.name=name;
        this.books=books;
    }
    public Author() {
    }
}
