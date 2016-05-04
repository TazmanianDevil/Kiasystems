package ru.kiasystems.logic.spring.beans.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kiasystems.logic.spring.beans.dao.DepartmentService;
import ru.kiasystems.model.entity.Department;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("jpaDepartmentService")
@Repository
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Department> findAll() {
        List<Department> departments = em.createNamedQuery("Department.findAll", Department.class).getResultList();
        return departments;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Department> findAllWithDetail() {
        List<Department> departments = em.createNamedQuery("Department.findAllWithDetail", Department.class).getResultList();
        return departments;
    }

    @Override
    @Transactional(readOnly = true)
    public Department findById(Long id) {
        Department department = em.createNamedQuery("Department.findById", Department.class).setParameter("id", id).getSingleResult();
        department.getEmployees().size();
        return department;
    }

    @Override
    @Transactional(readOnly = true)
    public Department findByTitle(String title) {
        List<Department> departments = em.createNamedQuery("Department.findByTitle", Department.class).setParameter("title", title).getResultList();
        if (departments.isEmpty())
            return null;
        else
            return departments.get(0);
    }

    @Override
    @Transactional(readOnly = true)
    public Department findByAbbreviation(String abbreviation) {
        Department department = em.createNamedQuery("Department.findByAbbreviation", Department.class).setParameter("abbreviation", abbreviation).getSingleResult();
        return department;
    }

    @Override
    public Department save(Department department) {
        if (department.getId() == null) {
            em.persist(department);
        } else {
            em.merge(department);
        }
        return department;
    }

    @Override
    public void delete(Department department) {
        em.remove(em.contains(department)?department:em.merge(department));
    }

    @Override
    public void delete(Long id) {
        delete(findById(id));
    }
}
