package com.xfactor.openlibrary.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.Domain.Books;

public interface BookRepository extends JpaRepository<Books,Long>{
    public List<Books> findByIsbn(String isbn);

    List<Books> findByNameAndIsbn(String name,String isbn);
}
