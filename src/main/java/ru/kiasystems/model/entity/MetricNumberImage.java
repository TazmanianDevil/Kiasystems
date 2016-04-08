package ru.kiasystems.model.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name="metric_number_images")
@NamedQuery(name="MetricNumberImage.getAllMetricNumberImages", query = "SELECT mni FROM MetricNumberImage mni")
public class MetricNumberImage {
    @Id
    @Column(name="metric_number_id")
    private Long id;

    @Column(name="image")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;

    public MetricNumberImage(){}

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetricNumberImage that = (MetricNumberImage) o;
        return Arrays.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(image);
    }

    @Override
    public String toString() {
        return String.format("MetricNumberImage[%d, %d]\n", id, image.length);
    }
}
