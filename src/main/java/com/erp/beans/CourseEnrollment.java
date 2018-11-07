package com.erp.beans;

import javax.persistence.*;

@Entity(name = "CourseEnrollment")
@Table(name = "course_enrollment")
public class CourseEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "course")
    private Course course;

    @Column(name = "season")
    private String season;

    @Column(name = "year")
    private int year;

    @Column(name = "location")
    private String location;

    @Column(name = "faculty")
    private Faculty faculty;

    public int getId() {
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

    public void setId(int id) {
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

    public CourseEnrollment(int id, Course course, String season, int year, String location, Faculty faculty) {
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
