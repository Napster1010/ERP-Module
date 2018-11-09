package com.erp.controllers;

import com.erp.beans.DiscussionForum;
import com.erp.beans.Student;
import com.erp.beans.StudentDiscussionForumMapping;
import com.erp.services.DiscussionForumService;
import com.erp.services.StudentDiscussionForumMappingService;
import com.erp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student-discussion-forum")
public class StudentDiscussionForumMappingController {
    @Autowired
    private StudentDiscussionForumMappingService studentDiscussionForumMappingService;

    @Autowired
    private DiscussionForumService discussionForumService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.POST)
    public StudentDiscussionForumMapping addStudentDiscussionForumMapping(String snuId, Long discussionForumId){
        Student student = studentService.getStudentBySnuId(snuId);
        DiscussionForum discussionForum = discussionForumService.getDiscussionForumById(discussionForumId);
        StudentDiscussionForumMapping studentDiscussionForumMapping = new StudentDiscussionForumMapping(null, student, discussionForum);
        StudentDiscussionForumMapping insertedStudentDiscussionForumMapping = studentDiscussionForumMappingService.addStudentDiscussionForumMapping(studentDiscussionForumMapping);
        return insertedStudentDiscussionForumMapping;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public boolean deleteStudentDiscussionForumMapping(@RequestBody StudentDiscussionForumMapping studentDiscussionForumMapping){
        boolean isDeleted = studentDiscussionForumMappingService.deleteStudentDiscussionForumMapping(studentDiscussionForumMapping);

        if(isDeleted)
            return true;
        else
            return false;
    }

    @RequestMapping(method = RequestMethod.GET, params = "snuId")
    public List<StudentDiscussionForumMapping> getStudentDiscussionForumMappingsBySnuId(String snuId){
        List<StudentDiscussionForumMapping> studentDiscussionForumMappings = studentDiscussionForumMappingService.getStudentDiscussionForumMappingsBySnuId(snuId);
        return studentDiscussionForumMappings;
    }

    @RequestMapping(method = RequestMethod.GET, params = "id")
    public StudentDiscussionForumMapping getStudentDiscussionForumMappingById(Long id){
        StudentDiscussionForumMapping studentDiscussionForumMapping = studentDiscussionForumMappingService.getStudentDiscussionForumMappingById(id);
        return studentDiscussionForumMapping;
    }
}
