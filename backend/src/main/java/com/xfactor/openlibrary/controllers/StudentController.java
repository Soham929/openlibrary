package com.xfactor.openlibrary.controllers;


// import java.util.ArrayList;
// import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.xfactor.openlibrary.Domain.Student;
import com.xfactor.openlibrary.Repositories.StudentRepository;

@RestController
@RequestMapping("students")
public class StudentController {

    private StudentRepository studentRepository;
    
    // List<Student> lStudent = new ArrayList<>();

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student stu)
    {
        // lStudent.add(stu);
        studentRepository.save(stu);
        return stu;
    }

    @GetMapping("/getStudent")
    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudentRecord(@PathVariable Long id)
    {
        studentRepository.deleteById(id);
    }

    @GetMapping("/findbyname/{name}")
    public List<Student> findByName(@PathVariable String  name)
    {
            List<Student> listbooks = studentRepository.findByName(name);
            return listbooks;
    }

    @GetMapping("/findbynameandrollnumber/{name}/{rollnumber}")
    public List<Student> findByNameAndRollnumber(@PathVariable String name,@PathVariable String rollnumber)
    {
        List<Student> ls = studentRepository.findByNameAndRollnumber(name, rollnumber);
        return ls;
    }

    @GetMapping("findTotal")
    public Long findTotal() {
        return studentRepository.count();
    }

   
}