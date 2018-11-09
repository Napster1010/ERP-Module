package com.erp.beans;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "EnrollmentStatus")
@Table(name = "enrollment_status")
public class EnrollmentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "year")
    private int year;

    @Column(name = "status")
    private String status;

    @Column(name = "enrollment_start_time")
    private Date enrollmentStartTime;

    @Column(name = "enrollment_end_time")
    private Date enrollmentEndTime;

    public Long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getStatus() {
        return status;
    }

    public Date getEnrollmentStartTime() {
        return enrollmentStartTime;
    }

    public Date getEnrollmentEndTime() {
        return enrollmentEndTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEnrollmentStartTime(Date enrollmentStartTime) {
        this.enrollmentStartTime = enrollmentStartTime;
    }

    public void setEnrollmentEndTime(Date enrollmentEndTime) {
        this.enrollmentEndTime = enrollmentEndTime;
    }

    public EnrollmentStatus(Long id, int year, String status, Date enrollmentStartTime, Date enrollmentEndTime) {
        this.id = id;
        this.year = year;
        this.status = status;
        this.enrollmentStartTime = enrollmentStartTime;
        this.enrollmentEndTime = enrollmentEndTime;
    }

    public EnrollmentStatus() {
    }

    @Override
    public String toString() {
        return "EnrollmentStatus{" +
                "id=" + id +
                ", year=" + year +
                ", status='" + status + '\'' +
                ", enrollmentStartTime=" + enrollmentStartTime +
                ", enrollmentEndTime=" + enrollmentEndTime +
                '}';
    }
}
