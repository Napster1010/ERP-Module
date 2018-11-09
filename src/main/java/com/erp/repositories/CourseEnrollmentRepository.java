package com.erp.repositories;

import com.erp.beans.Course;
import com.erp.beans.CourseEnrollment;
import com.erp.beans.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment, Long> {

    public List<CourseEnrollment> findBySeasonAndYear(String season, int year);

    public List<CourseEnrollment> findByFaculty(Faculty faculty);

    public List<CourseEnrollment> findBySeasonAndYearAndFaculty(String season, int year, Faculty faculty);

    public CourseEnrollment findByCourseAndSeasonAndYear(Course course, String season, int year);
}
