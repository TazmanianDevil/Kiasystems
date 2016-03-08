package ru.kiasystems.model.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table (name="themes")
public class Theme {
    @Id
    @GeneratedValue
    @Column(name="theme_id")
    private int id;

    @Column(name="title", nullable = false)
    private String title;

    @Temporal(TemporalType.DATE)
    @Column(name="start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name="close_date")
    private Date closeDate;

    public Theme() {}

    public Theme(String title, Date startDate) {
        this.title = title;
        this.startDate = startDate;
    }

    public Theme(String title, Date startDate, Date closeDate) {
        this.title = title;
        this.startDate = startDate;
        this.closeDate = closeDate;
    }

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }
}
