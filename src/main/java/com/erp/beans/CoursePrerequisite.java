package com.erp.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "CoursePrerequisite")
@Table(name = "course_prerequisite")
public class CoursePrerequisite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "course_code", referencedColumnName = "course_code")
    private Course course;

    @OneToOne
    @JoinColumn(name = "prerequisite_course_code", referencedColumnName = "course_code")
    private Course prerequisiteCourse;

    public Long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setPrerequisiteCourse(Course prerequisiteCourse) {
        this.prerequisiteCourse = prerequisiteCourse;
    }

    public Course getPrerequisiteCourse() {
        return prerequisiteCourse;
    }

    public CoursePrerequisite(Long id, Course course, Course prerequisiteCourse) {
        this.id = id;
        this.course = course;
        this.prerequisiteCourse = prerequisiteCourse;
    }

    public CoursePrerequisite() {
    }

    @Override
    public String toString() {
        return "CoursePrerequisite{" +
                "id=" + id +
                ", course=" + course +
                ", prerequisiteCourse=" + prerequisiteCourse +
                '}';
    }
}
