package com.erp.repositories;

import com.erp.beans.Department;
import com.erp.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student findBySnuId(String snuId);

    public Student findByNetId(String netId);

    public List<Student> findByDepartment(Department department);
}
