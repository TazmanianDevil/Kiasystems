package ru.kiasystems.model.entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="roles")
@NamedQuery(name="Role.getAllRoles", query = "SELECT r FROM Role r")
public class Role {

    @Id
    @GeneratedValue
    @Column(name="role_id")
    private Integer id;


    @Column(name="name", length = 20, nullable = false, unique = true)
    private String name;

    @Column(name="description", length = 200)
    private String description;

    public Role(){}

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
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
        return String.format("Role[%d:%s:%s]\n", id, name, description);
    }
}
