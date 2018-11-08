package com.erp.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Admin")
@Table(name = "admin")
public class Admin implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "net_id")
    private String netId;

    @Column(name = "password")
    private String password;

    public Admin(Long id, String snuId, String name, String mobile, String address, Date dateOfBirth, String netId, String password) {
        this.id = id;
        this.snuId = snuId;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.netId = netId;
        this.password = password;
    }

    public Admin() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSnuId(String snuId) {
        this.snuId = snuId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNetId(String netId) {
        this.netId = netId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public String getNetId() {
        return netId;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", snuId='" + snuId + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", netId='" + netId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
