package com.ecommerce.admin.mapper;

import com.common.entity.Role;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//Rollback database after running test
@Transactional
public class RoleMapperTest {
    @Autowired
    private RoleMapper roleMapper;

    Role roleAdmin = Role.builder()
            .name("Admin")
            .description("Manage everything")
            .build();

    @Test
    public void testInsertRole() {

        Integer roleId = roleMapper.insert(roleAdmin);
        Assertions.assertThat(roleId).isGreaterThan(0);
    }

}
