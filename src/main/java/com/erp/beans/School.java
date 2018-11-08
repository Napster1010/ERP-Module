package com.erp.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "School")
@Table(name = "school")
public class School implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "school_id")
    private String schoolId;

    @Column(name = "school_name")
    private String schoolName;

    public void setId(Long id) {
        this.id = id;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Long getId() {
        return id;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public School(Long id, String schoolId, String schoolName) {
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
