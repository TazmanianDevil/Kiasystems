package ru.kiasystems.model.test;

import org.junit.Test;
import ru.kiasystems.logic.beans.impl.DepartmentEJB;
import ru.kiasystems.logic.beans.impl.EmployeeEJB;
import ru.kiasystems.model.entity.Department;
import ru.kiasystems.model.entity.Employee;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class EmployeeEJBIT {
    EmployeeEJB employeeEJB;
    DepartmentEJB departmentEJB;
    @Test
    public void shouldCreate() throws Exception {
        try (EJBContainer ec = EJBContainer.createEJBContainer()) {
            Context ctx = ec.getContext();
            EmployeeEJB employeeEJB = (EmployeeEJB)ctx.lookup("java:global/ejb-app/classes/EmployeeEJB!ru.kiasystems.logic.beans.impl.EmployeeEJB");
            DepartmentEJB  departmentEJB = (DepartmentEJB)ctx.lookup("java:global/ejb-app/classes/DepartmentEJB!ru.kiasystems.logic.beans.impl.DepartmentEJB");
            List<Employee> employees = employeeEJB.getAllEmployees();
            System.out.println("<----------------------------------EmployeeEJBIT--------------------------->");
            System.out.println(employees);
            assertNotNull("Employee list cannot be null for test DB", employees);
            Employee employee = new Employee();
            employee.setFirstName("Kuzin");
            employee.setLastName("Kuzin");
            Department department = departmentEJB.getDepartmentById(2);
            employee.setDepartment(department);
            // Задаем поля для сотрудника
            employeeEJB.addEmployee(employee);
            //Persist employee to the database
            assertNotNull("Id can not be null", employee.getId());
//             Check all employees and sure there is an extra one
            assertEquals(employees.size()+1, employeeEJB.getAllEmployees().size());
            Employee employee1 = employeeEJB.getEmployeeById(employee.getId());
            assertNotNull("Received employee not null", employee1);
            employeeEJB.deleteEmployee(employee);
            assertEquals(employees.size(), employeeEJB.getAllEmployees().size());
        }
    }
}
