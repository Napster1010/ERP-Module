package com.erp.repositories;

import com.erp.beans.Department;
import com.erp.beans.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    public Faculty findBySnuId(String snuId);

    public Faculty findByNetId(String netId);

    public List<Faculty> findByDepartment(Department department);
}
