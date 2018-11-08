package com.erp.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "DiscussionForum")
@Table(name = "discussion_forum")
public class DiscussionForum implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "course_enrollment_id", referencedColumnName = "id")
    private CourseEnrollment courseEnrollment;

    public Long getId() {
        return id;
    }

    public CourseEnrollment getCourseEnrollment() {
        return courseEnrollment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourseEnrollment(CourseEnrollment courseEnrollment) {
        this.courseEnrollment = courseEnrollment;
    }

    public DiscussionForum(Long id, CourseEnrollment courseEnrollment) {
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
