package com.erp.services;

import com.erp.beans.Post;
import com.erp.beans.StudentDiscussionForumMapping;
import com.erp.repositories.PostRepository;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private StudentDiscussionForumMappingService discussionForumMappingService;

    public Post addPost(Post post){
        Post insertedPost = postRepository.save(post);
        return insertedPost;
    }

    public List<Post> getPostsByStudentDiscussionForumMappingId(Long id){
        StudentDiscussionForumMapping discussionForumMapping = discussionForumMappingService.getStudentDiscussionForumMappingById(id);
        List<Post> posts = postRepository.findByStudentDiscussionForumMapping(discussionForumMapping);
        return posts;
    }
}
