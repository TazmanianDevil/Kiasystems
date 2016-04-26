package ru.kiasystems.model.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name="metric_number_images")
@NamedQueries({
    @NamedQuery(name="MetricNumberImage.findAll", query = "SELECT mni FROM MetricNumberImage mni"),
    @NamedQuery(name="MetricNumberImage.findById", query = "SELECT mni FROM MetricNumberImage mni WHERE mni.id=:id")
})
public class MetricNumberImage {
    @Id
    @Column(name="metric_number_id")
    private Long id;

    @Column(name="image")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;

    protected MetricNumberImage(){}

    public MetricNumberImage(Long id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return String.format("MetricNumberImage[%d, %d]\n", id, image.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetricNumberImage that = (MetricNumberImage) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return Arrays.equals(getImage(), that.getImage());

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + Arrays.hashCode(getImage());
        return result;
    }
}
