package com.erp.services;

import com.erp.beans.Course;
import com.erp.beans.Department;
import com.erp.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private DepartmentService departmentService;

    public Course addCourse(Course course){
        Course insertedCourse = courseRepository.save(course);
        return course;
    }

    public List<Course> getAllCourse(){
        List<Course> allCourses = courseRepository.findAll();
        return allCourses;
    }

    public Course getCourseByCourseCode(String courseCode){
        Course course = courseRepository.findByCourseCode(courseCode);
        return course;
    }

    public List<Course> getCourseByDepartmentId(String departmentId){
        Department department = departmentService.getDepartmentByDepartmentId(departmentId);
        List<Course> courses = courseRepository.findByDepartment(department);
        return courses;
    }

    public boolean deleteCourse(Course course){
        try{
            courseRepository.delete(course);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Course updateCourse(Course course){
        if(courseRepository.existsById(course.getId())){
            Course updatedCourse = courseRepository.save(course);
            return updatedCourse;
        }
        else
            return null;
    }
}
