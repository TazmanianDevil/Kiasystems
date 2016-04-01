package ru.kiasystems.model.test;

import ru.kiasystems.model.entity.User;
import ru.kiasystems.model.entity.Role;
import ru.kiasystems.logic.beans.impl.UserEJB;
import ru.kiasystems.logic.beans.impl.RoleEJB;

import org.junit.Test;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.List;

public class UserRoleEJBIT {
	UserEJB userEJB;
	RoleEJB roleEJB;
	@Test
	public  void testUserRole() throws Exception {
		try (EJBContainer ejbContainer = EJBContainer.createEJBContainer()){
			Context ctx = ejbContainer.getContext();
			userEJB = (UserEJB)ctx.lookup("java:global/ejb-app/classes/UserEJB!ru.kiasystems.logic.beans.impl.UserEJB");
			roleEJB = (RoleEJB)ctx.lookup("java:global/ejb-app/classes/RoleEJB!ru.kiasystems.logic.beans.impl.RoleEJB");
			List<User> users = userEJB.getAllUsers();
			for (User user: users) {
				System.out.println(user);
				System.out.println(user.getRoles());
			}
			List<Role> roles = roleEJB.getAllRoles();
			for (Role role: roles) {
				System.out.println(role);
				System.out.println(role.getUsers());
			}
			
			User user = new User();
			user.setId(3);
			user.setUsername("Pavel");
			user.setPassword("Shestakov");
			user.setRoles(roles);
			userEJB.addUser(user);
			
		} 
	}
}
