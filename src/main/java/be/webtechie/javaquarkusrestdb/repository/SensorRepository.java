package be.webtechie.javaquarkusrestdb.repository;

import be.webtechie.javaquarkusrestdb.entity.SensorEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@ApplicationScoped
@Path("/sensor")
public class SensorRepository implements PanacheRepository<SensorEntity> {

    private static final Logger LOG = Logger.getLogger(SensorRepository.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SensorEntity> getAll() {
        return this.findAll().list();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public SensorEntity getByName(@PathParam("name") String name) {
        return this.find("name", name).firstResult();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public SensorEntity getById(@PathParam("id") Long id) {
        return this.findById(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    @Transactional
    public SensorEntity create(@PathParam("name") String name) {
        try {
            SensorEntity sensor = new SensorEntity(name);
            this.persistAndFlush(sensor);
            return sensor;
        } catch (PersistenceException pe) {
            LOG.error("Error while creating sensor", pe);
        }
        return null;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void create(@PathParam("id") Long id) {
        try {
            this.deleteById(id);
        } catch (PersistenceException pe) {
            LOG.error("Error while deleting sensor with id {}", id, pe);
        }
    }
}
