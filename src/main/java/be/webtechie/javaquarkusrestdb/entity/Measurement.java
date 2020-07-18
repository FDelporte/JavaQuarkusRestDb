package be.webtechie.javaquarkusrestdb.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;

@Entity
public class Measurement extends PanacheEntity {
    String id;
    String name;
}
