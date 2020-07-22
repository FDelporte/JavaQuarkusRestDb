package be.webtechie.javaquarkusrestdb.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.time.LocalDateTime;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MeasurementEntity extends PanacheEntity {

    public String key;

    public Double value;

    public LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false)
    @JsonbTransient
    public SensorEntity sensorEntity;

    public MeasurementEntity() {
        // Required for mapping
    }

    public MeasurementEntity(SensorEntity sensorEntity, String key, Double value) {
        this.sensorEntity = sensorEntity;
        this.key = key;
        this.value = value;
        this.timestamp = LocalDateTime.now();
    }
}
