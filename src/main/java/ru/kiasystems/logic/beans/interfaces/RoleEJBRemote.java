package ru.kiasystems.logic.beans.interfaces;

import ru.kiasystems.model.entity.Role;

import java.util.List;

public interface RoleEJBRemote {
    String getName();
    List<Role> getAllRoles();
    void addRole(Role theme);
    Role getRoleById(int id);
    Role updateRole(Role theme);
    void deleteRole(Role theme);
}
