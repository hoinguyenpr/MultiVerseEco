package com.ecommerce.admin.service;

import com.common.entity.Role;
import com.ecommerce.admin.user.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public List<Role> listAll() {
        return (List<Role>) repository.findAll();
    }
}
