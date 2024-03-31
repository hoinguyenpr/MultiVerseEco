package com.ecommerce.admin.controller;

import com.common.entity.Role;
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
//        List<Role> roleList = roleService.searchAllRole();
//        roleList.forEach(role -> System.out.println(role.toString()));
        Role roleTest = roleService.getRole(1);
        System.out.println("Hello");
        System.out.println(roleTest.getName());
        System.out.println(roleTest.getDescription());
        return "index";
    }

}
