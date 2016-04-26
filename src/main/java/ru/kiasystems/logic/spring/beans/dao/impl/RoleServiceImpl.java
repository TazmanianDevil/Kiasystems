package ru.kiasystems.logic.spring.beans.dao.impl;

import org.hibernate.annotations.common.util.impl.Log;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kiasystems.logic.spring.beans.dao.RoleService;
import ru.kiasystems.model.entity.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("jpaRoleService")
@Repository
@Transactional
public class RoleServiceImpl implements RoleService {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Role> findAll() {
        return em.createNamedQuery("Role.findAll", Role.class).getResultList();
    }

    @Override
    public List<Role> findWithDetail() {
        return em.createNamedQuery("Role.findAllWithDetail", Role.class).getResultList();
    }

    @Override
    public Role findById(Long id) {
        return em.createNamedQuery("Role.findById", Role.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public Role findByRoleName(String roleName) {
        return em.createNamedQuery("Role.findByRoleName", Role.class).setParameter("roleName", roleName).getSingleResult();
    }

    @Override
    public Role save(Role role) {
        if (role.getId() == null) {
            em.persist(role);
        } else {
            em.merge(role);
        }
        return role;
    }

    @Override
    public void delete(Role role) {
        em.remove(em.contains(role)?role:em.merge(role));
    }

    @Override
    public void delete(Long id) {
        delete(findById(id));
    }
}
