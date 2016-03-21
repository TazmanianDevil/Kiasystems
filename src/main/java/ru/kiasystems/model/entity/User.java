package ru.kiasystems.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
@NamedQuery(name="User.getAllUsers", query="SELECT u FROM User u")
public class User implements Serializable{

    @Id
//    @OneToOne(mappedBy = "user")
//    private Employee employee;
    @Column(name="employee_id")
    private Integer id;
    @Column(name="username", length = 20, nullable = false)
    private String username;

    @Column(name="password", length=32, nullable = false)
    private String password;

    public User(){}

//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @Override
//    public String toString() {
//        return String.format("User[%d:%s:%s:%s:%d]", getEmployee().getId(),
//                getEmployee().getLastName(), getEmployee().getFirstName(), getUsername(), getPassword());
//    }
    @Override
    public String toString () {
        return "User["+id+":"+username+":"+password+"]";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getUsername() != null ? !getUsername().equals(user.getUsername()) : user.getUsername() != null)
            return false;
        return getPassword() != null ? getPassword().equals(user.getPassword()) : user.getPassword() == null;

    }

    @Override
    public int hashCode() {
        int result = getUsername() != null ? getUsername().hashCode() : 0;
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }
}
