package ru.kiasystems.model.EJBITTest;

import org.junit.Test;
import ru.kiasystems.logic.beans.impl.RoleEJB;
import ru.kiasystems.logic.beans.impl.UserEJB;
import ru.kiasystems.model.entity.Role;
import ru.kiasystems.model.entity.User;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class UserEJBIT {
/*    UserEJB userEJB;
    RoleEJB roleEJB;
    @Test
    public void shouldCreate() throws Exception {
        /*try (EJBContainer ec = EJBContainer.createEJBContainer()) {
            Context ctx = ec.getContext();
            UserEJB userEJB = (UserEJB)ctx.lookup("java:global/ejb-app/classes/UserEJB!ru.kiasystems.logic.beans.impl.UserEJB");
            RoleEJB roleEJB = (RoleEJB)ctx.lookup("java:global/ejb-app/classes/RoleEJB!ru.kiasystems.logic.beans.impl.RoleEJB");
            List<User> users = null;
            users = userEJB.getAllUsers();
            System.out.println("<----------------------------------- UserEJBIT ------------------------------->");
            System.out.println(users);
            assertNotNull("User list cannot be null for test DB", users);
            User user = new User();
            // Задаем поля для User
            user.setId(new Long(3));
            user.setUsername("Pavel");
            user.setPassword("Shestakov");
            Set<Role> roles = roleEJB.getAllRoles();
            user.setRoles(roles);
            userEJB.addUser(user);
            //Persist user to the database
            assertNotNull("Id can not be null", user.getId());
//             Check all users and sure there is an extra one
            assertEquals(users.size()+1, userEJB.getAllUsers().size());
            User user1 = userEJB.getUserById(new Long(3));
            assertNotNull("Received user not null", user1.getId());
            //user1.setRoles(null);
            userEJB.deleteUser(user1);
            assertEquals(users.size(), userEJB.getAllUsers().size());
        }
    }*/
}
