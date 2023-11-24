package com.example.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentapp.domain.StudentCourse;
import com.example.studentapp.repository.StudentCourseRepository;
@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    @Autowired private StudentCourseRepository repo;
    @Override
    public StudentCourse registerStudentCourse(StudentCourse studentCourse) {
        return repo.save(studentCourse);
    }

    @Override
    public StudentCourse updateDefinition(StudentCourse studentCourse) {
        return repo.save(studentCourse);
    }

    @Override
    public StudentCourse deleteDefinition(StudentCourse studentCourse) {
        repo.delete(studentCourse);
        return studentCourse;
    }

    @Override
    public List<StudentCourse> studentCourses() {
        return repo.findAll();
    }

    @Override
    public List<StudentCourse> findCoursePerStudent(StudentCourse theStudentCourse) {
        return repo.findByCondition(theStudentCourse.getRegistration());
    }
}