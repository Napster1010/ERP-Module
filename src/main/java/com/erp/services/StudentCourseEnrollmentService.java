package com.erp.services;

import com.erp.beans.Student;
import com.erp.beans.StudentCourseEnrollment;
import com.erp.repositories.StudentCourseEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseEnrollmentService {
    @Autowired
    private StudentCourseEnrollmentRepository studentCourseEnrollmentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseEnrollmentService courseEnrollmentService;

    public StudentCourseEnrollment addStudentCourseEnrollment(StudentCourseEnrollment studentCourseEnrollment){
        StudentCourseEnrollment insertedStudentCourseEnrollment = studentCourseEnrollmentRepository.save(studentCourseEnrollment);
        return insertedStudentCourseEnrollment;
    }

    public boolean deleteStudentCourseEnrollment(StudentCourseEnrollment studentCourseEnrollment){
        try {
            studentCourseEnrollmentRepository.delete(studentCourseEnrollment);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<StudentCourseEnrollment> getStudentCourseEnrollmentBySnuId(String snuId){
        Student student = studentService.getStudentBySnuId(snuId);
        List<StudentCourseEnrollment> studentCourseEnrollments = studentCourseEnrollmentRepository.findByStudent(student);
        return studentCourseEnrollments;
    }
}
