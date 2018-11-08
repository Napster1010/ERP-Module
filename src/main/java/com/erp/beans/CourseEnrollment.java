package com.erp.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "CourseEnrollment")
@Table(name = "course_enrollment")
public class CourseEnrollment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "course_code", referencedColumnName = "course_code")
    private Course course;

    @Column(name = "season")
    private String season;

    @Column(name = "year")
    private int year;

    @Column(name = "location")
    private String location;

    @OneToOne
    @JoinColumn(name = "faculty_snu_id", referencedColumnName = "snu_id")
    private Faculty faculty;

    public Long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public String getSeason() {
        return season;
    }

    public int getYear() {
        return year;
    }

    public String getLocation() {
        return location;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public CourseEnrollment(Long id, Course course, String season, int year, String location, Faculty faculty) {
        this.id = id;
        this.course = course;
        this.season = season;
        this.year = year;
        this.location = location;
        this.faculty = faculty;
    }

    public CourseEnrollment() {
    }

    @Override
    public String toString() {
        return "CourseEnrollment{" +
                "id=" + id +
                ", course=" + course +
                ", season='" + season + '\'' +
                ", year=" + year +
                ", location='" + location + '\'' +
                ", faculty=" + faculty +
                '}';
    }
}
