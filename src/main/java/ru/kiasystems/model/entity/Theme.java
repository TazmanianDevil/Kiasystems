package ru.kiasystems.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
@Entity
@Table (name="themes")
@NamedQuery(name = "Theme.getAllThemes", query = "SELECT t FROM Theme t")
public class Theme implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="theme_id")
    private Integer id;

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

    public String toString() {
        //return "Theme[" + id + ":" + title+":"+startDate+":"+closeDate+"]";
         return String.format("Theme[%d:%s:%1$td.%1$tm.%1$tY:%2$td.%2$tm.%2$tY]\n", id, title, startDate, closeDate);
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj==null || !(obj instanceof Theme))
            return false;
        Theme theme = (Theme)obj;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return this.title.equals(theme.getTitle()) && sdf.format(this.startDate).equals(theme.getStartDate())
                && this.closeDate == theme.getCloseDate();
    }
}
