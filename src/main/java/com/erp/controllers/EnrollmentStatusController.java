package com.erp.controllers;

import com.erp.beans.EnrollmentStatus;
import com.erp.services.EnrollmentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/enrollment-status")
public class EnrollmentStatusController {
    @Autowired
    private EnrollmentStatusService enrollmentStatusService;

    @RequestMapping(method = RequestMethod.POST)
    public EnrollmentStatus addEnrollmentStatus(int year, String status, @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss") Date enrollmentStartTime) {
        EnrollmentStatus enrollmentStatus = new EnrollmentStatus(null, year, status, enrollmentStartTime, null);
        EnrollmentStatus insertedEnrollmentStatus = enrollmentStatusService.addEnrollmentStatus(enrollmentStatus);
        return insertedEnrollmentStatus;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public EnrollmentStatus updateEnrollmentStatus(@RequestBody EnrollmentStatus enrollmentStatus){
        EnrollmentStatus updatedEnrollmentStatus = enrollmentStatusService.updateEnrollmentStatus(enrollmentStatus);
        return updatedEnrollmentStatus;
    }

    @RequestMapping(method = RequestMethod.GET, params = "status")
    public List<EnrollmentStatus> getByStatus(String status) {
        List<EnrollmentStatus> enrollmentStatuses = enrollmentStatusService.getByStatus(status);
        return enrollmentStatuses;
    }

    @RequestMapping(method = RequestMethod.GET, params = {"year", "status"})
    public EnrollmentStatus getByYearAndStatus(int year, String status) {
        EnrollmentStatus enrollmentStatus = enrollmentStatusService.getByYearAndStatus(year, status);
        return enrollmentStatus;
    }
}
