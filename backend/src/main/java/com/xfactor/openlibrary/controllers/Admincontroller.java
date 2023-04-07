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

import com.xfactor.openlibrary.Domain.Admin;
import com.xfactor.openlibrary.Repositories.AdminRepository;

@RestController
@RequestMapping("admin")
public class Admincontroller {
    
    private AdminRepository adminRepository;

    public Admincontroller(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @PostMapping("/saveAdmin")
    public Admin saveAdmin(@RequestBody Admin am)
    {
        adminRepository.save(am);
        return am;
    }

    @GetMapping("/getAdmin")
    public List<Admin> getAllAdmins()
    {
        return adminRepository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public Admin findById(@PathVariable Long id)
    {
        if(id != null)
        {
            Optional<Admin> optionalOfBook = adminRepository.findById(id);
            if(optionalOfBook.isPresent())
            return optionalOfBook.get();
        }
        return null;
    }

    @DeleteMapping("delete/{id}")
    public void deleteBook(@PathVariable Long id)
    {
        adminRepository.deleteById(id);
    }

    @GetMapping("/findbyname/{name}")
    public List<Admin> findByName(@PathVariable String  name)
    {
            List<Admin> listbooks = adminRepository.findByName(name);
            return listbooks;
    }

    @GetMapping("/findbyusernameandpassword/{username}/{password}")
    List<Admin> findByUsernameAndPassword(@PathVariable String username,@PathVariable String password)
    {
        List<Admin> lb1 = adminRepository.findByUsernameAndPassword(username, password);
        return lb1;
    }
}
