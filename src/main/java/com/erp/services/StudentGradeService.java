package com.erp.services;

import com.erp.beans.StudentCourseEnrollment;
import com.erp.beans.StudentGrade;
import com.erp.repositories.StudentGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentGradeService {
    @Autowired
    private StudentGradeRepository studentGradeRepository;

    @Autowired
    private StudentCourseEnrollmentService studentCourseEnrollmentService;

    public StudentGrade addStudentGrade(StudentGrade studentGrade){
        StudentGrade insertedStudentGrade = studentGradeRepository.save(studentGrade);
        return insertedStudentGrade;
    }

    public StudentGrade getStudentGradeByStudentCourseEnrollmentId(Long studentCourseEnrollmentId){
        StudentCourseEnrollment studentCourseEnrollment = studentCourseEnrollmentService.getStudentCourseEnrollmentById(studentCourseEnrollmentId);
        StudentGrade studentGrade = studentGradeRepository.findByStudentCourseEnrollment(studentCourseEnrollment);
        return studentGrade;
    }

    public StudentGrade updateStudentGrade(StudentGrade studentGrade){
        if(studentGradeRepository.existsById(studentGrade.getId())){
            StudentGrade updatedStudentGrade = studentGradeRepository.save(studentGrade);
            return updatedStudentGrade;
        }
        else
            return null;
    }
}
