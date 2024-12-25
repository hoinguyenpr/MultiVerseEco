package com.ecommerce.admin.controller;

import com.ecommerce.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    RoleService roleService;

    @GetMapping("/welcome")
    public String viewHomePage() {
        return "";
    }

}
