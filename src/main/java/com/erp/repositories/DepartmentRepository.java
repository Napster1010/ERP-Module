package com.erp.repositories;

import com.erp.beans.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentId(String departmentId);

    public Department findByDepartmentName(String departmentName);
}
