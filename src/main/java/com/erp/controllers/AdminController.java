package com.erp.controllers;

import com.erp.beans.Admin;
import com.erp.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(method = RequestMethod.POST)
    public Admin addAdmin(String snuId, String name, String mobile, String address, @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateOfBirth, String netId, String password){
        Admin admin = new Admin();
        admin.setSnuId(snuId); admin.setName(name); admin.setMobile(mobile); admin.setAddress(address); admin.setDateOfBirth(dateOfBirth); admin.setNetId(netId); admin.setPassword(password);
        Admin insertedAdmin = adminService.addAdmin(admin);
        return admin;
    }

    @RequestMapping(method = RequestMethod.GET, params = "snuId")
    public Admin getAdminBySnuId(String snuId){
        Admin admin = adminService.getAdminBySnuId(snuId);
        return admin;
    }

    @RequestMapping(method = RequestMethod.GET, params = "netId")
    public Admin getAdminByNetId(String netId){
        Admin admin = adminService.getAdminByNetId(netId);
        return admin;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Admin> getAllAdmin(){
        List<Admin> allAdmin = adminService.getAllAdmin();
        return allAdmin;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Admin updateAdmin(@RequestBody Admin admin){
        Admin updatedAdmin = adminService.updateAdmin(admin);
        return updatedAdmin;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public boolean deleteAdmin(@RequestBody Admin admin){
        boolean isDeleted = adminService.deleteAdmin(admin);
        if(isDeleted)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public boolean loginAdmin(String netId, String password){
        boolean loginSuccessful = adminService.authenticateAdminByNetIdAndPassword(netId, password);
        if(loginSuccessful)
            return true;
        else
            return false;
    }
}
