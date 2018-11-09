package com.erp.services;

import com.erp.beans.EnrollmentStatus;
import com.erp.beans.Student;
import com.erp.beans.StudentCourseEnrollment;
import com.erp.repositories.StudentCourseEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class StudentCourseEnrollmentService {
    @Autowired
    private StudentCourseEnrollmentRepository studentCourseEnrollmentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseEnrollmentService courseEnrollmentService;

    @Autowired
    private EnrollmentStatusService enrollmentStatusService;

    public StudentCourseEnrollment addStudentCourseEnrollment(StudentCourseEnrollment studentCourseEnrollment){
        EnrollmentStatus enrollmentStatus = enrollmentStatusService.getByYearAndStatus(studentCourseEnrollment.getStudent().getYearOfJoining(), "ACTIVE");
        Date currTime = new Date();
        if(enrollmentStatus!=null){
            if(currTime.after(enrollmentStatus.getEnrollmentStartTime()) && currTime.before(enrollmentStatus.getEnrollmentEndTime())){
                StudentCourseEnrollment insertedStudentCourseEnrollment = studentCourseEnrollmentRepository.save(studentCourseEnrollment);
                return insertedStudentCourseEnrollment;
            }
        }
        return null;
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

    public StudentCourseEnrollment getStudentCourseEnrollmentById(Long id){
        StudentCourseEnrollment studentCourseEnrollment = studentCourseEnrollmentRepository.findById(id).get();
        return studentCourseEnrollment;
    }
}
