package com.example.studentapp.controller;

import com.example.studentapp.domain.Course;
import com.example.studentapp.domain.Student;
import com.example.studentapp.domain.StudentCourse;
import com.example.studentapp.domain.StudentRegistration;
import com.example.studentapp.service.SemesterService;
import com.example.studentapp.service.StudentCourseService;
import com.example.studentapp.service.StudentCourseServiceImpl;
import com.example.studentapp.service.StudentRegServiceImpl;
import com.example.studentapp.service.StudentService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/studentcourses/",consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class StudentCourseController {
    @Autowired private StudentCourseServiceImpl studentCourseService;
    @Autowired private StudentRegServiceImpl registrationService;
    @GetMapping
    public List<StudentCourse> allStudentCourses(){
        return studentCourseService.studentCourses();
    }

    @PostMapping("/new")
    public StudentCourse register(@RequestBody StudentCourse theStudentCourse){
        return studentCourseService.registerStudentCourse(theStudentCourse);
    }

    @PostMapping("/coursesperstudent")
    public List<Course> allCoursePerStudent(StudentCourse theStudentCourse){
        StudentRegistration registration = registrationService.searchStudentRegistration(theStudentCourse.getRegistration());
        List<Course> courses = new ArrayList<>();
        if(registration!=null){
            List<StudentCourse> studentCourses = studentCourseService.findCoursePerStudent(theStudentCourse);
            for (StudentCourse studentCourse : studentCourses){
                courses.add(studentCourse.getCourse());
            }
            return courses;
        }
            return null;
    }
    
}
