package com.xfactor.openlibrary.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xfactor.openlibrary.Domain.Publisher;
import com.xfactor.openlibrary.Repositories.PublisherRepository;

@RestController
@RequestMapping("publishers")
public class PublisherController {
    
    private PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }


    @PostMapping("/savePublisher")
    public Publisher savePublisher(@RequestBody Publisher pub)
    {
        publisherRepository.save(pub);
        return pub;
    }


    @GetMapping("/getPublisher")
    public List<Publisher> getAllPublishers()
    {
        return publisherRepository.findAll();
    }

    @DeleteMapping("delete/{id}")
    public void deleteBook(@PathVariable Long id)
    {
        publisherRepository.deleteById(id);
    }

    @GetMapping("/findbyid/{id}")
    public Publisher findById(@PathVariable Long id)
    {
        if(id != null)
        {
            Optional<Publisher> optionalOfBook = publisherRepository.findById(id);
            if(optionalOfBook.isPresent())
            return optionalOfBook.get();
        }
        return null;
    }

    @GetMapping("/findbyname/{name}")
    public List<Publisher> findByName(@PathVariable String  name)
    {
            List<Publisher> listbooks = publisherRepository.findByName(name);
            return listbooks;
    }
}
