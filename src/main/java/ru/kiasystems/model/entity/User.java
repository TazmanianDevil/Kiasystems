package ru.kiasystems.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
public class User implements Serializable{

    @Id
    @OneToOne
    @JoinTable(name = "employees")
    @JoinColumn(name="employee_id")
    private Employee employee;


}
