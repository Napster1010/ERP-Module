package com.erp.beans;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Post")
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "message")
    private String message;

    @OneToOne
    @JoinColumn(name = "snuId")
    private Student student;

    @OneToOne
    @JoinColumn(name = "id")
    private DiscussionForum discussionForum;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date timestamp;

    public void setId(int id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setDiscussionForum(DiscussionForum discussionForum) {
        this.discussionForum = discussionForum;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Student getStudent() {
        return student;
    }

    public DiscussionForum getDiscussionForum() {
        return discussionForum;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Post(int id, String message, Student student, DiscussionForum discussionForum, Date timestamp) {
        this.id = id;
        this.message = message;
        this.student = student;
        this.discussionForum = discussionForum;
        this.timestamp = timestamp;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", student=" + student +
                ", discussionForum=" + discussionForum +
                ", timestamp=" + timestamp +
                '}';
    }
}
