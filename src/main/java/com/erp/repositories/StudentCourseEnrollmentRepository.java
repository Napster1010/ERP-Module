package com.erp.repositories;

import com.erp.beans.CourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseEnrollmentRepository extends JpaRepository<CourseEnrollment, Long> {
}
