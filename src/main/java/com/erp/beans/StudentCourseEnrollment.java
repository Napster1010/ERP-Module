package com.erp.beans;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "StudentCourseEnrollment")
@Table(name = "student_course_enrollment")
public class StudentCourseEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "snuId")
    private Student student;

    @OneToOne
    @JoinColumn(name = "id")
    private CourseEnrollment courseEnrollment;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date timestamp;

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public CourseEnrollment getCourseEnrollment() {
        return courseEnrollment;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourseEnrollment(CourseEnrollment courseEnrollment) {
        this.courseEnrollment = courseEnrollment;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public StudentCourseEnrollment(int id, Student student, CourseEnrollment courseEnrollment, Date timestamp) {
        this.id = id;
        this.student = student;
        this.courseEnrollment = courseEnrollment;
        this.timestamp = timestamp;
    }

    public StudentCourseEnrollment() {
    }

    @Override
    public String toString() {
        return "StudentCourseEnrollment{" +
                "id=" + id +
                ", student=" + student +
                ", courseEnrollment=" + courseEnrollment +
                ", timestamp=" + timestamp +
                '}';
    }
}
