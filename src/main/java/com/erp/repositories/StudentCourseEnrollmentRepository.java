package com.erp.repositories;

import com.erp.beans.CourseEnrollment;
import com.erp.beans.Student;
import com.erp.beans.StudentCourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseEnrollmentRepository extends JpaRepository<StudentCourseEnrollment, Long> {

    public List<StudentCourseEnrollment> findByStudent(Student student);
}
