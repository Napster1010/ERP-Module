package com.erp.beans;

import javax.persistence.*;

@Entity(name = "Department")
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "department_id")
    private String departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @OneToOne
    @JoinColumn(name = "schoolId")
    private School school;

    @Column(name = "hod")
    private String hod;

    public int getId() {
        return id;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public School getSchool() {
        return school;
    }

    public String getHod() {
        return hod;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void setHod(String hod) {
        this.hod = hod;
    }

    public Department(int id, String departmentId, String departmentName, School school, String hod) {
        this.id = id;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.school = school;
        this.hod = hod;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", school=" + school +
                ", hod='" + hod + '\'' +
                '}';
    }
}
