package com.ecommerce.admin.user;

import com.common.entity.Role;
import com.common.entity.User;
import com.ecommerce.admin.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

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

    public void save(User user) throws UserNotFoundException {
        boolean isUpdatingUser = user.getId() != null;
        if (isUpdatingUser) {
            try {
                User existingUser = userRepo.findById(user.getId()).get();
                if (user.getPassword().isEmpty()) {
                    user.setPassword(existingUser.getPassword());
                } else {
                    encodePassword(user);
                }
            } catch (NoSuchElementException ex) {
                throw new UserNotFoundException("Could not find any user with ID: " + user.getId());
            }
        } else {
            encodePassword(user);
        }
        userRepo.save(user);
    }

    public List<Role> listRoles() {
        return (List<Role>) roleRepo.findAll();
    }

    private void encodePassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    public boolean isEmailUnique(Integer id, String email) {
        User userByEmail = userRepo.findByEmail(email);
        if (userByEmail == null) return true;
        boolean isCreatingNew = Objects.isNull(id);
        if (isCreatingNew) return false;
        return Objects.equals(userByEmail.getId(), id);
    }

    public User  get(Integer id) throws UserNotFoundException {
        try {
            return userRepo.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new UserNotFoundException("Could not find any user with ID: " + id);
        }
    }
}
