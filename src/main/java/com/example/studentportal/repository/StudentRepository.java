package com.example.studentportal.repository;

import com.example.studentportal.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  StudentRepository  extends JpaRepository<Student,Integer> {

    @Query(value = "SELECT * FROM student WHERE name=:name",nativeQuery = true)
    List<Student> findNamesEqualsToAlekhya(@Param("name") String name);
}
