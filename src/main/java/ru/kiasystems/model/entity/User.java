package ru.kiasystems.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
public class User implements Serializable{

    @Id
    //@OneToOne(mappedBy = "user")
    private Integer id;

}
