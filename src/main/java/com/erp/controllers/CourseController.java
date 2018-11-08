package com.erp.controllers;

import com.erp.beans.Course;
import com.erp.beans.Department;
import com.erp.services.CourseService;
import com.erp.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Course addCourse(String courseCode, String courseName, String departmentId, Integer credits, Integer duration){
        Department department = departmentService.getDepartmentByDepartmentId(departmentId);
        Course course = new Course();
        course.setCourseCode(courseCode); course.setCourseName(courseName); course.setDepartment(department); course.setCredits(credits); course.setDuration(duration);
        Course insertedCourse = courseService.addCourse(course);
        return insertedCourse;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Course> getAllCourses(){
        List<Course> allCourses = courseService.getAllCourse();
        return allCourses;
    }

    @RequestMapping(value = "/{courseCode}", method = RequestMethod.GET, params = "courseCode")
    public Course getCourseByCourseCode(@PathVariable(name = "courseCode") String courseCode){
        Course course = courseService.getCourseByCourseCode(courseCode);
        return course;
    }

    @RequestMapping(value = "/{departmentId}", method = RequestMethod.GET, params = "departmentId")
    public List<Course> getCourseByDepartmentId(@PathVariable(name = "departmentId") String departmentId){
        Department department = departmentService.getDepartmentByDepartmentId(departmentId);
        List<Course> courses = courseService.getCourseByDepartmentId(department);
        return courses;
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public boolean deleteCourse(@RequestBody Course course){
        boolean isDeleted = courseService.deleteCourse(course);
        if(isDeleted)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Course updateCourse(@RequestBody Course course){
        Course updatedCourse = courseService.updateCourse(course);
        return updatedCourse;
    }
}
