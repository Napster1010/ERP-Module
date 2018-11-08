package com.erp.controllers;

import com.erp.beans.Department;
import com.erp.services.DepartmentService;
import com.erp.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Department addDepartment(@RequestParam(name = "department-id") String departmentId, @RequestParam(name = "department-name") String departmentName, @RequestParam(name = "school-id") String schoolId, @RequestParam(name = "hod") String hod){
        Department department = new Department();
        department.setDepartmentId(departmentId); department.setDepartmentName(departmentName); department.setHod(hod); department.setSchool(schoolService.getBySchoolId(schoolId));
        Department insertedDepartment = departmentService.addDepartment(department);
        return  insertedDepartment;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Department> getAllDepartments(){
        List<Department> allDepartments = departmentService.getAllDepartments();
        return  allDepartments;
    }

    @RequestMapping(value = "/{departmentId}", method = RequestMethod.GET, params = "department-id")
    public Department getDepartmentByDepartmentId(@PathVariable(name = "departmentId") String departmentId){
        Department department = departmentService.getDepartmentByDepartmentId(departmentId);
        return department;
    }

    @RequestMapping(value = "/{departmentName}", method = RequestMethod.GET, params = "department-name")
    public Department getDepartmentByDepartmentName(@PathVariable(name = "departmentName") String departmentName){
        Department department = departmentService.getDepartmentByName(departmentName);
        return  department;
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public boolean deleteDepartment(@RequestBody Department department){
        boolean isDeleted = departmentService.deleteDepartment(department);
        if(isDeleted)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Department updateDepartment(@RequestBody Department department){
        Department updatedDepartment = departmentService.updateDepartment(department);
        return updatedDepartment;
    }
}
