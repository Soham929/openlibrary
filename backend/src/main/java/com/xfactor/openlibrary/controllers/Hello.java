package com.xfactor.openlibrary.controllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //needed to mark a particular class as a controller
@RequestMapping("HelloController")
public class Hello {

    @GetMapping("/hello")   //needed to mark a function as a getmapping
    public String hello(@RequestParam String name,int number,float floatingnum) {
        return "Hello " + name + " !! " + number+ " "+floatingnum;
    }

    @GetMapping("/hi/{name}/{number}")
    public String sayHi(@PathVariable String name,@PathVariable int number)
    {
        return "Hi "+ name + " !! " + number;
    }

    @GetMapping("/hi/{name}")   // all path variables should come first and then the request parameters with the ?
    public String dualmode(@PathVariable String name,@RequestParam int number)
    {
        return "Hi "+ name + " !! "+ number;
    }

    @GetMapping("/soham/{name}/{age}")
    public HashMap<String,String> random(@PathVariable String name,@PathVariable int age)
    {
        HashMap<String,String>hm=new HashMap<>();
        hm.put("name", name);
        hm.put("age", String.valueOf(age));
        return hm;
    }
}
