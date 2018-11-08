package com.erp.services;

import com.erp.beans.Department;
import com.erp.beans.School;
import com.erp.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public School addSchool(School school) {
        School insertedSchool = schoolRepository.save(school);
        return insertedSchool;
    }

    public School getBySchoolId(String schoolId) {
        School school = schoolRepository.findBySchoolId(schoolId);
        return school;
    }

    public School getBySchoolName(String schoolName){
        School school = schoolRepository.findBySchoolName(schoolName);
        return school;
    }

    public List<School> getAllSchools() {
        List<School> allSchools = schoolRepository.findAll();
        return allSchools;
    }

    public boolean deleteSchool(School school) {
        try {
            schoolRepository.delete(school);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public School updateSchool(School school) {
        School updatedSchool = schoolRepository.save(school);
        return updatedSchool;
    }
}
