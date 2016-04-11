package ru.kiasystems.model.test;

import org.junit.Test;
import ru.kiasystems.logic.beans.impl.RoleEJB;
import ru.kiasystems.model.entity.Role;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


    public class RoleEJBIT {
    RoleEJB roleEJB;
    @Test
    public void shouldCreate() throws Exception {
        try (EJBContainer ec = EJBContainer.createEJBContainer()) {
            Context ctx = ec.getContext();
            RoleEJB roleEJB = (RoleEJB)ctx.lookup("java:global/ejb-app/classes/RoleEJB!ru.kiasystems.logic.beans.impl.RoleEJB");
            List<Role> roles = roleEJB.getAllRoles();
            assertNotNull("Role list cannot be null for test DB", roles);
            System.out.println("<------------------------------------ RoleEJBIT --------------------------------->");
            System.out.println(roles);
            Role role = new Role();
            role.setName("Test Role");
            role.setDescription("Test description");
            roleEJB.addRole(role);
            //Persist role to the database
            assertNotNull("Id can not be null", role.getId());
            // Check all roles and sure there is an extra one
            assertEquals(roles.size()+1, roleEJB.getAllRoles().size());
            Role role1 = roleEJB.getRoleById(role.getId());
            assertNotNull("Received role not null", role1);
            roleEJB.deleteRole(role);
            assertEquals(roles.size(), roleEJB.getAllRoles().size());
        }
    }
}
