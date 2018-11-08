package com.erp.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "StudentDiscussionForumMapping")
@Table(name = "student_discussion_forum_mapping")
public class StudentDiscussionForumMapping implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_snu_id", referencedColumnName = "snu_id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "discussion_forum_id", referencedColumnName = "id")
    private DiscussionForum discussionForum;

    public StudentDiscussionForumMapping(Long id, Student student, DiscussionForum discussionForum) {
        this.id = id;
        this.student = student;
        this.discussionForum = discussionForum;
    }

    public StudentDiscussionForumMapping() {
    }

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public DiscussionForum getDiscussionForum() {
        return discussionForum;
    }

    public void setId(Long id) {
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
