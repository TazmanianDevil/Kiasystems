package ru.kiasystems.model.entity;

import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import ru.kiasystems.model.entity.Role;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@NamedQueries({
@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
@NamedQuery(name="User.findAllWithDetail", query = "SELECT u FROM User u LEFT JOIN FETCH u.roles r"),
@NamedQuery(name="User.findById", query = "SELECT u FROM User u LEFT JOIN FETCH u.roles r WHERE u.id=:id"),
@NamedQuery(name="User.findByUserName", query = "SELECT u FROM User u LEFT JOIN FETCH u.roles r WHERE u.userName=:userName")
})
public class User implements Serializable{

    @Id
    @Column(name="employee_id")
    private Long id;

    @Column(name="username", length = 20, nullable = false)
    private String userName;

    @Column(name="password", length=32, nullable = false)
    private String password;

	@ManyToMany (fetch=FetchType.LAZY)
	@JoinTable(name="policies",
		joinColumns=@JoinColumn(name="employee_id"),
		inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles;
		
    protected User(){}

    public User(Long id, String userName, String password) {
        this.id = id;
        this.userName=userName;
        this.password = password;
        roles = new HashSet<>();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

    public void addRole(Role role) {
        role.addUser(this);
        getRoles().add(role);
    }

    public void removeRole(Role role) {
        getRoles().remove(role);
    }

    @Override
    public String toString () {
        return String.format("User[%d:%s:%s]%n", getId(), getUsername(), getPassword());
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
