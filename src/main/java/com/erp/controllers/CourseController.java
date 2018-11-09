package com.erp.controllers;

import com.erp.beans.Course;
import com.erp.beans.CourseEnrollment;
import com.erp.beans.Department;
import com.erp.beans.Faculty;
import com.erp.services.CourseEnrollmentService;
import com.erp.services.CourseService;
import com.erp.services.DepartmentService;
import com.erp.services.FacultyService;
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

    @Autowired
    private CourseEnrollmentService courseEnrollmentService;

    @Autowired
    private FacultyService facultyService;

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
        List<Course> courses = courseService.getCourseByDepartmentId(departmentId);
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

    ///////////////////////////Course Enrollment Methods//////////////////////////////////////////

    @RequestMapping(value = "/course-enrollment", method = RequestMethod.POST)
    public CourseEnrollment addCourseEnrollment(String courseCode, String season, int year, String location, String facultySnuId){
        Course course = courseService.getCourseByCourseCode(courseCode);
        Faculty faculty = facultyService.getFacultyBySnuId(facultySnuId);
        CourseEnrollment courseEnrollment = new CourseEnrollment(null,course,season,year,location,faculty);
        CourseEnrollment insertedCourseEnrollment = courseEnrollmentService.addCourseEnrollment(courseEnrollment);
        return insertedCourseEnrollment;
    }

    @RequestMapping(value = "/course-enrollment", method = RequestMethod.PUT)
    public CourseEnrollment updateCourseEnrollment(@RequestBody CourseEnrollment courseEnrollment){
        CourseEnrollment updatedCourseEnrollment = courseEnrollmentService.updateCourseEnrollment(courseEnrollment);
        return updatedCourseEnrollment;
    }

    @RequestMapping(value = "/course-enrollment", method = RequestMethod.DELETE)
    public boolean deleteCourseEnrollment(@RequestBody CourseEnrollment courseEnrollment){
        boolean isDeleted = courseEnrollmentService.deleteCourseEnrollment(courseEnrollment);

        if(isDeleted)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/course-enrollment", method = RequestMethod.GET)
    public List<CourseEnrollment> getAllCourseEnrollments(){
        List<CourseEnrollment> courseEnrollments = courseEnrollmentService.getAllCourseEnrollments();
        return courseEnrollments;
    }

    @RequestMapping(value = "/course-enrollment", method = RequestMethod.GET, params = {"season", "year"})
    public List<CourseEnrollment> getCourseEnrollmentsBySeasonAndYear(String season, int year){
        List<CourseEnrollment> courseEnrollments = courseEnrollmentService.getCourseEnrollmentsBySeasonAndYear(season, year);
        return  courseEnrollments;
    }

    @RequestMapping(value = "/course-enrollment", method = RequestMethod.GET, params = "snuId")
    public List<CourseEnrollment> getCourseEnrollmentsByFacultySnuId(String snuId){
        List<CourseEnrollment> courseEnrollments = courseEnrollmentService.getCourseEnrollmentsByFacultySnuId(snuId);
        return courseEnrollments;
    }

    @RequestMapping(value = "/course-enrollment", method = RequestMethod.GET, params = {"season", "year", "snuId"})
    public List<CourseEnrollment> getCourseEnrollmentsBySeasonAndYearAndFacultySnuId(String season, int year, String snuId){
        List<CourseEnrollment> courseEnrollments = courseEnrollmentService.getCourseEnrollmentsBySeasonAndYearAndFacultySnuId(season, year, snuId);
        return courseEnrollments;
    }

    @RequestMapping(value = "/course-enrollment", method = RequestMethod.GET, params = {"courseCode", "season", "year"})
    public CourseEnrollment getCourseEnrollmentByCourseCodeAndSeasonAndYear(String courseCode, String season, int year){
        CourseEnrollment courseEnrollment = courseEnrollmentService.getCourseEnrollmentByCourseCodeAndSeasonAndYear(courseCode, season, year);
        return courseEnrollment;
    }
}
