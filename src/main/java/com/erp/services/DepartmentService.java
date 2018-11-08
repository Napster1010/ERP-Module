package com.erp.services;

import com.erp.beans.Department;
import com.erp.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(Department department) {
        Department insertedDepartment = departmentRepository.save(department);
        return insertedDepartment;
    }

    public Department getDepartmentByDepartmentId(String departmentId) {
        Department department = departmentRepository.findByDepartmentId(departmentId);
        return department;
    }

    public List<Department> getAllDepartments() {
        List<Department> allDepartments = departmentRepository.findAll();
        return allDepartments;
    }

    public Department getDepartmentByName(String departmentName) {
        Department department = departmentRepository.findByDepartmentName(departmentName);
        return department;
    }

    public boolean deleteDepartment(Department department) {
        try {
            departmentRepository.delete(department);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Department updateDepartment(Department department) {
        Department updatedDepartment = departmentRepository.save(department);
        return updatedDepartment;
    }
}
