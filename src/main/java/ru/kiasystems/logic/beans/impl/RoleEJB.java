package ru.kiasystems.logic.beans.impl;

import ru.kiasystems.logic.beans.interfaces.RoleEJBRemote;
import ru.kiasystems.model.entity.Role;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class RoleEJB implements RoleEJBRemote {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Role> getAllRoles() {
        List<Role> roles =null;
        if (entityManager!=null) {
            TypedQuery<Role> namedQuery = entityManager.createNamedQuery("Role.getAllRoles", Role.class);
            roles = namedQuery.getResultList();
        }
        return roles;
    }
    @Override
    public String getName() {
        return this.getClass().getName();
    }
    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }
    @Override
    public Role getRoleById(int id) {
        return entityManager.find(Role.class, id);
    }
    @Override
    public Role updateRole(Role role) {
        role = entityManager.merge(role);
        return role;
    }
    @Override
    public void deleteRole(Role role) {
        entityManager.remove(entityManager.contains(role)?role:entityManager.merge(role));
    }
}
