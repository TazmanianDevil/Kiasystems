package ru.kiasystems.logic.spring.beans.dao;

import ru.kiasystems.model.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
    List<Department> findAllWithDetail();
    Department findById(Long id);
    Department findByTitle(String title);
    Department findByAbbreviation(String abbreviation);
    Department save(Department department);
    void delete(Department department);
    void delete (Long id);
}
