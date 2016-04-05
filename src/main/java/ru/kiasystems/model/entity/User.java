package ru.kiasystems.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import ru.kiasystems.model.entity.Role;
import java.util.List;
@Entity
@Table(name="users")
@NamedQuery(name="User.getAllUsers", query="SELECT u FROM User u")
public class User implements Serializable{

    @Id
    @Column(name="employee_id")
    private Integer id;
    @Column(name="username", length = 20, nullable = false)
    private String username;

    @Column(name="password", length=32, nullable = false)
    private String password;

	@ManyToMany (fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JoinTable(name="policies",
		joinColumns=@JoinColumn(name="employee_id"),
		inverseJoinColumns=@JoinColumn(name="role_id"))
	private List<Role>roles;
		
    public User(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

	public List<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
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
