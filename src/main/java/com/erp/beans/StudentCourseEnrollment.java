package com.erp.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "StudentCourseEnrollmentService")
@Table(name = "student_course_enrollment")
public class StudentCourseEnrollment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_snu_id", referencedColumnName = "snu_id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "course_enrollment_id", referencedColumnName = "id")
    private CourseEnrollment courseEnrollment;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date timestamp;

    public Long getId() {
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

    public void setId(Long id) {
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

    public StudentCourseEnrollment(Long id, Student student, CourseEnrollment courseEnrollment, Date timestamp) {
        this.id = id;
        this.student = student;
        this.courseEnrollment = courseEnrollment;
        this.timestamp = timestamp;
    }

    public StudentCourseEnrollment() {
    }

    @Override
    public String toString() {
        return "StudentCourseEnrollmentService{" +
                "id=" + id +
                ", student=" + student +
                ", courseEnrollment=" + courseEnrollment +
                ", timestamp=" + timestamp +
                '}';
    }
}
