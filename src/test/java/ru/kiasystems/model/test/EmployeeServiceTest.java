package ru.kiasystems.model.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kiasystems.logic.spring.beans.dao.DepartmentService;
import ru.kiasystems.logic.spring.beans.dao.EmployeeService;
import ru.kiasystems.model.entity.Department;
import ru.kiasystems.model.entity.Employee;

import java.util.List;

import static org.junit.Assert.*;
public class EmployeeServiceTest {
    private ClassPathXmlApplicationContext context;
    private EmployeeService employeeService;
    private DepartmentService departmentService;
    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("META-INF/Spring/datasource-tx-jpa.xml");
        assertNotNull("Context cannot be null");
        employeeService = context.getBean("jpaEmployeeService", EmployeeService.class);
        assertNotNull("employeeService cannot be null", employeeService);
        departmentService = context.getBean("jpaDepartmentService", DepartmentService.class);
        assertNotNull("departmentService cannot be null", departmentService);
    }

    @Test
    public void testFindAll() {
        List<Employee> employees = employeeService.findAll();
        assertNotNull("Employee list cannot be null", employees);
        System.out.println(employees);
    }

    @Test
    public void testFindAllWithDetails() {
        List<Employee> employees = employeeService.findAllWithDetail();
        assertNotNull("Employee list cannot be null", employees);
        for (Employee employee :
                employees) {
            System.out.println(employee +" " + employee.getDepartment() + "   ");
        };
    }
    @Test
    public void testFindById() {
        Employee employee = employeeService.findById(1L);
        assertNotNull("employee cannot be null", employee);
        assertNotNull("Single employee department cannot be null", employee.getDepartment());
        System.out.println(employee + "   " + employee.getDepartment() + "  " + employee.getUser());
    }

    @Test
    public void testFindByLastName() {
        Employee employee = employeeService.fintByLastName("Рыжов");
        assertNotNull("Employee Рыжов cannot be null", employee);
    }

    @Test
    public void testFindByFirstNameAndLastName() {
        Employee employee = employeeService.findByFirstNameAndLastName("Максим", "Рыжов");
        assertNotNull("Employee Рыжов cannot be null", employee);
    }

    @Test
    public void testSaveMergeAndDelete() {
        System.out.println(employeeService.findAll());
        Employee employee = new Employee();
        employee.setFirstName("Test firstName");
        employee.setLastName("Test lastName");
        employee.setFatherName("Test FatherName");
        Department department = departmentService.findAll().get(0);
        employee.setDepartment(department);
        employeeService.save(employee);
        System.out.println(employeeService.findAll());
        assertNotNull("Persisted entity id cannot be null", employee.getId());
        System.out.println(employee);
        Employee newEmployee = employeeService.findById(employee.getId());
        newEmployee.setFirstName("Test firstName 2");
        newEmployee.setLastName("Test lastName 2");
        newEmployee.setFatherName("Test fatherName 2");
        employeeService.save(newEmployee);
        System.out.println(employeeService.findAll());
        employee = employeeService.findById(newEmployee.getId());
        assertEquals(employee.getFirstName(), newEmployee.getFirstName());
        System.out.println(employee);
        employeeService.delete(employee);
        System.out.println(employeeService.findAll());
    }
}
