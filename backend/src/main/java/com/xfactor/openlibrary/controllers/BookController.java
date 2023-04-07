package com.xfactor.openlibrary.controllers;

// import java.util.ArrayList;
// import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xfactor.openlibrary.Domain.Books;
import com.xfactor.openlibrary.Repositories.BookRepository;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("book")
public class BookController {

    private BookRepository bookRepository;

    

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // List<Books> lBooks = new ArrayList<>();

    @PostMapping("/saveBook")
    public Books saveBook(@RequestBody Books book)
    {
        // lBooks.add(book);
        bookRepository.save(book);
        return book;
    }

    @GetMapping("/getAll")
    public List<Books> getAllBooks()
    {
        return bookRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public Books findById(@PathVariable Long id)
    {
        if(id != null)
        {
            Optional<Books> optionalOfBook = bookRepository.findById(id);
            if(optionalOfBook.isPresent())
            return optionalOfBook.get();
        }
        return null;
    }

    @DeleteMapping("delete/{id}")
    public void deleteBook(@PathVariable Long id)
    {
        bookRepository.deleteById(id);
    }

    @GetMapping("/findbyisbn/{isbn}")
    public List<Books> findByISBN(@PathVariable String  isbn)
    {
            List<Books> listbooks = bookRepository.findByIsbn(isbn);
            return listbooks;
    }

    @GetMapping("/findByNameAndIsbn/{name}/{isbn}")
    public List<Books> findByNameAndIsbn(@PathVariable String name, @PathVariable String isbn)
    {
        List<Books> lb1 = bookRepository.findByNameAndIsbn(name, isbn);
        return lb1; 
    }

    @GetMapping("findTotal")
    public Long findTotal() {
        return bookRepository.count();
    }



    // @GetMapping("/books")
    // public ArrayList<HashMap<Object, Object>> getallbooks()
    // {
    //     HashMap<Object,Object> h1 = new HashMap<>();
    //     h1.put("Name", "The Alchemist");
    //     h1.put("Author", "Paulo Coelho");
    //     h1.put("id", "A101D");
    //     h1.put("Number of pages", 562);
    //     h1.put("Price", 350);
    //     h1.put("Year of Publication", 2015);
    //     HashMap<Object,Object> h2 = new HashMap<>();
    //     h2.put("Name", "Da Vinci Code");
    //     h2.put("Author", "Dan Brown");
    //     h2.put("id", "T762D");
    //     h2.put("Number of pages", 661);
    //     h2.put("Price", 450);
    //     h2.put("Year of Publication", 2017);
    //     HashMap<Object,Object> h3 = new HashMap<>();
    //     h3.put("Name", "Sherlock Holmes");
    //     h3.put("Author", "Arthur Conan Doyle");
    //     h3.put("id", "M504C");
    //     h3.put("Number of pages", 340);
    //     h3.put("Price", 300);
    //     h3.put("Year of Publication", 2012);
    //     a.add(h1);
    //     a.add(h2);
    //     a.add(h3);
    //     return a;
    // }

    // @GetMapping("/getbook/{id}")
    // public HashMap<Object,Object> getBookName(@PathVariable String id) {
    //     for (HashMap<Object, Object> hm : a) {
    //         if (hm.containsValue(id)) {
    //             return hm;
    //         }
    //     }
    //     return null;
    // }
}
