package ru.kiasystems.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="departments")
@NamedQueries({
@NamedQuery(name="Department.findAll", query = "SELECT d FROM Department d"),
@NamedQuery(name="Department.findById", query = "SELECT DISTINCT d FROM Department d WHERE d.id=:id"),
@NamedQuery(name="Department.findAllWithDetail", query = "SELECT DISTINCT d FROM Department d LEFT JOIN FETCH " +
        "d.employees e"),
@NamedQuery(name="Department.findByTitle", query = "SELECT d FROM Department d WHERE d.title=:title"),
@NamedQuery(name="Department.findByAbbreviation", query = "SELECT d FROM Department d WHERE d.abbreviation=:abbreviation")
}
)
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="department_id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="abbreviation")
    private String abbreviation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    public Department(){
        employees = new HashSet<>();
    }
    public Department(String title, String abbreviation) {
        this.title = title;
        this.abbreviation = abbreviation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employee.setDepartment(this);
        getEmployees().add(employee);
    }

    public void removeEmployee(Employee employee) {
        getEmployees().remove(employee);
    }

    public String toString () {
        return String.format("Department: [%d:%s:%s]%n",id, title, abbreviation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null) return false;
        return getAbbreviation() != null ? getAbbreviation().equals(that.getAbbreviation()) : that.getAbbreviation() == null;

    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getAbbreviation() != null ? getAbbreviation().hashCode() : 0);
        return result;
    }
}
