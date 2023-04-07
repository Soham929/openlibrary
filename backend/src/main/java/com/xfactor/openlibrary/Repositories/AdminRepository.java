package com.xfactor.openlibrary.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.Domain.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long>{
    
    public List<Admin> findByName(String  name);
    
    List<Admin> findByUsernameAndPassword(String username,String password);
}
