package com.erp.beans;

import javax.persistence.*;

@Entity(name = "School")
@Table(name = "school")
public class School {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "school_id")
    private String schoolId;

    @Column(name = "school_name")
    private String schoolName;

    public void setId(int id) {
        this.id = id;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getId() {
        return id;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public School(int id, String schoolId, String schoolName) {
        this.id = id;
        this.schoolId = schoolId;
        this.schoolName = schoolName;
    }

    public School() {
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolId='" + schoolId + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
