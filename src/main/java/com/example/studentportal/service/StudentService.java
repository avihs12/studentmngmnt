package com.example.studentportal.service;

import com.example.studentportal.entity.Student;
import com.example.studentportal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository sRepo;

    public Student createStudent(Student student){

        return sRepo.save(student);
    }


    //getting all students
    public List<Student> getAllStudents(){
        return  sRepo.findAll();
    }


    public Student getStudentById(Integer id){
        return sRepo.findById(id).orElse(null);
    }

    public Student editStudentById(Student student,Integer id){
        Student prevRecord = sRepo.findById(id).orElse(null);
        if(prevRecord != null){
            prevRecord.setId(id);
            prevRecord.setName(student.getName());
            prevRecord.setMarks(student.getMarks());
            prevRecord.setResult(student.getResult());
            return sRepo.save(prevRecord);
        }
        return null;
    }

    public List<Student> getNamesWithA(String name){
        return sRepo.findNamesEqualsToAlekhya(name);
    }


    public void deleteStudentById(Integer id){
        sRepo.deleteById(id);
    }

}
