package com.erp.beans;

import javax.persistence.*;

@Entity(name = "StudentGrade")
@Table(name = "student_grade")
public class StudentGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "id")
    private StudentCourseEnrollment studentCourseEnrollment;

    @Column(name = "grade")
    private String grade;

    public int getId() {
        return id;
    }

    public StudentCourseEnrollment getStudentCourseEnrollment() {
        return studentCourseEnrollment;
    }

    public String getGrade() {
        return grade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentCourseEnrollment(StudentCourseEnrollment studentCourseEnrollment) {
        this.studentCourseEnrollment = studentCourseEnrollment;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public StudentGrade(int id, StudentCourseEnrollment studentCourseEnrollment, String grade) {
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
