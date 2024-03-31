package com.ecommerce.admin.service;

import com.common.entity.Role;
import com.ecommerce.admin.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleMapper mapper;

    public Role getRole(int id) {
        return mapper.findById(id).get();
    }
}
