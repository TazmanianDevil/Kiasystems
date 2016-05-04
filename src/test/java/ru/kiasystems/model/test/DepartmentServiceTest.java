package ru.kiasystems.model.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kiasystems.logic.spring.beans.dao.DepartmentService;
import ru.kiasystems.model.entity.Department;
import ru.kiasystems.model.entity.Employee;

import java.util.List;

import static org.junit.Assert.*;

public class DepartmentServiceTest {
    private ClassPathXmlApplicationContext context;
    private DepartmentService departmentService;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("META-INF/Spring/datasource-tx-jpa.xml");
        assertNotNull("Context cannot be null", context);
        departmentService = context.getBean("jpaDepartmentService", DepartmentService.class);
        assertNotNull("departmentService cannot be null", departmentService);
    }

    @Test
    public void testFindAll() {
        System.out.println("<---------------- FIND ALL DEPARTMENTS --------------->");
        List<Department> departments = departmentService.findAll();
        assertNotNull("departments cannot be null", departments);
        System.out.println(departments);
    }

    @Test
    public void testFindAllWithDetail() {
        System.out.println("<------------------FIND ALL WITH DETAIL ------------->");
        List<Department> departments = departmentService.findAllWithDetail();
        assertNotNull("departments cannot be null", departments);
        for (Department department :
                departments) {
            System.out.println(department);
            assertNotNull("Employees list cannot be null", department.getEmployees());
            System.out.println(department.getEmployees());
        }
    }

    @Test
    public void testFindById() {
        System.out.println("<------------------- FIND DEPARTMENT WITH id=1 --------------------->");
        Department department = departmentService.findById(1L);
        assertNotNull("Department cannot be null", department);
        System.out.println(department);
        assertNotNull("Department employees list cannot be null", department.getEmployees());
        System.out.println(department.getEmployees());
    }

    @Test
    public void testSaveUpdateAndDeleteDepartment() {
        System.out.println("<------------------ SAVE AND DELETE DEPARTMENT");
        System.out.println(departmentService.findAll());
        Department department = new Department();
        department.setTitle("Бухгалтерский отдел");
        department.setAbbreviation("БО");
        int departmentCount = departmentService.findAll().size();
        departmentService.save(department);
        assertNotNull("Persisted entity's id cannot be null", department.getId());
        System.out.println(departmentService.findAll());
        Department newDepartment = departmentService.findById(department.getId());
        assertNotNull(newDepartment.getId());
        newDepartment.setTitle("Юридический отдел");
        newDepartment.setAbbreviation("ЮО");
        newDepartment=departmentService.save(newDepartment);
        System.out.println(departmentService.findAll());
        department = departmentService.findById(department.getId());
        assertEquals("Юридический отдел", department.getTitle());
        assertEquals("ЮО", department.getAbbreviation());
        departmentService.delete(department);
        assertEquals(departmentCount, departmentService.findAll().size());
        System.out.println(departmentService.findAll());
    }

    @Test
    public void testFindByTitle() {
        System.out.println("<-------------------- FIND CONSTRUCTOR'S SECTOR ------------------>");
        Department department = departmentService.findByTitle("%Construct%");
        assertNotNull("Constructor's sector cannot be null", department);
        System.out.println(department);
        department = departmentService.findByTitle("%Кра%");
        assertNull("Cannot find such sector", department);
    }

    @Test
    public void testFindByAbbreviation() {
        System.out.println("<--------------------FIND LSUAK -------------------->");
        Department department = departmentService.findByAbbreviation("%ЛСУА%");
        assertNotNull("LSUAK cannot be null", department);
        System.out.println(department);
        department = departmentService.findByAbbreviation("%ЫЫ%");
        assertNull("Cannot find ЫЫ abbreviation", department);
    }

    @Test
    public void testAddDepartmentWithEmployees() {
        Department department = new Department();
        department.setTitle("Бухгалтерия");
        department.setAbbreviation("Бухи");
        Employee employee = new Employee();
        employee.setFirstName("Иван");
        employee.setLastName("Иванов");
        employee.setFatherName("Иванович");
        department.addEmployee(employee);
        employee = new Employee();
        employee.setFirstName("Петр");
        employee.setLastName("Петров");
        employee.setFatherName("Петрович");
        department.addEmployee(employee);
        departmentService.save(department);
        assertNotNull("Id cannot be null", department.getId());
        System.out.println(departmentService.findAll());
        System.out.println(departmentService.findById(department.getId()).getEmployees());
        departmentService.delete(department);
        System.out.println(departmentService.findAll());


    }
}
