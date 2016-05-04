package ru.kiasystems.model.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.kiasystems.logic.spring.beans.dao.RoleService;
import ru.kiasystems.model.entity.Role;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RoleServiceTest {
    private GenericXmlApplicationContext context;
    private RoleService roleService;
    @Before
    public void setUp() {
        context = new GenericXmlApplicationContext("META-INF/Spring/datasource-tx-jpa.xml");
        assertNotNull("Context cannot be null", context);
        roleService = context.getBean("jpaRoleService", RoleService.class);
        assertNotNull("RoleService cannot be null", roleService);
    }

    @Test
    public void testFindAll() {
        System.out.println("<----------------FIND ALL ROLES ------------------->");
        List<Role> roles = roleService.findAll();
        assertNotNull("Role's list cannot be null", roles);
        System.out.println(roles);
    }

    @Test
    public void testFindAllWithDetail() {
        System.out.println("<------------ FIND ALL ROLES WITH DETAIL ----------->");
        List<Role> roles = roleService.findWithDetail();
        assertNotNull("Role's list cannot be null", roles);
        for (Role role :
                roles) {
            System.out.println(role);
            assertNotNull("Role user's list cannot be null", role.getUsers());
            System.out.println(role.getUsers());
        }
    }

    @Test
    public void testFindById() {
        System.out.println("<--------------FIND ROLE WITH id 1 ------------------->");
        Role role = roleService.findById(1L);
        assertNotNull("Role presents in databse", role);
        System.out.println(role);
        assertNotNull(role.getUsers());
        System.out.println(role.getUsers());
    }

    @Test
    public void testFindByRoleName() {
        System.out.println("<-----------FIND ROLE WITH NAME Constructor ---------------->");
        Role role = roleService.findByRoleName("Constructor");
        assertNotNull("Constructor role presents in databse", role);
        System.out.println(role);
    }

    @Test
    public void testSaveUpdateAndDeleteWithoutUsers() {
        System.out.println("<---------------- SAVE, UPDATE AND DELETE ROLE ------------->");
        System.out.println(roleService.findAll());
        Role role = new Role("Test role", "Test description");
        roleService.save(role);
        assertNotNull("Persisted role id cannot be null", role.getId());
        System.out.println(roleService.findAll());
        Role newRole = roleService.findById(role.getId());
        assertNotNull(newRole);
        newRole.setName("Test role 2");
        newRole.setDescription("Test description 2");
        roleService.save(newRole);
        role = roleService.findById(role.getId());
        assertEquals(role.getId(), newRole.getId());
        assertEquals(role.getName(), newRole.getName());
        assertEquals(role.getDescription(), newRole.getDescription());
        System.out.println(roleService.findAll());
        roleService.delete(role);
        System.out.println(roleService.findAll());
    }
}
