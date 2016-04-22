package ru.kiasystems.logic.spring.beans.dao;

import ru.kiasystems.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Long id);
    List<Employee> fintByLastName(String lastName);
    Employee findByFirstNameAndLastName(String firstName, String lastName);
    List<Employee> findByLastNameSimilarTo(String lastName);
    Employee save(Employee employee);
    void delete(Employee employee);
    void delete(Long id);
}
