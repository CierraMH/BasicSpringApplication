package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "authorBooks")
    private Author author;

    public Book() {
    }
    public Book(Long id, String title, Author author){
        this.id=id;
        this.title=title;
        this.author=author;
    }
}
