package com.lern.demo.controller;

import com.lern.demo.model.Student;
import com.lern.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping
    public List<Student> students(){
        return studentService.students();
    }

    @GetMapping("/{id}")
    public Student student(@PathVariable("id") long id){
        return studentService.student(id);
    }

    @DeleteMapping("/{id}")
    public void deleted(@PathVariable("id") long id){
        studentService.deleted(id);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable("id") long id , @RequestBody Student student){
        return studentService.update(id, student);
    }

}

