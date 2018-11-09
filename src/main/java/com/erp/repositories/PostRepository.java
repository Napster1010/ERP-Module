package com.erp.repositories;

import com.erp.beans.Post;
import com.erp.beans.StudentDiscussionForumMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    public List<Post> findByStudentDiscussionForumMapping(StudentDiscussionForumMapping studentDiscussionForumMapping);
}
