package ru.kiasystems.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="departments")
@NamedQuery(name="Department.getAllDepartments", query = "SELECT d FROM Department d")
public class Department implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="department_id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="abbreviation")
    private String abbreviation;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
    private Set<Employee> employees;

    public Department(){}
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
    public String toString () {
        return String.format("Theme: [%d:%s:%s]",id, title, abbreviation);
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || !(obj instanceof Department))
            return false;
        Department dept = (Department)obj;
        return dept.getTitle() == this.getTitle() &&
                dept.getAbbreviation() == this.getAbbreviation();
    }
	
	
}
