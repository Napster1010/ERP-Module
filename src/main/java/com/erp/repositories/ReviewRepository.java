package com.erp.repositories;

import com.erp.beans.Review;
import com.erp.beans.StudentCourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    public Review findByStudentCourseEnrollment(StudentCourseEnrollment studentCourseEnrollment);
}
