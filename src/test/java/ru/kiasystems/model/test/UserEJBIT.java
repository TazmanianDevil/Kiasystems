package ru.kiasystems.model.test;

import org.junit.Test;
import ru.kiasystems.logic.beans.impl.UserEJB;
import ru.kiasystems.model.entity.User;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.List;

import static org.junit.Assert.assertNotNull;


public class UserEJBIT {
    UserEJB userEJB;
    @Test
    public void shouldCreate() throws Exception {
        try (EJBContainer ec = EJBContainer.createEJBContainer()) {
            Context ctx = ec.getContext();
            UserEJB userEJB = (UserEJB)ctx.lookup("java:global/ejb-app/classes/UserEJB!ru.kiasystems.logic.beans.impl.UserEJB");
            List<User> users = userEJB.getAllUsers();
            System.out.println(users);
            assertNotNull("User list cannot be null for test DB", users);
//            User user = new User();
//            userEJB.addUser(user);
//            //Persist user to the database
//            assertNotNull("Id can not be null", user.getId());
            // Check all users and sure there is an extra one
//            assertEquals(users.size()+1, userEJB.getAllUsers().size());
//            User user1 = userEJB.getUserById(user.getId());
//            assertNotNull("Received user not null", user1);
//            userEJB.deleteUser(user);
//            assertEquals(users.size(), userEJB.getAllUsers().size());
        }
    }
}
