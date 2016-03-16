package ru.kiasystems.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import ru.kiasystems.model.entity.Department;
@Entity 
@Table(name="employees")
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="employee_id")
	private Integer id;
	
	@Column(name="first_name", nullable=false, length=30)
	private String firstName;
	
	@Column(name="last_name", nullable=false, length=30)
	private String lastName;
	
	@Column(name="father_name", length=30)
	private String fatherName;
	
	@OneToOne
	@JoinColumn(name="department_id")
	private  Department department;
	
	public Employee(){}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFristName() {
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
		return String.format("Employee: [%d:%s %s %s:%s]", getId(), 
			getSecondName(), getFristName(), getLastName(), getDepartment().getTitle());
	}
	
	@Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (fatherName != null ? fatherName.hashCode() : 0);
        return result;
    }
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || !(obj instanceof Employee)) 
			return false;
		Employee emp = (Employee)obj;
		if (!firstName.equals(emp.getFirstName())) return false;
		if (!lastName.equals(emp.getLastName())) return false;
		if (fatherName!=null && emp.getFatherName!=null) {
			if (!fatherName.equals(emp.getFatherName())) return false;
		}
		if (!department.getTitle().equals(emp.getDepartment().getTitle())) return false;
		return true;
		
	}
}