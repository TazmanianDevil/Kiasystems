package ru.kiasystems.logic.beans.impl;

import ru.kiasystems.logic.beans.interfaces.EmployeeEJBRemote;
import ru.kiasystems.logic.beans.interfaces.EmployeeEJBRemote;
import ru.kiasystems.model.entity.Employee;
import ru.kiasystems.model.entity.Employee;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class EmployeeEJB implements EmployeeEJBRemote {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees =null;
        if (entityManager!=null) {
            TypedQuery<Employee> namedQuery = entityManager.createNamedQuery("Employee.getAllEmployees", Employee.class);
            employees = namedQuery.getResultList();
        }
        return employees;
    }
    @Override
    public String getName() {
        return this.getClass().getName();
    }
    @Override
    public void addEmployee(Employee theme) {
        entityManager.persist(theme);
    }
    @Override
    public Employee getEmployeeById(int id) {
        return entityManager.find(Employee.class, id);
    }
    @Override
    public Employee updateEmployee(Employee theme) {
        theme = entityManager.merge(theme);
        return theme;
    }
    @Override
    public void deleteEmployee(Employee theme) {
        entityManager.remove(entityManager.contains(theme)?theme:entityManager.merge(theme));
    }
}
