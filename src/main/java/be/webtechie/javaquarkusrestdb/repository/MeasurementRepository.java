package be.webtechie.javaquarkusrestdb.repository;

import be.webtechie.javaquarkusrestdb.entity.Measurement;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@ApplicationScoped
@Path("/measurement")
public class MeasurementRepository implements PanacheRepository<Measurement> {

    @GET
    public List<Measurement> get() {
        return Measurement.findAll().list();
    }
}
