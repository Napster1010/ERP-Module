package com.erp.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "StudentGrade")
@Table(name = "student_grade")
public class StudentGrade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_course_enrollment_id", referencedColumnName = "id")
    private StudentCourseEnrollment studentCourseEnrollment;

    @Column(name = "grade")
    private String grade;

    public Long getId() {
        return id;
    }

    public StudentCourseEnrollment getStudentCourseEnrollment() {
        return studentCourseEnrollment;
    }

    public String getGrade() {
        return grade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentCourseEnrollment(StudentCourseEnrollment studentCourseEnrollment) {
        this.studentCourseEnrollment = studentCourseEnrollment;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public StudentGrade(Long id, StudentCourseEnrollment studentCourseEnrollment, String grade) {
        this.id = id;
        this.studentCourseEnrollment = studentCourseEnrollment;
        this.grade = grade;
    }

    public StudentGrade() {
    }

    @Override
    public String toString() {
        return "StudentGrade{" +
                "id=" + id +
                ", studentCourseEnrollment=" + studentCourseEnrollment +
                ", grade='" + grade + '\'' +
                '}';
    }
}
