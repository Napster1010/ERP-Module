package com.erp.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public String hashPassword(String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashedPassword;
    }

    public boolean checkPassword(String password, String hashedPassword) {
        if (BCrypt.checkpw(password, hashedPassword)) {
            return true;
        } else
            return false;
    }
}
