package com.ecommerce.admin.user;

import com.ecommerce.admin.utils.TestUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
    @Test
    public void testEncodePassword() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passWord = TestUtils.generateText(10);
        String encodedPassword = passwordEncoder.encode(passWord);
        Assertions.assertThat(passwordEncoder.matches(passWord, encodedPassword)).isTrue();
    }
}
