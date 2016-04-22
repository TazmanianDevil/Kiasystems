package ru.kiasystems.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
@Entity
@Table (name="themes")
@NamedQueries({@NamedQuery(name = "Theme.findAll", query = "SELECT t FROM Theme t"),
@NamedQuery(name = "Theme.findById", query = "SELECT t FROM Theme t WHERE t.id=:id"),
@NamedQuery(name = "Theme.findByTitle", query = "SELECT t FROM Theme t WHERE t.title LIKE :title"),
})

public class Theme implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="theme_id")
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String toString() {
         return String.format("Theme[%d:%s:%3$td.%3$tm.%3$tY:%4$td.%4$tm.%4$tY]\n", id, title, startDate, closeDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Theme theme = (Theme) o;

        if (getTitle() != null ? !getTitle().equals(theme.getTitle()) : theme.getTitle() != null) return false;
        if (getStartDate() != null ? !getStartDate().equals(theme.getStartDate()) : theme.getStartDate() != null)
            return false;
        return getCloseDate() != null ? getCloseDate().equals(theme.getCloseDate()) : theme.getCloseDate() == null;

    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getCloseDate() != null ? getCloseDate().hashCode() : 0);
        return result;
    }
}
