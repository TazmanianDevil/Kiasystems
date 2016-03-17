package ru.kiasystems.model.test;

import org.junit.Test;
import ru.kiasystems.logic.beans.impl.DepartmentEJB;
import ru.kiasystems.model.entity.Department;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class DepartmentEJBIT {
    DepartmentEJB departmentEJB;
    @Test
    public void shouldCreate() throws Exception {
        try (EJBContainer ec = EJBContainer.createEJBContainer()) {
            Context ctx = ec.getContext();
            DepartmentEJB departmentEJB = (DepartmentEJB)ctx.lookup("java:global/ejb-app/classes/DepartmentEJB!ru.kiasystems.logic.beans.impl.DepartmentEJB");
            List<Department> departments = departmentEJB.getAllDepartments();
            assertNotNull("Department list cannot be null for test DB", departments);
            Department department = new Department("Test lab", "TL");
            departmentEJB.addDepartment(department);
            //Persist department to the database
            assertNotNull("Id can not be null", department.getId());
            // Check all departments and sure there is an extra one
            assertEquals(departments.size()+1, departmentEJB.getAllDepartments().size());
            Department department1 = departmentEJB.getDepartmentById(department.getId());
            assertNotNull("Received department not null", department1);
            departmentEJB.deleteDepartment(department);
            assertEquals(departments.size(), departmentEJB.getAllDepartments().size());

            for (Department dept: departments) {
                dept.getEmployees().size();
                System.out.println(dept.getEmployees());
            }
        }
    }
}
