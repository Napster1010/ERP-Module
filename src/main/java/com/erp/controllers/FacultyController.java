package com.erp.controllers;

import com.erp.beans.Department;
import com.erp.beans.Faculty;
import com.erp.services.DepartmentService;
import com.erp.services.FacultyService;
import com.sun.org.apache.bcel.internal.generic.LSTORE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(method = RequestMethod.POST)
    public Faculty addFaculty(String snuId, String name, String mobile, String address, @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateOfBirth, String netId, String password, String departmentId){
        Department department = departmentService.getDepartmentByDepartmentId(departmentId);
        Faculty faculty = new Faculty();
        faculty.setSnuId(snuId); faculty.setName(name); faculty.setMobile(mobile); faculty.setAddress(address); faculty.setDateOfBirth(dateOfBirth); faculty.setNetId(netId); faculty.setPassword(password); faculty.setDepartment(department);
        Faculty insertedFaculty = facultyService.addFaculty(faculty);
        return insertedFaculty;
    }

    @RequestMapping(method = RequestMethod.GET, params = "snuId")
    public Faculty getFacultyBySnuId(String snuId){
        Faculty faculty = facultyService.getFacultyBySnuId(snuId);
        return faculty;
    }

    @RequestMapping(method = RequestMethod.GET, params = "netId")
    public Faculty getFacultyByNetId(String netId){
        Faculty faculty = facultyService.getFacultyByNetId(netId);
        return faculty;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Faculty> getAllFaculties(){
        List<Faculty> faculties = facultyService.getAllFaculties();
        return faculties;
    }

    @RequestMapping(method = RequestMethod.GET, params = "departmentId")
    public List<Faculty> getFacultiesByDepartmentId(String departmentId){
        List<Faculty> faculties = facultyService.getFacultyByDepartment(departmentId);
        return faculties;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Faculty updateFaculty(Faculty faculty){
        Faculty updatedFaculty = facultyService.updateFaculty(faculty);
        return updatedFaculty;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public boolean deleteFaculty(Faculty faculty){
        boolean isDeleted = facultyService.deleteFaculty(faculty);

        if(isDeleted)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public boolean authenticateFacultyByNetIdAndPassword(String netId, String password){
        boolean loginSuccessful = facultyService.authenticateFacultyByNetIdAndPassword(netId, password);

        if(loginSuccessful)
            return true;
        else
            return false;
    }
}
