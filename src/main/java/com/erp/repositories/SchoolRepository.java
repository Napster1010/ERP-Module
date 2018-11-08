package com.erp.repositories;

import com.erp.beans.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

    public School findBySchoolId(String schoolId);

    public School findBySchoolName(String schoolName);
}
