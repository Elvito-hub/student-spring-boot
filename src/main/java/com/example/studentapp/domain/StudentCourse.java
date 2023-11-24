package com.example.studentapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "studentCourse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourse {
  @Id
  @Column(name = "student_course_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long studentCourseId;

    @Column(name = "credits")
    private int credits;
    @Column(name = "results")
    private float results;
    @ManyToOne
    @JoinColumn(name = "registration_id")
    private StudentRegistration registration;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
