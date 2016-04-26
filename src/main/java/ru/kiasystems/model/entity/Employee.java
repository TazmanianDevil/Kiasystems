package ru.kiasystems.model.entity;

import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import ru.kiasystems.model.entity.Department;
@Entity 
@Table(name="employees")
@NamedQueries({
@NamedQuery(name="Employee.findAll", query = "SELECT e FROM Employee e"),
@NamedQuery(name="Employee.findAllWithDetail", query = "SELECT DISTINCT e FROM Employee e LEFT JOIN FETCH e.department d LEFT JOIN FETCH e.user u"),
@NamedQuery(name="Employee.findById", query = "SELECT DISTINCT e FROM Employee e LEFT JOIN FETCH e.department d LEFT JOIN FETCH e.user u WHERE e.id=:id"),
@NamedQuery(name="Employee.findByLastName",query = "SELECT e FROM Employee e WHERE e.lastName=:lastName"),
@NamedQuery(name="Employee.findByFirstNameAndLastName", query = "SELECT e FROM Employee e WHERE e.firstName=" +
		":firstName AND e.lastName=:lastName"),
@NamedQuery(name="Employee.findAllByLastNameSimilarTo", query = "SELECT e FROM Employee e WHERE e.lastName LIKE :lastName")
		})
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Long id;
	
	@Column(name="first_name", nullable=false, length=30)
	private String firstName;
	
	@Column(name="last_name", nullable=false, length=30)
	private String lastName;
	
	@Column(name="father_name", length=30)
	private String fatherName;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="department_id")
	private  Department department;

	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private User user;

	public Employee(){}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	public String getFatherName() {
		return fatherName;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public String toString() {
		return String.format("Employee: [%d:%s %s %s]%n", getId(),
			getLastName(), getFirstName(), getFatherName());
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		if (getFirstName() != null ? !getFirstName().equals(employee.getFirstName()) : employee.getFirstName() != null)
			return false;
		if (getLastName() != null ? !getLastName().equals(employee.getLastName()) : employee.getLastName() != null)
			return false;
		return getFatherName() != null ? getFatherName().equals(employee.getFatherName()) : employee.getFatherName() == null;
	}

	@Override
	public int hashCode() {
		int result = getFirstName() != null ? getFirstName().hashCode() : 0;
		result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
		result = 31 * result + (getFatherName() != null ? getFatherName().hashCode() : 0);
		return result;
	}
}