package com.ecommerce.admin.user;

import com.common.entity.Role;
import com.common.entity.User;
import com.ecommerce.admin.utils.TestUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;
import java.util.HashSet;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback()
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;

    /**
     * Tests the creation of a new user in the repository.
     * Generates random data for first name, last name, email, and password
     * then saves the user and verifies the user is correctly stored.
     */
    @Test
    public void testCreateUser() {
        // Generate random user data
        String firstName = TestUtils.generateText(5);
        String lastName = TestUtils.generateText(5);
        String email = TestUtils.generateText(5) + "@gmail.com";
        String password = TestUtils.generateText(10);

        // Create a new user with the generated data
        User newUser = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build();

        // Save the new user to the repository
        User createdUser = userRepo.save(newUser);

        // Verify the user is correctly stored in the repository
        Assertions.assertThat(createdUser)
                .extracting(User::getFirstName, User::getLastName, User::getEmail, User::getPassword)
                .containsExactly(firstName, lastName, email, password);
    }


    /**
     * Tests the creation of a new user with multiple roles.
     */
    @Test
    public void testCreateUserWithRoles() {
        // Create two roles
        Role firstRole = Role.builder()
                .name(TestUtils.generateText(7))
                .description("role 1 description")
                .build();
        Role secondRole = Role.builder()
                .name(TestUtils.generateText(7))
                .description("role 2 description")
                .build();
        Role createdFirstRole = roleRepo.save(firstRole);
        Role createdSecondRole = roleRepo.save(secondRole);

        // Create a user with the two roles
        String firstName = TestUtils.generateText(5);
        String lastName = TestUtils.generateText(5);
        String email = TestUtils.generateText(5) + "@gmail.com";
        String password = TestUtils.generateText(10);
        User newUser = new User(firstName, lastName, email, password);
        newUser.addRole(createdFirstRole);
        newUser.addRole(createdSecondRole);
        User createdUser = userRepo.save(newUser);

        // Verify that the user and roles were created correctly
        Assertions.assertThat(createdUser)
                .extracting(
                        User::getFirstName,
                        User::getLastName,
                        User::getEmail,
                        User::getPassword,
                        User::getRoles)
                .containsExactly(
                        firstName,
                        lastName,
                        email,
                        password,
                        new HashSet<>(Arrays.asList(createdFirstRole, createdSecondRole)));
    }
}
