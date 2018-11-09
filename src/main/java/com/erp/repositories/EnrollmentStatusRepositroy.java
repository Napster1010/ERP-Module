package com.erp.repositories;

import com.erp.beans.EnrollmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentStatusRepositroy extends JpaRepository<EnrollmentStatus, Long> {

    public List<EnrollmentStatus> findByStatus(String status);

    public EnrollmentStatus findByYearAndStatus(Integer year, String status);
}
