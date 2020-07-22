package be.webtechie.javaquarkusrestdb.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class SensorEntity extends PanacheEntity {

    public String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "sensor_id")
    public List<MeasurementEntity> measurements = new ArrayList<>();

    public SensorEntity() {
        // Required for mapping
    }

    public SensorEntity(String name) {
        this.name = name;
    }
}
