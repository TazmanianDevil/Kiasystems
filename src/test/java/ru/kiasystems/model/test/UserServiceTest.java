package ru.kiasystems.model.test;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kiasystems.logic.spring.beans.dao.UserService;
import ru.kiasystems.model.entity.User;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserServiceTest {
    private ClassPathXmlApplicationContext context;
    private UserService userService;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("META-INF/Spring/datasource-tx-jpa.xml");
        assertNotNull("Context cannot be null", context);
        userService = context.getBean("jpaUserService", UserService.class);
        assertNotNull("UserService cannot be null");
    }

    @Test
    public void testFindAll() {
        System.out.println("<------------------- FIND ALL USERS ------------------>");
        List<User> users = userService.findAll();
        assertNotNull("User's list cannot be null", users);
        System.out.println(users);
    }

    @Test
    public void testFindAllWithDetail() {
        System.out.println("<--------------- FIND ALL USERS WITH ROLE DETAILS --------------->");
        List<User> users = userService.findAllWithDetail();
        assertNotNull("User's list cannot be null", users);
        for (User user :
                users) {
            assertNotNull("User roles cannot be null", user.getRoles());
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }

    @Test
    public void testFindById() {
        System.out.println("<-------------- FIND ADMIN USER BY ID ------------->");
        User user = userService.findById(1L);
        assertNotNull("Admin user presents in database", user);
        System.out.println(user);
        System.out.println(user.getRoles());
    }

    @Test
    public void testFindByUserName() {
        System.out.println("<--------------FIND USER WITH USERNAME andrievskij ------------------>");
        User user = userService.findByUsername("andrievskij");
        assertNotNull("Andrievkij presents in database", user);
        System.out.println(user);
        System.out.println(user.getRoles());
    }

    @Test
    public void testFindByUserNameSimilarTo() {
        System.out.println("<-------------- FIND USERS WITH USERNAME SIMILAR TO a");
        List<User> users = userService.findByUserNameSimilarTo("%a%");
        assertNotNull("users list cannot be null", users);
        for (User user :
                users) {
            System.out.println(user);
            System.out.println(user.getRoles());
        }
   }

    @Test
    public void testSaveUpdateAndDeleteUser() {
        System.out.println("<------------------ SAVE, UPDATE AND DELETE TEST USERNAME");
        System.out.println(userService.findAll());
        User user = new User(1L, "Test userName", "Test password");
        userService.save(user);
        System.out.println(userService.findAll());
        assertNotNull("Persisted entity's id cannot be null", user.getId());
        User newUser = userService.findById(user.getId());
        newUser.setUsername("Test userName 2");
        newUser.setPassword("Test password 2");
        userService.save(newUser);
        System.out.println(userService.findAll());
        user = userService.findById(newUser.getId());
        assertEquals(user.getId(), newUser.getId());
        assertEquals(user.getUsername(), newUser.getUsername());
        userService.delete(user);
        System.out.println(userService.findAll());


    }
}
