package com.erp.beans;

import javax.persistence.*;
import java.util.Date;

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "review")
    private String review;

    @Column(name = "rating")
    private int rating;

    @OneToOne
    @JoinColumn(name = "id")
    private StudentCourseEnrollment studentCourseEnrollment;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date timestamp;

    public int getId() {
        return id;
    }

    public String getReview() {
        return review;
    }

    public int getRating() {
        return rating;
    }

    public StudentCourseEnrollment getStudentCourseEnrollment() {
        return studentCourseEnrollment;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setStudentCourseEnrollment(StudentCourseEnrollment studentCourseEnrollment) {
        this.studentCourseEnrollment = studentCourseEnrollment;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Review(int id, String review, int rating, StudentCourseEnrollment studentCourseEnrollment, Date timestamp) {
        this.id = id;
        this.review = review;
        this.rating = rating;
        this.studentCourseEnrollment = studentCourseEnrollment;
        this.timestamp = timestamp;
    }

    public Review() {
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", review='" + review + '\'' +
                ", rating=" + rating +
                ", studentCourseEnrollment=" + studentCourseEnrollment +
                ", timestamp=" + timestamp +
                '}';
    }
}
