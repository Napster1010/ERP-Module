package com.erp.repositories;

import com.erp.beans.Course;
import com.erp.beans.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    public Course findByCourseCode(String courseName);
    public List<Course> findByDepartment(Department department);
}
