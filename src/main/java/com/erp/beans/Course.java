package com.erp.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Course")
@Table(name = "course")
public class Course implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_name")
    private String courseName;

    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Department department;

    @Column(name = "credits")
    private int credits;

    @Column(name = "duration")
    private int duration;

    public Long getId() {
        return id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public Department getDepartment() {
        return department;
    }

    public int getCredits() {
        return credits;
    }

    public int getDuration() {
        return duration;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Course(Long id, String courseCode, String courseName, Department department, int credits, int duration) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.department = department;
        this.credits = credits;
        this.duration = duration;
    }

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", department=" + department +
                ", credits=" + credits +
                ", duration=" + duration +
                '}';
    }
}
