package com.erp.beans;

import javax.persistence.*;

@Entity(name = "CoursePrerequisite")
@Table(name = "course_prerequisite")
public class CoursePrerequisite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "courseCode")
    private Course course;

    @OneToOne
    @JoinColumn(name = "courseCode")
    private Course prerequisiteCourse;
}
