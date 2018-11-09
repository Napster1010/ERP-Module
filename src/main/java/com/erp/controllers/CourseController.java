package com.erp.controllers;

import com.erp.beans.*;
import com.erp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @Autowired
    private CoursePrerequisiteService coursePrerequisiteService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private StudentCourseEnrollmentService studentCourseEnrollmentService;
    ///////////////////////////Course Methods//////////////////////////////////////////

    @RequestMapping(method = RequestMethod.POST)
    public Course addCourse(String courseCode, String courseName, String departmentId, Integer credits, Integer duration){
        Department department = departmentService.getDepartmentByDepartmentId(departmentId);
        Course course = new Course();
        course.setCourseCode(courseCode); course.setCourseName(courseName); course.setDepartment(department); course.setCredits(credits); course.setDuration(duration);
        Course insertedCourse = courseService.addCourse(course);
        return insertedCourse;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Course> getAllCourses(){
        List<Course> allCourses = courseService.getAllCourse();
        return allCourses;
    }

    @RequestMapping(method = RequestMethod.GET, params = "courseCode")
    public Course getCourseByCourseCode(String courseCode){
        Course course = courseService.getCourseByCourseCode(courseCode);
        return course;
    }

    @RequestMapping(method = RequestMethod.GET, params = "departmentId")
    public List<Course> getCourseByDepartmentId(String departmentId){
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

    @RequestMapping(value = "/enrollment", method = RequestMethod.POST)
    public CourseEnrollment addCourseEnrollment(String courseCode, String season, int year, String location, String facultySnuId){
        Course course = courseService.getCourseByCourseCode(courseCode);
        Faculty faculty = facultyService.getFacultyBySnuId(facultySnuId);
        CourseEnrollment courseEnrollment = new CourseEnrollment(null,course,season,year,location,faculty);
        CourseEnrollment insertedCourseEnrollment = courseEnrollmentService.addCourseEnrollment(courseEnrollment);
        return insertedCourseEnrollment;
    }

    @RequestMapping(value = "/enrollment", method = RequestMethod.PUT)
    public CourseEnrollment updateCourseEnrollment(@RequestBody CourseEnrollment courseEnrollment){
        CourseEnrollment updatedCourseEnrollment = courseEnrollmentService.updateCourseEnrollment(courseEnrollment);
        return updatedCourseEnrollment;
    }

    @RequestMapping(value = "/enrollment", method = RequestMethod.DELETE)
    public boolean deleteCourseEnrollment(@RequestBody CourseEnrollment courseEnrollment){
        boolean isDeleted = courseEnrollmentService.deleteCourseEnrollment(courseEnrollment);

        if(isDeleted)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/enrollment", method = RequestMethod.GET)
    public List<CourseEnrollment> getAllCourseEnrollments(){
        List<CourseEnrollment> courseEnrollments = courseEnrollmentService.getAllCourseEnrollments();
        return courseEnrollments;
    }

    @RequestMapping(value = "/enrollment", method = RequestMethod.GET, params = {"season", "year"})
    public List<CourseEnrollment> getCourseEnrollmentsBySeasonAndYear(String season, int year){
        List<CourseEnrollment> courseEnrollments = courseEnrollmentService.getCourseEnrollmentsBySeasonAndYear(season, year);
        return  courseEnrollments;
    }

    @RequestMapping(value = "/enrollment", method = RequestMethod.GET, params = "snuId")
    public List<CourseEnrollment> getCourseEnrollmentsByFacultySnuId(String snuId){
        List<CourseEnrollment> courseEnrollments = courseEnrollmentService.getCourseEnrollmentsByFacultySnuId(snuId);
        return courseEnrollments;
    }

    @RequestMapping(value = "/enrollment", method = RequestMethod.GET, params = {"season", "year", "snuId"})
    public List<CourseEnrollment> getCourseEnrollmentsBySeasonAndYearAndFacultySnuId(String season, int year, String snuId){
        List<CourseEnrollment> courseEnrollments = courseEnrollmentService.getCourseEnrollmentsBySeasonAndYearAndFacultySnuId(season, year, snuId);
        return courseEnrollments;
    }

    @RequestMapping(value = "/enrollment", method = RequestMethod.GET, params = {"courseCode", "season", "year"})
    public CourseEnrollment getCourseEnrollmentByCourseCodeAndSeasonAndYear(String courseCode, String season, int year){
        CourseEnrollment courseEnrollment = courseEnrollmentService.getCourseEnrollmentByCourseCodeAndSeasonAndYear(courseCode, season, year);
        return courseEnrollment;
    }

    ///////////////////////////Course Prerequisite Methods//////////////////////////////////////////

    @RequestMapping(value = "/prerequisite", method = RequestMethod.POST)
    public CoursePrerequisite addCoursePrerequisite(String courseCode, String prerequisiteCourseCode){
        Course course = courseService.getCourseByCourseCode(courseCode);
        Course prerequisiteCourse = courseService.getCourseByCourseCode(prerequisiteCourseCode);
        CoursePrerequisite coursePrerequisite = new CoursePrerequisite(null, course, prerequisiteCourse);
        CoursePrerequisite insertedCoursePrerequisite = coursePrerequisiteService.addCoursePrerequisite(coursePrerequisite);
        return insertedCoursePrerequisite;
    }

    @RequestMapping(value = "/prerequisite", method = RequestMethod.PUT)
    public CoursePrerequisite updateCoursePrerequisite(@RequestBody CoursePrerequisite coursePrerequisite){
        CoursePrerequisite updatedCoursePrerequisite = coursePrerequisiteService.updateCoursePrerequisite(coursePrerequisite);
        return updatedCoursePrerequisite;
    }

    @RequestMapping(value = "/prerequisite", method = RequestMethod.DELETE)
    public boolean deleteCoursePrerequisite(@RequestBody CoursePrerequisite coursePrerequisite){
        boolean isDeleted = coursePrerequisiteService.deleteCoursePrerequisite(coursePrerequisite);

        if(isDeleted)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/prerequisite", method = RequestMethod.GET, params = "courseCode")
    public List<CoursePrerequisite> getCoursePrerequisiteByCourseCode(String courseCode){
        List<CoursePrerequisite> coursePrerequisites = coursePrerequisiteService.getCoursePrerequisiteByCourseCode(courseCode);
        return coursePrerequisites;
    }

    ///////////////////////////Course Review Methods//////////////////////////////////////////

    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public Review addReview(String review, int rating, Long studentCourseEnrollmentId){
        StudentCourseEnrollment studentCourseEnrollment = studentCourseEnrollmentService.getStudentCourseEnrollmentById(studentCourseEnrollmentId);
        Review reviewObj = new Review(null, review, rating, studentCourseEnrollment, new Date());
        Review insertedReview = reviewService.addReview(reviewObj);
        return insertedReview;
    }

    @RequestMapping(value = "/review", method = RequestMethod.PUT)
    public Review updateReview(@RequestBody Review review) {
        Review updatedReview = reviewService.updateReview(review);
        return updatedReview;
    }

    @RequestMapping(value = "/review", method = RequestMethod.DELETE)
    public boolean deleteReview(@RequestBody Review review) {
        boolean isDeleted = reviewService.deleteReview(review);

        if(isDeleted)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/review", method = RequestMethod.GET, params = "studentCourseEnrollmentId")
    public Review getByStudentCourseEnrollmentId(Long studentCourseEnrollmentId){
        Review review = reviewService.getByStudentCourseEnrollmentId(studentCourseEnrollmentId);
        return review;
    }
}