package com.erp.controllers;

import com.erp.beans.*;
import com.erp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CourseEnrollmentService courseEnrollmentService;

    @Autowired
    private StudentCourseEnrollmentService studentCourseEnrollmentService;

    @Autowired
    private StudentGradeService studentGradeService;

    ///////////////////////////Student Methods//////////////////////////////////////////

    @RequestMapping(method = RequestMethod.POST)
    public Student addStudent(String snuId, String name, String mobile, String address, @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateOfBirth, String guardianName, Integer yearOfJoining, String course, String major, String netId, String password, String departmentId){
        Department department = departmentService.getDepartmentByDepartmentId(departmentId);
        Student student = new Student();
        student.setSnuId(snuId); student.setName(name); student.setMobile(mobile); student.setAddress(address); student.setDateOfBirth(dateOfBirth); student.setGuardianName(guardianName); student.setYearOfJoining(yearOfJoining); student.setCourse(course); student.setMajor(major); student.setNetId(netId); student.setPassword(password); student.setDepartment(department);
        Student insertedStudent = studentService.addStudent(student);
        return insertedStudent;
    }

    @RequestMapping(method = RequestMethod.GET, params = "snuId")
    public Student getStudentBySnuId(String snuId){
        Student student = studentService.getStudentBySnuId(snuId);
        return student;
    }

    @RequestMapping(method = RequestMethod.GET, params = "netId")
    public Student getStudentByNetId(String netId){
        Student student = studentService.getStudentByNetId(netId);
        return student;
    }

    @RequestMapping(method = RequestMethod.GET, params = "departmentId")
    public List<Student> getStudentByDepartmentId(String departmentId){
        List<Student> students = studentService.getStudentsByDepartmentId(departmentId);
        return students;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        List<Student>students = studentService.getAllStudents();
        return students;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Student updateStudent(@RequestBody  Student student){
        Student updatedStudent = studentService.updateStudent(student);
        return updatedStudent;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public boolean deleteStudent(@RequestBody  Student student){
        boolean isDeleted = studentService.deleteStudent(student);

        if(isDeleted)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public boolean authenticateStudentByNetIdAndPassword(String netId, String password){
        boolean loginSuccessful = studentService.authenticateStudentByNetIdAndPassword(netId,password);

        if(loginSuccessful)
            return true;
        else
            return false;
    }

    ///////////////////////////Student course enrollment Methods//////////////////////////////////////////

    @RequestMapping(value = "/course-enrollment", method = RequestMethod.POST)
    public StudentCourseEnrollment addStudentCourseEnrollment(String snuId, Long courseEnrollmentId){
        Student student = studentService.getStudentBySnuId(snuId);
        CourseEnrollment courseEnrollment = courseEnrollmentService.getCourseEnrollmentById(courseEnrollmentId);

        StudentCourseEnrollment studentCourseEnrollment = new StudentCourseEnrollment();
        studentCourseEnrollment.setStudent(student); studentCourseEnrollment.setCourseEnrollment(courseEnrollment); studentCourseEnrollment.setTimestamp(new Date());

        StudentCourseEnrollment insertedStudentCourseEnrollment = studentCourseEnrollmentService.addStudentCourseEnrollment(studentCourseEnrollment);
        return insertedStudentCourseEnrollment;
    }

    @RequestMapping(value = "/course-enrollment", method = RequestMethod.DELETE)
    public boolean deleteStudentCourseEnrollment(@RequestBody StudentCourseEnrollment studentCourseEnrollment){
        boolean isDeleted = studentCourseEnrollmentService.deleteStudentCourseEnrollment(studentCourseEnrollment);

        if(isDeleted)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/course-enrollment", method = RequestMethod.GET, params = "snuId")
    public List<StudentCourseEnrollment> getStudentCourseEnrollmentBySnuId(String snuId){
        List<StudentCourseEnrollment> studentCourseEnrollments = studentCourseEnrollmentService.getStudentCourseEnrollmentBySnuId(snuId);
        return studentCourseEnrollments;
    }

    ///////////////////////////Student course enrollment Methods//////////////////////////////////////////

    @RequestMapping(value = "/grade", method = RequestMethod.POST)
    public StudentGrade addStudentGrade(Long studentCourseEnrollmentId, String grade){
        StudentCourseEnrollment studentCourseEnrollment = studentCourseEnrollmentService.getStudentCourseEnrollmentById(studentCourseEnrollmentId);
        StudentGrade studentGrade = new StudentGrade(null, studentCourseEnrollment, grade);
        StudentGrade insertedStudentGrade = studentGradeService.addStudentGrade(studentGrade);
        return insertedStudentGrade;
    }

    @RequestMapping(value = "/grade", method = RequestMethod.GET, params = "studentCourseEnrollmentId")
    public StudentGrade getStudentGradeByStudentCourseEnrollmentId(Long studentCourseEnrollmentId) {
        StudentGrade studentGrade = studentGradeService.getStudentGradeByStudentCourseEnrollmentId(studentCourseEnrollmentId);
        return studentGrade;
    }

    @RequestMapping(value = "/grade", method = RequestMethod.PUT)
    public StudentGrade updateStudentGrade(@RequestBody StudentGrade studentGrade){
        StudentGrade updatedStudentGrade = studentGradeService.updateStudentGrade(studentGrade);
        return updatedStudentGrade;
    }
}
