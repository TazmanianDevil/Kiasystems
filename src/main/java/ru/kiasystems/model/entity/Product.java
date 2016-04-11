package ru.kiasystems.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table (name="products")
@NamedQuery(name="Product.getAllProducts", query = "SELECT p FROM Product p")
public class Product {
    @Id
    @GeneratedValue
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
    private String note;

    @Column(name="special_notes", length = 250)
    private String specialNotes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_taking_id")
    private Employee takingEmployee;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_return_id")
    private Employee returnEmployee;

    @OneToOne
    @JoinColumn(name="theme_id")
    private Theme theme;

    @ManyToOne
    @JoinColumn(name="metric_number_id")
    private MetricNumber metricNumber;

    public Product(){}

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (index != null ? !index.equals(product.index) : product.index != null) return false;
        if (takingDate != null ? !takingDate.equals(product.takingDate) : product.takingDate != null) return false;
        if (returnDate != null ? !returnDate.equals(product.returnDate) : product.returnDate != null) return false;
        if (note != null ? !note.equals(product.note) : product.note != null) return false;
        if (specialNotes != null ? !specialNotes.equals(product.specialNotes) : product.specialNotes != null)
            return false;
        if (takingEmployee != null ? !takingEmployee.equals(product.takingEmployee) : product.takingEmployee != null)
            return false;
        if (returnEmployee != null ? !returnEmployee.equals(product.returnEmployee) : product.returnEmployee != null)
            return false;
        if (theme != null ? !theme.equals(product.theme) : product.theme != null) return false;
        return metricNumber != null ? metricNumber.equals(product.metricNumber) : product.metricNumber == null;

    }

    @Override
    public int hashCode() {
        int result = index != null ? index.hashCode() : 0;
        result = 31 * result + (takingDate != null ? takingDate.hashCode() : 0);
        result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (specialNotes != null ? specialNotes.hashCode() : 0);
        result = 31 * result + (takingEmployee != null ? takingEmployee.hashCode() : 0);
        result = 31 * result + (returnEmployee != null ? returnEmployee.hashCode() : 0);
        result = 31 * result + (theme != null ? theme.hashCode() : 0);
        result = 31 * result + (metricNumber != null ? metricNumber.hashCode() : 0);
        return result;
    }

    public String toString() {
        String empTaking = getTakingEmployee()==null?"":getTakingEmployee().getLastName()+getTakingEmployee().getFirstName();
        String empReturned = getReturnEmployee()==null?"":getReturnEmployee().getLastName()+getReturnEmployee().getFirstName();
        return String.format("Product[%d:%s:%03d:%tD:%s:%tD:%s:%s%n]", getId(),metricNumber.getName(), getIndex(), getTakingDate(),
                empTaking, getReturnDate(), empReturned, theme.getTitle());
    }
}
