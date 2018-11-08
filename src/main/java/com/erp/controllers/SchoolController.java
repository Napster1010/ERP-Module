package com.erp.controllers;

import com.erp.beans.School;
import com.erp.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public School addSchool(String schoolId, String schoolName) {
        System.out.println("method: addSchool()");
        School school = new School();
        school.setSchoolId(schoolId);
        school.setSchoolName(schoolName);
        School insertedSchool = schoolService.addSchool(school);
        return insertedSchool;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        System.out.println("method: getAllSchools()");
        List<School> allSchools = schoolService.getAllSchools();
        return allSchools;
    }

    @RequestMapping(value = "/{schoolId}", method = RequestMethod.GET, params = "schoolId")
    public School getSchoolBySchoolId(@PathVariable(name = "schoolId") String schoolId) {
        System.out.println("method: getSchoolBySchoolId()");
        School school = schoolService.getBySchoolId(schoolId);
        return school;
    }

    @RequestMapping(value = "/{schoolName}", method = RequestMethod.GET, params = "schoolName")
    public School getSchoolBySchoolName(@PathVariable(name = "schoolName") String schoolName) {
        System.out.println("method: getSchoolBySchoolName()");
        School school = schoolService.getBySchoolName(schoolName);
        return school;
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public boolean deleteSchool(@RequestBody School school) {
        System.out.println("method: deleteSchool()");
        boolean isDeleted = schoolService.deleteSchool(school);
        if (isDeleted)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public School updateSchool(@RequestBody School school) {
        System.out.println("method: updateSchool()");
        School updatedSchool = schoolService.updateSchool(school);
        return updatedSchool;
    }
}
