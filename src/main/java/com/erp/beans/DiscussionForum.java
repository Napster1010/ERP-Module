package com.erp.beans;

import javax.persistence.*;

@Entity(name = "DiscussionForum")
@Table(name = "discussion_forum")
public class DiscussionForum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "id")
    private CourseEnrollment courseEnrollment;

    public int getId() {
        return id;
    }

    public CourseEnrollment getCourseEnrollment() {
        return courseEnrollment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseEnrollment(CourseEnrollment courseEnrollment) {
        this.courseEnrollment = courseEnrollment;
    }

    public DiscussionForum(int id, CourseEnrollment courseEnrollment) {
        this.id = id;
        this.courseEnrollment = courseEnrollment;
    }

    public DiscussionForum() {
    }

    @Override
    public String toString() {
        return "DiscussionForum{" +
                "id=" + id +
                ", courseEnrollment=" + courseEnrollment +
                '}';
    }
}
