package ru.kiasystems.model.entity;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "metric_numbers")
@NamedQuery(name="MetricNumber.getAllMetricNumbers", query = "SELECT mn FROM MetricNumber mn")
public class MetricNumber {

    @Id
    @GeneratedValue
    @Column(name="metric_number_id")
    private Long id;

    @Column(name = "name", length = 11, nullable = false)
    private String name;

    @Column(name="title", length = 120, nullable = false)
    private String title;

    @Column(name="description", length = 120, nullable = false)
    private String description;

    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    MetricNumberImage image;

    public MetricNumber(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetricNumber that = (MetricNumber) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("MetricNumber[%d:%s:%s:%s]\n", id, name, title, description);
    }

    public MetricNumberImage getImage() {
        return image;
    }

    public void setImage(MetricNumberImage image) {
        this.image = image;
    }
}
