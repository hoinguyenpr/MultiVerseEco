package com.ecommerce.admin.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserRestController {

    @Autowired
    UserService userService;

    // http://localhost:8081/MultiverseAdmin/api/users/check-email?email=davidanchor@code.edu.az
    @PostMapping("/is-duplicate-email")
    public boolean checkIsDuplicateEmail(@Param("id") Integer id, @Param("email") String email) {
        return !userService.isEmailUnique(id, email);
    }
}
