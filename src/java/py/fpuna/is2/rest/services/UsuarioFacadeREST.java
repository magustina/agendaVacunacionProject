package py.fpuna.is2.rest.services;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
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
import py.fpuna.is2.rest.entities.Usuario;

/**
 *
 * @author Agustina Trinidad
 */
@Stateless
@Path("usuarios")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "WebServiceAppRestIS2PU")
    private EntityManager em;

    public UsuarioFacadeREST() {
        super(Usuario.class);
    }

    @POST
    @Path("crear")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public void create(Usuario entity) {
        super.create(entity);
    }

    @PUT
    @Path("editar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public void edit(Usuario entity) {
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
    public Usuario find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("todos")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Usuario> findAll() {
        return super.findAll();
    }
    
    @POST
    @Path("validarUsuario")
    @Produces(MediaType.APPLICATION_JSON)  //lo que devuelve es un tipo json
    public Usuario validar(Usuario user){
        Query query = em
                .createQuery("SELECT u FROM Usuario u WHERE u.email LIKE :email")
                .setParameter("email", user.getEmail().trim().toLowerCase())
                .setMaxResults(1);
                        
        Usuario usuario = null;

        try {
            usuario = (Usuario) query.getSingleResult();
            return usuario;
        } catch (NoResultException e) {
            System.err.println("No existe resultado");
        } catch (NonUniqueResultException e) {
            System.err.println("Existe mas de un resultado");
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        return usuario;
    }
    
    @GET
    @Path("hijos/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hijo> findHijos(@PathParam("id") Integer id) {

        Usuario usuario = em.find(Usuario.class, id);
        if (usuario == null) {
            return new ArrayList<>();
        }

        Query query = em.createQuery("SELECT h FROM Hijo h WHERE h.idUsuario = :id_usuario")
                .setParameter("id_usuario", usuario);
        List<Hijo> list = query.getResultList();
        return list;
    }
    
    @POST
    @Path("consultaHijos")
    @Produces(MediaType.APPLICATION_JSON)  //lo que devuelve es un tipo json
    public List<Hijo> consultaHijos (Usuario user){
        Usuario usuario = em.find(Usuario.class, user.getIdUsuario());
        if (usuario == null) {
            return new ArrayList<>();
        }

        Query query = em.createQuery("SELECT h FROM Hijo h WHERE h.idUsuario = :id_usuario")
                .setParameter("id_usuario", usuario);
        List<Hijo> list = query.getResultList();
        return list;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
