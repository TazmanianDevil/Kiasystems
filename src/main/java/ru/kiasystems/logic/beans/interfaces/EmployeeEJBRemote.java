package ru.kiasystems.logic.beans.interfaces;

import ru.kiasystems.model.entity.Employee;

import java.util.List;

public interface EmployeeEJBRemote {
    String getName();
    List<Employee> getAllEmployees();
    void addEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
