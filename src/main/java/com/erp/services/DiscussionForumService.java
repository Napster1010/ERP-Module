package com.erp.services;

import com.erp.beans.CourseEnrollment;
import com.erp.beans.DiscussionForum;
import com.erp.repositories.DiscussionForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionForumService {
    @Autowired
    private DiscussionForumRepository discussionForumRepository;

    @Autowired
    private CourseEnrollmentService courseEnrollmentService;

    public DiscussionForum addDiscussionForum(DiscussionForum discussionForum){
        DiscussionForum insertedDiscussionForum = discussionForumRepository.save(discussionForum);
        return insertedDiscussionForum;
    }

    public boolean deleteDiscussionForum(DiscussionForum discussionForum){
        try {
            discussionForumRepository.delete(discussionForum);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<DiscussionForum> getAllDiscussionForums(){
        List<DiscussionForum> discussionForumList = discussionForumRepository.findAll();
        return discussionForumList;
    }

    public DiscussionForum getDiscussionForumById(Long id){
        DiscussionForum discussionForum = discussionForumRepository.findById(id).get();
        return discussionForum;
    }
}
