package ru.kiasystems.logic.spring.beans.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kiasystems.logic.spring.beans.dao.UserService;
import ru.kiasystems.model.entity.User;
import ru.kiasystems.model.entity.User_;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Service("jpaUserService")
@Repository
@Transactional
public class UserServiceImpl implements UserService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }

    @Override
    public List<User> findAllWithDetail() {
        return em.createNamedQuery("User.findAllWithDetail", User.class).getResultList();
    }

    @Override
    public User findById(Long id) {
        return em.createNamedQuery("User.findById", User.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public User findByUsername(String userName) {
        return em.createNamedQuery("User.findByUserName", User.class).setParameter("userName", userName).getSingleResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findByUserNameSimilarTo(String userName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);
        userRoot.fetch(User_.roles, JoinType.LEFT);
        criteriaQuery.select(userRoot).distinct(true);
        Predicate criteria = cb.conjunction();
//        Predicate p = cb.like(userRoot.get(User_.userName), userName);

        Expression<String> literal = cb.upper(cb.literal((String) userName));
        Predicate p = cb.like(cb.upper(userRoot.get(User_.userName)), literal);
        criteria = cb.and(criteria, p);
        criteriaQuery.where(criteria);
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            em.persist(user);
        } else {
            em.merge(user);
        }
        return user;
    }

    @Override
    public void delete(User user) {
        em.remove(em.contains(user)?user:em.merge(user));
    }

    @Override
    public void delete(Long id) {
        em.remove(findById(id));
    }
}
