package com.erp.services;

import com.erp.beans.Student;
import com.erp.beans.StudentDiscussionForumMapping;
import com.erp.repositories.StudentDiscussionForumMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDiscussionForumMappingService {
    @Autowired
    private StudentDiscussionForumMappingRepository studentDiscussionForumMappingRepository;

    @Autowired
    private StudentService studentService;

    public StudentDiscussionForumMapping addStudentDiscussionForumMapping(StudentDiscussionForumMapping studentDiscussionForumMapping){
        StudentDiscussionForumMapping insertedStudentDiscussionForumMapping = studentDiscussionForumMappingRepository.save(studentDiscussionForumMapping);
        return insertedStudentDiscussionForumMapping;
    }

    public boolean deleteStudentDiscussionForumMapping(StudentDiscussionForumMapping studentDiscussionForumMapping){
        try {
            studentDiscussionForumMappingRepository.delete(studentDiscussionForumMapping);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<StudentDiscussionForumMapping> getStudentDiscussionForumMappingsBySnuId(String snuId){
        Student student = studentService.getStudentBySnuId(snuId);
        List<StudentDiscussionForumMapping> studentDiscussionForumMappings = studentDiscussionForumMappingRepository.findByStudent(student);
        return  studentDiscussionForumMappings;
    }

    public StudentDiscussionForumMapping getStudentDiscussionForumMappingById(Long id){
        StudentDiscussionForumMapping studentDiscussionForumMapping = studentDiscussionForumMappingRepository.findById(id).get();
        return studentDiscussionForumMapping;
    }
}
