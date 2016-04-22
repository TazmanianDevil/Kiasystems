package ru.kiasystems.logic.spring.beans.dao.impl;

import org.dom4j.tree.ElementQNameIterator;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kiasystems.logic.spring.beans.dao.EmployeeService;
import ru.kiasystems.model.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("jpaEmployeeService")
@Repository
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }

    @Override
    public Employee findById(Long id) {
        return em.createNamedQuery("Employee.findById", Employee.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Employee> fintByLastName(String lastName) {
        return em.createNamedQuery("Employee.findByLastName", Employee.class).setParameter("lastName",lastName).getResultList();
    }

    @Override
    public Employee findByFirstNameAndLastName(String firstName, String lastName) {
        return em.createNamedQuery("Employee.findByFirstNameAndLastName", Employee.class)
                .setParameter("firstName", firstName).setParameter("lastName", lastName).getSingleResult();
    }

    @Override
    public List<Employee> findByLastNameSimilarTo(String lastName) {
        return em.createNamedQuery("Employee.findAllByLastNameSimilarTo", Employee.class).setParameter("lastName", lastName).getResultList();
    }

    @Override
    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            em.persist(employee);
        } else {
            em.merge(employee);
        }
        return employee;
    }

    @Override
    public void delete(Employee employee) {
        em.remove(em.contains(employee)?employee:em.merge(employee));
    }

    @Override
    public void delete(Long id) {
        em.remove(findById(id));
    }
}
