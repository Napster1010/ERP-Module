package com.erp.services;

import com.erp.beans.Course;
import com.erp.beans.CourseEnrollment;
import com.erp.beans.Faculty;
import com.erp.repositories.CourseEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseEnrollmentService {
    @Autowired
    CourseEnrollmentRepository courseEnrollmentRepository;

    @Autowired
    FacultyService facultyService;

    @Autowired
    CourseService courseService;

    public CourseEnrollment addCourseEnrollment(CourseEnrollment courseEnrollment){
        CourseEnrollment insertedCourseEnrollment = courseEnrollmentRepository.save(courseEnrollment);
        return insertedCourseEnrollment;
    }

    public CourseEnrollment updateCourseEnrollment(CourseEnrollment courseEnrollment){
        if(courseEnrollmentRepository.existsById(courseEnrollment.getId())){
            CourseEnrollment updatedCourseEnrollment = courseEnrollmentRepository.save(courseEnrollment);
            return updatedCourseEnrollment;
        }
        else
            return null;
    }

    public boolean deleteCourseEnrollment(CourseEnrollment courseEnrollment){
        try {
            courseEnrollmentRepository.delete(courseEnrollment);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<CourseEnrollment> getAllCourseEnrollments(){
        List<CourseEnrollment> allCourseEnrollments = courseEnrollmentRepository.findAll();
        return allCourseEnrollments;
    }

    public List<CourseEnrollment> getCourseEnrollmentsBySeasonAndYear(String season, int year){
        List<CourseEnrollment> courseEnrollments = courseEnrollmentRepository.findBySeasonAndYear(season, year);
        return courseEnrollments;
    }

    public List<CourseEnrollment> getCourseEnrollmentsByFacultySnuId(String snuId){
        Faculty faculty = facultyService.getFacultyBySnuId(snuId);
        List<CourseEnrollment> courseEnrollments = courseEnrollmentRepository.findByFaculty(faculty);
        return courseEnrollments;
    }

    public List<CourseEnrollment> getCourseEnrollmentsBySeasonAndYearAndFacultySnuId(String season, int year, String snuId){
        Faculty faculty = facultyService.getFacultyBySnuId(snuId);
        List<CourseEnrollment> courseEnrollments = courseEnrollmentRepository.findBySeasonAndYearAndFaculty(season, year, faculty);
        return courseEnrollments;
    }

    public CourseEnrollment getCourseEnrollmentByCourseCodeAndSeasonAndYear(String courseCode, String season, int year){
        Course course = courseService.getCourseByCourseCode(courseCode);
        CourseEnrollment courseEnrollment = courseEnrollmentRepository.findByCourseAndSeasonAndYear(course, season, year);
        return courseEnrollment;
    }
}
