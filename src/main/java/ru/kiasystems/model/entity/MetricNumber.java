package ru.kiasystems.model.entity;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "metric_numbers")
@NamedQueries({
@NamedQuery(name="MetricNumber.findAll", query = "SELECT mn FROM MetricNumber mn"),
@NamedQuery(name="MetricNumber.findAllWithDetail", query = "SELECT DISTINCT mn FROM MetricNumber mn LEFT JOIN FETCH mn.image im" +
        " LEFT JOIN FETCH mn.products p"),
@NamedQuery(name="MetricNumber.findById", query = "SELECT DISTINCT mn FROM MetricNumber mn LEFT JOIN FETCH mn.image im" +
        " LEFT JOIN FETCH mn.products p WHERE mn.id=:id"),
@NamedQuery(name="MetricNumber.findByName", query = "SELECT mn FROM MetricNumber mn WHERE mn.name=:name"),
@NamedQuery(name="MetricNumber.findByTitle", query = "SELECT mn FROM MetricNumber mn WHERE mn.title=:title")
})
public class MetricNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "metricNumber", fetch = FetchType.LAZY)
    private Set<Product> products;

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    protected MetricNumber(){}

    public MetricNumber(String name, String title, String description){
        this.name = name;
        this.title = title;
        this.description = description;
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

    public void addProduct(Product p) {
        p.setMetricNumber(this);
        getProducts().add(p);
    }

    public void removeProduct(Product p) {
        getProducts().remove(p);
    }
    public MetricNumberImage getImage() {
        return image;
    }

    public void setImage(MetricNumberImage image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return String.format("MetricNumber[%d:%s:%s:%s]\n", id, name, title, description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetricNumber that = (MetricNumber) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null) return false;
        return getDescription() != null ? getDescription().equals(that.getDescription()) : that.getDescription() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }
}
