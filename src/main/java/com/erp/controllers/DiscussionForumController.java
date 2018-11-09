package com.erp.controllers;

import com.erp.beans.CourseEnrollment;
import com.erp.beans.DiscussionForum;
import com.erp.beans.Post;
import com.erp.beans.StudentDiscussionForumMapping;
import com.erp.services.CourseEnrollmentService;
import com.erp.services.DiscussionForumService;
import com.erp.services.PostService;
import com.erp.services.StudentDiscussionForumMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/discussion-forum")
public class DiscussionForumController {
    @Autowired
    private DiscussionForumService discussionForumService;

    @Autowired
    private CourseEnrollmentService courseEnrollmentService;

    @Autowired
    private StudentDiscussionForumMappingService studentDiscussionForumMappingService;

    @Autowired
    private PostService postService;

    ///////////////////////////Discussion Forum Methods//////////////////////////////////////////

    @RequestMapping(method = RequestMethod.POST)
    public DiscussionForum addDiscussionForum(Long courseEnrollmentId){
        CourseEnrollment courseEnrollment = courseEnrollmentService.getCourseEnrollmentById(courseEnrollmentId);
        DiscussionForum discussionForum = new DiscussionForum(null, courseEnrollment);
        DiscussionForum insertedDiscussionForum = discussionForumService.addDiscussionForum(discussionForum);
        return insertedDiscussionForum;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public boolean deleteDiscussionForum(@RequestBody DiscussionForum discussionForum){
        boolean isDeleted = discussionForumService.deleteDiscussionForum(discussionForum);

        if(isDeleted)
            return true;
        else
            return false;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<DiscussionForum> getAllDiscussionForums(){
        List<DiscussionForum> discussionForums = discussionForumService.getAllDiscussionForums();
        return discussionForums;
    }

    @RequestMapping(method = RequestMethod.GET, params = "id")
    public DiscussionForum getDiscussionForumById(Long id){
        DiscussionForum discussionForum = discussionForumService.getDiscussionForumById(id);
        return discussionForum;
    }

    ///////////////////////////Discussion forum post Methods//////////////////////////////////////////

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Post addPost(String message, Long studentDiscussionForumMappingId){
        StudentDiscussionForumMapping studentDiscussionForumMapping = studentDiscussionForumMappingService.getStudentDiscussionForumMappingById(studentDiscussionForumMappingId);
        Post post = new Post(null, message, studentDiscussionForumMapping, new Date());
        Post insertedPost = postService.addPost(post);
        return insertedPost;
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET, params = "studentDiscussionForumMappingId")
    public List<Post> getPostsByStudentDiscussionForumMappingId(Long studentDiscussionForumMappingId){
        List<Post> posts = postService.getPostsByStudentDiscussionForumMappingId(studentDiscussionForumMappingId);
        return posts;
    }

}
