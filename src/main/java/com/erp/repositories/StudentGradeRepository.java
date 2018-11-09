package com.erp.repositories;

import com.erp.beans.StudentCourseEnrollment;
import com.erp.beans.StudentGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentGradeRepository extends JpaRepository<StudentGrade, Long> {

    public StudentGrade findByStudentCourseEnrollment(StudentCourseEnrollment studentCourseEnrollment);
}
