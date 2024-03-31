package com.ecommerce.admin.mapper;

import com.common.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleMapper {
    List<Role> findAll();

    Optional<Role> findById(Integer id);

    int deleteById(Integer id);

    int insert(Role role);

    int update(Role role);
}
