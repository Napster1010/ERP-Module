package com.erp.services;

import com.erp.beans.Course;
import com.erp.beans.CoursePrerequisite;
import com.erp.repositories.CoursePrerequisiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursePrerequisiteService {
    @Autowired
    private CoursePrerequisiteRepository coursePrerequisiteRepository;

    @Autowired
    private CourseService courseService;

    public CoursePrerequisite addCoursePrerequisite(CoursePrerequisite coursePrerequisite){
        CoursePrerequisite insertedCoursePrerequisite = coursePrerequisiteRepository.save(coursePrerequisite);
        return insertedCoursePrerequisite;
    }

    public CoursePrerequisite updateCoursePrerequisite(CoursePrerequisite coursePrerequisite){
        if(coursePrerequisiteRepository.existsById(coursePrerequisite.getId())) {
            CoursePrerequisite updatedCoursePrerequisite = coursePrerequisiteRepository.save(coursePrerequisite);
            return updatedCoursePrerequisite;
        }
        else
            return null;
    }

    public boolean deleteCoursePrerequisite(CoursePrerequisite coursePrerequisite){
        try {
            coursePrerequisiteRepository.delete(coursePrerequisite);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<CoursePrerequisite> getCoursePrerequisiteByCourseCode(String courseCode){
        Course course = courseService.getCourseByCourseCode(courseCode);
        List<CoursePrerequisite> coursePrerequisites = coursePrerequisiteRepository.findByCourse(course);
        return coursePrerequisites;
    }
}
