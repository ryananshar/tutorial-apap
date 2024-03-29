package apap.tutorial.haidokter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import apap.tutorial.haidokter.model.UserModel;
import apap.tutorial.haidokter.repository.UserDb;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public UserModel getUserByName(String name) {
        return userDb.findByUsername(name);
    }

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @Override
    public boolean checkIfValidOldPassword(UserModel user, String oldPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass = user.getPassword();
        if (passwordEncoder.matches(oldPassword, pass)) {
            return true;
        }
        return false;
    }

    @Override
    public void changePassword(UserModel user, String newPassword) {
        String pass = encrypt(newPassword);
        user.setPassword(pass);
        userDb.save(user);
    }
    
}
