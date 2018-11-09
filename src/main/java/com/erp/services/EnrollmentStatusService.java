package com.erp.services;

import com.erp.beans.EnrollmentStatus;
import com.erp.repositories.EnrollmentStatusRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentStatusService {
    @Autowired
    private EnrollmentStatusRepositroy enrollmentStatusRepositroy;

    public EnrollmentStatus addEnrollmentStatus(EnrollmentStatus enrollmentStatus){
        EnrollmentStatus insertedEnrollmentStatus = enrollmentStatusRepositroy.save(enrollmentStatus);
        return insertedEnrollmentStatus;
    }

    public EnrollmentStatus updateEnrollmentStatus(EnrollmentStatus enrollmentStatus){
        if(enrollmentStatusRepositroy.existsById(enrollmentStatus.getId())){
            EnrollmentStatus updatedEnrollmentStatus = enrollmentStatusRepositroy.save(enrollmentStatus);
            return updatedEnrollmentStatus;
        }
        else
            return null;
    }

    public List<EnrollmentStatus> getByStatus(String status){
        List<EnrollmentStatus> enrollmentStatuses = enrollmentStatusRepositroy.findByStatus(status);
        return enrollmentStatuses;
    }

    public EnrollmentStatus getByYearAndStatus(int year, String status){
        EnrollmentStatus enrollmentStatus = enrollmentStatusRepositroy.findByYearAndStatus(year, status);
        return enrollmentStatus;
    }
}
