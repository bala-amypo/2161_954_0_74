package com.example.demo.controller;
import.java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Studententity;
import com.example.demo.services.Studentservice;
@RestController
@RequestMapping("/student")
public class Studentctl{
    @Autowired
    Studentservice ser;
    @PostMapping("/add")
    public Studententity addStudent(@RequestBody Studententity st){
        return ser.saveData(st);
    }
    @getMapping("/{id}")
    public studententity getStudent(@PathVariable int id){
        return ser,getById(id);
    }
    @getMapping("/all")
    public Collection<Studententity>getAllStudents(){
        return ser.getAll();
    }
    @Putmapping("/update/{id}")
    public Studententity updateStudent(@PathVariable int id,@RequestBody Studententity st){
        Studententity updated=ser.updateStudent(id,st);
        if(updated!=null){
            return updated;
        }else{
            throw new RuntimeException("Student with ID"+id+"not found");
        }
    }
}