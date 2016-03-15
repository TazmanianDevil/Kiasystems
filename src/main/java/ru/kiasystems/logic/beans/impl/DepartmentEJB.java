package ru.kiasystems.logic.beans.impl;

import ru.kiasystems.logic.beans.interfaces.DepartmentEJBRemote;
import ru.kiasystems.logic.beans.interfaces.ThemeEJBRemote;
import ru.kiasystems.model.entity.Department;
import ru.kiasystems.model.entity.Theme;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class DepartmentEJB implements DepartmentEJBRemote {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments =null;
        if (entityManager!=null) {
            TypedQuery<Department> namedQuery = entityManager.createNamedQuery("Department.getAllDepartments", Department.class);
            departments = namedQuery.getResultList();
        }
        return departments;
    }
    @Override
    public String getName() {
        return this.getClass().getName();
    }
    @Override
    public void addDepartment(Department d3epartment) {
        entityManager.persist(d3epartment);
    }
    @Override
    public Department getDepartmentById(int id) {
        return entityManager.find(Department.class, id);
    }
    @Override
    public Department updateDepartment(Department department) {
        department = entityManager.merge(department);
        return department;
    }
    @Override
    public void deleteDepartment(Department department) {
        entityManager.remove(entityManager.contains(department)?department:entityManager.merge(department));
    }
}
