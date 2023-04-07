package com.xfactor.openlibrary.controllers;

// import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xfactor.openlibrary.Domain.Author;
import com.xfactor.openlibrary.Repositories.AuthorRepository;

@RestController
@RequestMapping("authors")
public class AuthorController {
    
    private AuthorRepository authorRepository;
    

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/saveAuthor")
    public Author saveAuthor(@RequestBody Author au)
    {
        // lauthor.add(book);
        authorRepository.save(au);
        return au;
    }

    @GetMapping("/getAuthor")
    public List<Author> getAllAuthors()
    {
        return authorRepository.findAll();
    }

    @DeleteMapping("/deleteAuthor/{id}")
    public void deleteAuthor(@PathVariable Long id)
    {
        authorRepository.deleteById(id);
    }

    @GetMapping("/findbyid/{id}")
    public Author findById(@PathVariable Long id)
    {
        if(id != null)
        {
            Optional<Author> optionalOfBook = authorRepository.findById(id);
            if(optionalOfBook.isPresent())
            return optionalOfBook.get();
        }
        return null;
    }
}
