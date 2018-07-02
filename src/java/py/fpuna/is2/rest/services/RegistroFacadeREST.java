package py.fpuna.is2.rest.services;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import py.fpuna.is2.rest.entities.Hijo;
import py.fpuna.is2.rest.entities.Registro;

/**
 *
 * @author Agustina Trinidad
 */
@Stateless
@Path("registros")
public class RegistroFacadeREST extends AbstractFacade<Registro> {

    @PersistenceContext(unitName = "WebServiceAppRestIS2PU")
    private EntityManager em;

    public RegistroFacadeREST() {
        super(Registro.class);
    }

    @POST
    @Path("crear")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public void create(Registro entity) {
        super.create(entity);
    }

    @PUT
    @Path("editar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public void edit(Registro entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("eliminar/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("consultar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Registro find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("todos")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Registro> findAll() {
        return super.findAll();
    }

    @POST
    @Path("consultar_por_hijo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Registro> findAllByHijoId(@PathParam("id") Integer id) {

        Hijo hijo = em.find(Hijo.class, id);
        if (hijo == null) {
            return new ArrayList<>();
        }

        Query query = em.createQuery("SELECT r FROM Registro r WHERE r.idHijo = :id_hijo")
                .setParameter("id_hijo", hijo);
        List<Registro> list = query.getResultList();
        return list;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
