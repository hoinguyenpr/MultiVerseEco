package com.ecommerce.admin.user;

import com.common.entity.Role;
import com.ecommerce.admin.utils.TestUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.nio.charset.StandardCharsets;
import java.util.Random;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback()
public class RoleRepositoryTest {
    @Autowired
    private RoleRepository repo;

    @Test
    public void testCreateRole() {
        String randomRoleName = TestUtils.generateText(7);
        Role role = Role.builder()
                .name(randomRoleName)
                .description(randomRoleName + " is doing something")
                .build();
        Role createdRole = repo.save(role);
        Assertions.assertThat(createdRole.getName())
                .isEqualTo(randomRoleName);
    }
}
