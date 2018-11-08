package com.erp.services;

import com.erp.beans.Department;
import com.erp.beans.Student;
import com.erp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LoginService loginService;

    @Autowired
    private DepartmentService departmentService;

    public Student addStudent(Student student){
        String hashedPassword = loginService.hashPassword(student.getPassword());
        student.setPassword(hashedPassword);
        Student insertedStudent = studentRepository.save(student);
        return insertedStudent;
    }

    public Student getStudentBySnuId(String snuId){
        Student student = studentRepository.findBySnuId(snuId);
        return student;
    }

    public Student getStudentByNetId(String netId){
        Student student = studentRepository.findByNetId(netId);
        return student;
    }

    public List<Student> getAllStudents(){
        List<Student> allStudents = studentRepository.findAll();
        return allStudents;
    }

    public List<Student> getStudentsByDepartmentId(String departmentId){
        Department department = departmentService.getDepartmentByDepartmentId(departmentId);
        List<Student> students = studentRepository.findByDepartment(department);
        return students;
    }

    public Student updateStudent(Student student){
        if(studentRepository.existsById(student.getId()))
        {
            Student updatedStudent = studentRepository.save(student);
            return updatedStudent;
        }
        else
            return null;
    }

    public boolean deleteStudent(Student student){
        try {
            studentRepository.delete(student);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean authenticateStudentByNetIdAndPassword(String netId, String password){
        boolean loginSuccessful = false;
        Student student = getStudentByNetId(netId);

        if(student!=null)
            loginSuccessful = loginService.checkPassword(password, student.getPassword());

        if(loginSuccessful)
            return true;
        else
            return false;
    }
}
