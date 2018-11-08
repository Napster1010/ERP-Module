package com.erp.services;

import com.erp.beans.Department;
import com.erp.beans.Faculty;
import com.erp.repositories.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private LoginService loginService;

    public Faculty addFaculty(Faculty faculty){
        String hashedPassword = loginService.hashPassword(faculty.getPassword());
        faculty.setPassword(hashedPassword);
        Faculty insertedFaculty = facultyRepository.save(faculty);
        return insertedFaculty;
    }

    public Faculty getFacultyBySnuId(String snuId){
        Faculty faculty = facultyRepository.findBySnuId(snuId);
        return faculty;
    }

    public Faculty getFacultyByNetId(String netId){
        Faculty faculty = facultyRepository.findByNetId(netId);
        return faculty;
    }

    public List<Faculty> getFacultyByDepartment(String departmentId){
        Department department = departmentService.getDepartmentByDepartmentId(departmentId);
        List<Faculty> faculties = facultyRepository.findByDepartment(department);
        return faculties;
    }

    public List<Faculty> getAllFaculties(){
        List<Faculty> faculties = facultyRepository.findAll();
        return faculties;
    }

    public boolean deleteFaculty(Faculty faculty){
        try {
            facultyRepository.delete(faculty);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Faculty updateFaculty(Faculty faculty){
        if(facultyRepository.existsById(faculty.getId())){
            Faculty updatedFaculty = facultyRepository.save(faculty);
            return updatedFaculty;
        }
        else
            return null;
    }

    public boolean authenticateFacultyByNetIdAndPassword(String netId, String password){
        boolean loginSuccessful = false;
        Faculty faculty = getFacultyByNetId(netId);

        if(faculty!=null)
            loginSuccessful = loginService.checkPassword(password, faculty.getPassword());

        if(loginSuccessful)
            return true;
        else
            return false;
    }
}
