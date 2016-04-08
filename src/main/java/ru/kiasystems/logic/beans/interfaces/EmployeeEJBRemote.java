package ru.kiasystems.logic.beans.interfaces;

import ru.kiasystems.model.entity.Employee;

import java.util.List;

/**
 * Created by User on 15.03.2016.
 */
public interface EmployeeEJBRemote {
    String getName();
    List<Employee> getAllEmployees();
    void addEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
