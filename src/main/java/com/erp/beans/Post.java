package com.erp.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Post")
@Table(name = "post")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "message")
    private String message;

    @OneToOne
    @JoinColumn(name = "student_discussion_forum_mapping_id", referencedColumnName = "id")
    private StudentDiscussionForumMapping studentDiscussionForumMapping;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date timestamp;

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public StudentDiscussionForumMapping getStudent() {
        return studentDiscussionForumMapping;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStudent(StudentDiscussionForumMapping student) {
        this.studentDiscussionForumMapping = student;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Post(Long id, String message, StudentDiscussionForumMapping studentDiscussionForumMapping, Date timestamp) {
        this.id = id;
        this.message = message;
        this.studentDiscussionForumMapping = studentDiscussionForumMapping;
        this.timestamp = timestamp;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", student=" + studentDiscussionForumMapping +
                ", timestamp=" + timestamp +
                '}';
    }
}
