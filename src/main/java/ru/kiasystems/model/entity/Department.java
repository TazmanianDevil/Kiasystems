package ru.kiasystems.model.entity;

import javax.persistence.*;

@Entity
@Table(name="departments")
public class Department {
    @Id
    @GeneratedValue
    @Column (name="department_id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="abbreviation")
    private String abbreviation;

    public Department() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "["+id+":"+title+":"+abbreviation+"]";
    }
}
