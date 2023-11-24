package com.example.studentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.studentapp.domain.StudentCourse;
import com.example.studentapp.domain.StudentRegistration;

public interface StudentCourseRepository extends JpaRepository<StudentCourse,Long> {
    @Query("select sc from StudentCourse sc where sc.registration=:registration")
    List<StudentCourse> findByCondition(@Param("registration") StudentRegistration registration);
    
}
