package com.erp.repositories;

import com.erp.beans.EnrollmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentStatusRepositroy extends JpaRepository<EnrollmentStatus, Long> {
}
