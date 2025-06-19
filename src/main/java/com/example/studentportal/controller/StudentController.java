package com.example.studentportal.controller;

import com.example.studentportal.entity.Student;
import com.example.studentportal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService sService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        return sService.createStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return sService.getStudentById(id);
    }


    @GetMapping
    public List<Student> getAllStudents(){
        return  sService.getAllStudents();
    }

    @PutMapping("/{id}")
    public Student editStudentById(@RequestBody Student student,@PathVariable Integer id){
        return sService.editStudentById(student,id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Integer id){
        sService.deleteStudentById(id);
    }

    @GetMapping("/name/{name}")
    public  List<Student> getAllAlek(@PathVariable String name){
        return sService.getNamesWithA(name);
    }
}
