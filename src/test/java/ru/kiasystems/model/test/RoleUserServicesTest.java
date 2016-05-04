package ru.kiasystems.model.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.kiasystems.logic.spring.beans.dao.RoleService;
import ru.kiasystems.logic.spring.beans.dao.UserService;
import ru.kiasystems.model.entity.Role;
import ru.kiasystems.model.entity.User;

import static org.junit.Assert.assertNotNull;

/**
 * Created by User on 24.04.2016.
 */
public class RoleUserServicesTest {
    private GenericXmlApplicationContext context;
    private RoleService roleService;
    private UserService userService;

    @Before
    public void setUp() {
        context = new GenericXmlApplicationContext("META-INF/Spring/datasource-tx-jpa.xml");
        assertNotNull(context);
        roleService = context.getBean("jpaRoleService", RoleService.class);
        assertNotNull(roleService);
        userService = context.getBean("jpaUserService", UserService.class);
        assertNotNull(userService);
    }

    @Test
    public void testaddNewUserWithNewRole() {
        System.out.println("<---------- ADD USER WITH NEW ROLE ------------->");
        System.out.println(roleService.findAll());
        System.out.println(userService.findAll());
        Role role = new Role("Test role", "Test description");
        roleService.save(role);
        assertNotNull(role.getId());
        User user = new User(1L, "Test user", "Test password");
        user.getRoles().add(role);
        userService.save(user);
        assertNotNull(user.getId());
        System.out.println(roleService.findAll());
        System.out.println(userService.findAll());
        userService.delete(user);
        roleService.delete(role);
        System.out.println(roleService.findAll());
        System.out.println(userService.findAll());
    }

    @Test
    public void testaddNewRoleWithNewUser() {
        System.out.println("<---------- ADD USER WITH NEW ROLE ------------->");
        System.out.println(roleService.findAll());
        System.out.println(userService.findAll());
        User user = new User(1L, "Test user", "Test password");
        userService.save(user);
        assertNotNull(user.getId());
        Role role = new Role("Test role", "Test description");
        role.getUsers().add(user);
        roleService.save(role);
        System.out.println(roleService.findAll());
        System.out.println(userService.findAll());
        userService.delete(user);
        role = roleService.findById(role.getId());
        System.out.println(role);
        System.out.println(role.getUsers());
        roleService.delete(role);

//        System.out.println(roleService.findAll());
//        System.out.println(userService.findAll());
    }
}
