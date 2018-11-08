package com.erp.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Student")
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "snu_id")
    private String snuId;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "address")
    private String address;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "guardian_name")
    private String guardianName;

    @Column(name = "year_of_joining")
    private int yearOfJoining;

    @Column(name = "course")
    private String course;

    @Column(name = "major")
    private String major;

    @Column(name = "net_id")
    private String netId;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Department department;

    public Long getId() {
        return id;
    }

    public String getSnuId() {
        return snuId;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public String getCourse() {
        return course;
    }

    public String getMajor() {
        return major;
    }

    public String getNetId() {
        return netId;
    }

    public String getPassword() {
        return password;
    }

    public Department getDepartment() {
        return department;
    }

    public Student(Long id, String snuId, String name, String mobile, String address, Date dateOfBirth, String guardianName, int yearOfJoining, String course, String major, String netId, String password, Department department) {
        this.id = id;
        this.snuId = snuId;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.guardianName = guardianName;
        this.yearOfJoining = yearOfJoining;
        this.course = course;
        this.major = major;
        this.netId = netId;
        this.password = password;
        this.department = department;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", snuId='" + snuId + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", guardianName='" + guardianName + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", course='" + course + '\'' +
                ", major='" + major + '\'' +
                ", netId='" + netId + '\'' +
                ", password='" + password + '\'' +
                ", department=" + department +
                '}';
    }
}
