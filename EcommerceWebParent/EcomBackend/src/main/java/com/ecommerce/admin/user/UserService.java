package com.ecommerce.admin.user;

import com.common.entity.Role;
import com.common.entity.User;
import com.ecommerce.admin.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> listAll() {
        return (List<User>) userRepo.findAll();
    }

    public void save(User user) {
        encodePassword(user);
        userRepo.save(user);
    }

    public List<Role> listRoles() {
        return (List<Role>) roleRepo.findAll();
    }

    private void encodePassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    public boolean isEmailUnique(String email) {
        User user = userRepo.findByEmail(email);
        return user == null;
    }
}
