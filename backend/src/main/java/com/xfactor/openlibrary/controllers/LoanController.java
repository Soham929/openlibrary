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

import com.xfactor.openlibrary.Domain.Loan;
import com.xfactor.openlibrary.Repositories.LoanRepository;

@RestController
@RequestMapping("loan")
public class LoanController {

    private LoanRepository loanRepository;

    public LoanController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @PostMapping("/saveLoan")
    public Loan saveLoan(@RequestBody Loan lo)
    {
        loanRepository.save(lo);
        return lo;
    }

    @GetMapping("/getLoan")
    public List<Loan> getAllLoans()
    {
        return loanRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public Loan findById(@PathVariable Long id)
    {
        if(id != null)
        {
            Optional<Loan> optionalOfBook = loanRepository.findById(id);
            if(optionalOfBook.isPresent())
            return optionalOfBook.get();
        }
        return null;
    }

    @DeleteMapping("delete/{id}")
    public void deleteLoan(@PathVariable Long id)
    {
        loanRepository.deleteById(id);
    }

    @GetMapping("/findbystudentid/{studentid}")
    public List<Loan> findBystudentid(@PathVariable Long studentid)
    {
            List<Loan> listbooks = loanRepository.findBystudentid(studentid);
            return listbooks;
    }

}
