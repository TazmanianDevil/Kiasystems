package ru.kiasystems.model.entity;
import javax.inject.Named;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import ru.kiasystems.model.entity.User;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="roles")
@NamedQueries({
@NamedQuery(name="Role.findAll", query = "SELECT r FROM Role r"),
@NamedQuery(name="Role.findAllWithDetail", query = "SELECT DISTINCT r FROM Role r LEFT JOIN FETCH r.users u"),
@NamedQuery(name="Role.findById", query = "SELECT r FROM Role r LEFT JOIN FETCH r.users u WHERE r.id=:id"),
@NamedQuery(name="Role.findByRoleName", query = "SELECT r FROM Role r WHERE r.name=:roleName")
})
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Long id;


    @Column(name="name", length = 20, nullable = false, unique = true)
    private String name;

    @Column(name="description", length = 200)
    private String description;

    @ManyToMany (fetch=FetchType.LAZY)
    @JoinTable(name="policies",
            joinColumns=@JoinColumn(name="role_id"),
            inverseJoinColumns=@JoinColumn(name="employee_id"))
	private Set<User> users;
	
    protected Role(){}

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
        users = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

	
	public void setUsers(Set<User> users) {
		this.users= users;
	}
	
	public Set<User> getUsers() {
		return users;
	}

    public void addUser(User user) {
        user.addRole(this);
        getUsers().add(user);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Role[%d:%s:%s]%n", id, name, description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (getName() != null ? !getName().equals(role.getName()) : role.getName() != null) return false;
        return getDescription() != null ? getDescription().equals(role.getDescription()) : role.getDescription() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }
}
