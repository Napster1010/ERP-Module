package com.erp.repositories;

import com.erp.beans.Course;
import com.erp.beans.CoursePrerequisite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursePrerequisiteRepository extends JpaRepository<CoursePrerequisite, Long> {

    public List<CoursePrerequisite> findByCourse(Course course);
}
