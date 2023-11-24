package com.example.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.studentapp.domain.Student;
import com.example.studentapp.domain.StudentCourse;
import com.example.studentapp.repository.StudentCourseRepository;
import com.example.studentapp.repository.StudentRepository;

public interface StudentCourseService {
    StudentCourse registerStudentCourse(StudentCourse studentCourse);
    StudentCourse updateDefinition(StudentCourse studentCourse);
    StudentCourse deleteDefinition(StudentCourse studentCourse);
    List<StudentCourse> studentCourses();

    List<StudentCourse> findCoursePerStudent(StudentCourse theStudentCourse);
}
