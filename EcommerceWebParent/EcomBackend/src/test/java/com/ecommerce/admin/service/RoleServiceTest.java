package com.ecommerce.admin.service;

import com.common.entity.Role;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    RoleService roleService;

    @Test
    public void testGetRoleSuccessful() {
        when(roleService.getRole(1)).thenReturn(new Role(1, "Lan", "so beautiful"));
        assertEquals(new Role(1, "Lan", "so beautiful"), roleService.getRole(1));
    }
}
