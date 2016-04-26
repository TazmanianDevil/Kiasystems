package ru.kiasystems.logic.spring.beans.dao;

import ru.kiasystems.model.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    List<Role> findWithDetail();
    Role findById(Long ids);
    Role findByRoleName(String roleName);
    Role save(Role role);
    void delete(Role role);
    void delete(Long id);
}
