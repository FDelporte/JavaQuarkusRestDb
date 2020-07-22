package be.webtechie.javaquarkusrestdb.repository;

import be.webtechie.javaquarkusrestdb.entity.MeasurementEntity;
import be.webtechie.javaquarkusrestdb.entity.SensorEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.jboss.logging.Logger;

@ApplicationScoped
@Path("/measurement")
public class MeasurementRepository implements PanacheRepository<MeasurementEntity> {

    private static final Logger LOG = Logger.getLogger(MeasurementRepository.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MeasurementEntity> get() {
        return this.findAll().list();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{sensorId}/{key}/{value}")
    @Transactional
    public Response create(
            @PathParam("sensorId") Long sensorId,
            @PathParam("key") String key,
            @PathParam("value") Double value    ) {
        try {
            Optional<SensorEntity> sensor = SensorEntity.findByIdOptional(sensorId);
            if (sensor.isEmpty()) {
                return Response.status(Status.BAD_REQUEST).build();
            }
            MeasurementEntity measurement = new MeasurementEntity(sensor.get(), key, value);
            this.persistAndFlush(measurement);
            return Response.ok(measurement).build();
        } catch (PersistenceException pe) {
            LOG.error("Error while creating sensor", pe);
        }
        return null;
    }}
