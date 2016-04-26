package ru.kiasystems.model.entity;

import javax.inject.Named;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table (name="products")
@NamedQueries({
//        @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p ORDER BY p.index"),
//        @NamedQuery(name="Product.findAllWithDetail", query = "SELECT p FROM Product p " +
//                "LEFT JOIN FETCH p.metricNumber mn " +
//                "LEFT JOIN FETCH p.returnEmployee re " +
//                "LEFT JOIN FETCH p.takingEmployee te " +
//                "LEFT JOIN FETCH p.theme t ORDER BY p.index")
        @NamedQuery(name="Product.findAllByMetricNumberId", query = "SELECT p FROM Product p " +
                " WHERE p.metricNumber.id=:metricNumberId ORDER BY p.index ASC"),
        @NamedQuery(name="Product.findAllWithDetailByMetricNumberId", query = "SELECT p FROM Product p " +
                "LEFT JOIN FETCH p.metricNumber mn " +
                "LEFT JOIN FETCH p.takingEmployee te " +
                "LEFT JOIN FETCH p.returnEmployee re " +
                "LEFT JOIN FETCH p.theme t " +
                " WHERE p.metricNumber.id=:metricNumberId ORDER BY p.index"),
        @NamedQuery(name="Product.findById", query = "SELECT p FROM Product p " +
                "LEFT JOIN FETCH p.metricNumber mn " +
                "LEFT JOIN FETCH p.takingEmployee te " +
                "LEFT JOIN FETCH p.returnEmployee re " +
                "LEFT JOIN FETCH p.theme t " +
                "WHERE p.id=:id ORDER BY p.index")

})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long id;

    @Column(name="product_index")
    Integer index;

    @Temporal(TemporalType.DATE)
    @Column(name="taking_date")
    private Date takingDate;

    @Temporal(TemporalType.DATE)
    @Column(name="return_date")
    private Date returnDate;

    @Column(name="notes", length = 250)
    private String notes;

    @Column(name="special_notes", length = 250)
    private String specialNotes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_taking_id")
    private Employee takingEmployee;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_return_id")
    private Employee returnEmployee;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="theme_id")
    private Theme theme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="metric_number_id")
    private MetricNumber metricNumber;

    public Product(Integer index, Date takingDate, Date returnDate, String notes, String specialNotes){
        this.index = index;
        this.takingDate = takingDate;
        this.returnDate = returnDate;
        this.notes=notes;
        this.specialNotes=specialNotes;
    }

    protected Product() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Date getTakingDate() {
        return takingDate;
    }

    public void setTakingDate(Date takingDate) {
        this.takingDate = takingDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    public Employee getTakingEmployee() {
        return takingEmployee;
    }

    public void setTakingEmployee(Employee takingEmployee) {
        this.takingEmployee = takingEmployee;
    }

    public Employee getReturnEmployee() {
        return returnEmployee;
    }

    public void setReturnEmployee(Employee returnEmployee) {
        this.returnEmployee = returnEmployee;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public MetricNumber getMetricNumber() {
        return metricNumber;
    }

    public void setMetricNumber(MetricNumber metricNumber) {
        this.metricNumber = metricNumber;
    }

    public String toString() {
        return String.format("Product[%d:%03d:%tD:%tD:%s:%s]", getId(), getIndex(), getTakingDate(),
                getReturnDate(),getNotes(),getSpecialNotes());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (getIndex() != null ? !getIndex().equals(product.getIndex()) : product.getIndex() != null) return false;
        if (getTakingDate() != null ? !getTakingDate().equals(product.getTakingDate()) : product.getTakingDate() != null)
            return false;
        if (getReturnDate() != null ? !getReturnDate().equals(product.getReturnDate()) : product.getReturnDate() != null)
            return false;
        if (getNotes() != null ? !getNotes().equals(product.getNotes()) : product.getNotes() != null) return false;
        return getSpecialNotes() != null ? getSpecialNotes().equals(product.getSpecialNotes()) : product.getSpecialNotes() == null;

    }

    @Override
    public int hashCode() {
        int result = getIndex() != null ? getIndex().hashCode() : 0;
        result = 31 * result + (getTakingDate() != null ? getTakingDate().hashCode() : 0);
        result = 31 * result + (getReturnDate() != null ? getReturnDate().hashCode() : 0);
        result = 31 * result + (getNotes() != null ? getNotes().hashCode() : 0);
        result = 31 * result + (getSpecialNotes() != null ? getSpecialNotes().hashCode() : 0);
        return result;
    }
}
