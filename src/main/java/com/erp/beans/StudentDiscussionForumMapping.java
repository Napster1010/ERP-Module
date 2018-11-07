package com.erp.beans;

import javax.persistence.*;

@Entity(name = "StudentDiscussionForumMapping")
@Table(name = "student_discussion_forum_mapping")
public class StudentDiscussionForumMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "snuId")
    private Student student;

    @OneToOne
    @JoinColumn(name = "id")
    private DiscussionForum discussionForum;

    public StudentDiscussionForumMapping(int id, Student student, DiscussionForum discussionForum) {
        this.id = id;
        this.student = student;
        this.discussionForum = discussionForum;
    }

    public StudentDiscussionForumMapping() {
    }

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public DiscussionForum getDiscussionForum() {
        return discussionForum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setDiscussionForum(DiscussionForum discussionForum) {
        this.discussionForum = discussionForum;
    }

    @Override
    public String toString() {
        return "StudentDiscussionForumMapping{" +
                "id=" + id +
                ", student=" + student +
                ", discussionForum=" + discussionForum +
                '}';
    }
}
