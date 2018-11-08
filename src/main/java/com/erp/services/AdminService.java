package com.erp.services;

import com.erp.beans.Admin;
import com.erp.repositories.AdminRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private LoginService loginService;

    public Admin addAdmin(Admin admin){
        String hashedPassword = loginService.hashPassword(admin.getPassword());
        admin.setPassword(hashedPassword);
        Admin insertedAdmin = adminRepository.save(admin);
        return insertedAdmin;
    }

    public List<Admin> getAllAdmin(){
        List<Admin> allAdmin = adminRepository.findAll();
        return allAdmin;
    }

    public Admin getAdminBySnuId(String snuId){
        Admin admin = adminRepository.findBySnuId(snuId);
        return admin;
    }

    public boolean deleteAdmin(Admin admin){
        try {
            adminRepository.delete(admin);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Admin updateAdmin(Admin admin){
        if(adminRepository.existsById(admin.getId())){
            Admin updatedAdmin = adminRepository.save(admin);
            return updatedAdmin;
        }
        else
            return null;
    }

    public Admin getAdminByNetId(String netId){
        Admin admin = adminRepository.findByNetId(netId);
        return admin;
    }

    public boolean authenticateAdminByNetIdAndPassword(String netId, String password){
        boolean loginSuccessful = false;
        Admin admin = getAdminByNetId(netId);

        if(admin!=null)
            loginSuccessful = loginService.checkPassword(password, admin.getPassword());

        if(loginSuccessful)
            return true;
        else
            return false;
    }
}
