package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Book {
//    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id long id;
    private String title;
    @ManyToOne
    private Author author;

    public Book() {
    }
    public Book(Long id, String title, Author author){
        this.id=id;
        this.title=title;
        this.author=author;
    }

//    public Long getId(){
//        return id;
//    }
//    public void setId(Long id){
//        this.id=id;
//    }
//    public String getTitle() {
//        return title;
//    }
//    public void setTitle(String title) {
//        this.title = title;
//    }
//    public Author getAuthor() {
//        return author;
//    }
//    public void setAuthor(Author author) {
//        this.author = author;
//    }
}
