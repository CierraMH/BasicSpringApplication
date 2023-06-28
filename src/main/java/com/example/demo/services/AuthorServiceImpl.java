package com.example.demo.services;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class AuthorServiceImpl implements AuthorService{
//    @Autowired
    private AuthorRepository authorRepository;
    //save
    @Override
    public Author saveAuthor(Author author){
        return authorRepository.save(author);
    }
    //read
    @Override
    public List<Author> readAuthor_List(){
        return (List<Author>) authorRepository.findAll();
    }
    //update
    @Override
    public Author updateAuthor(Author author, Long id){
        Author authorRepo = authorRepository.findById(id).get();
        if (Objects.nonNull(author.getName()) && !"".equalsIgnoreCase(author.getName())) {
            authorRepo.setName(author.getName());
        }
        if (Objects.nonNull(author.getBooks()) && !"".equalsIgnoreCase(author.getBooks().toString())) {
            authorRepo.setBooks(author.getBooks());
        }
        return authorRepository.save(authorRepo);
    }
    //delete
    @Override
    public void deleteAuthorByName(Long id){
        authorRepository.deleteById(id);
    }
}
