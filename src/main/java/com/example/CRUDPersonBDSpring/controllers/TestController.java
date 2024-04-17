package com.example.CRUDPersonBDSpring.controllers;

import com.example.CRUDPersonBDSpring.models.Person;
import com.example.CRUDPersonBDSpring.models.Person;
import com.example.CRUDPersonBDSpring.Services.ProductServices;
import org.springframework.web.bind.annotation.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

//    @Autowired
//    ProductServices productServices;

    ProductServices productServices;


    public TestController(ProductServices productServices) {
        this.productServices = productServices;
    }



    @PostMapping("/insert")
    public void insertDa(@RequestBody Person person) {productServices.insert(person);
    }

    @PutMapping("/update")
    public void update(@RequestBody Person person) {productServices.update(person);
    }

    @GetMapping("/read")
    public List<Person> read() {
        List<Person> persons =productServices.read();
        return persons;
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody Person person) {productServices.delete(person);
    }
}