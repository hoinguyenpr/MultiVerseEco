package com.ecommerce.admin.user;

import com.ecommerce.admin.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testIsExistingEmail() {
        String email = TestUtils.generateText(5) + "@gmail.com";
        when(userRepository.findByEmail(email)).thenReturn(TestUtils.mockUser());
        assertFalse(userService.isEmailUnique(null, email));
    }

    @Test
    public void testIsNotExistingEmail() {
        String email = TestUtils.generateText(5) + "@gmail.com";
        when(userRepository.findByEmail(email)).thenReturn(null);
        assertTrue(userService.isEmailUnique(null, email));
    }
}
