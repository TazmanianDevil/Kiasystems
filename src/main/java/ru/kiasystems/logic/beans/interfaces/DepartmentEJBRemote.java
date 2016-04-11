package ru.kiasystems.logic.beans.interfaces;

import ru.kiasystems.model.entity.Department;
import ru.kiasystems.model.entity.Theme;

import java.util.List;

public interface DepartmentEJBRemote {
    String getName();
    List<Department> getAllDepartments();
    void addDepartment(Department department);
    Department getDepartmentById(Long id);
    Department updateDepartment(Department department);
    void deleteDepartment(Department department);
}
