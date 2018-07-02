package py.fpuna.is2.rest.services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Agustina Trinidad
 */
@javax.ws.rs.ApplicationPath("services")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(py.fpuna.is2.rest.services.HijoFacadeREST.class);
        resources.add(py.fpuna.is2.rest.services.RegistroFacadeREST.class);
        resources.add(py.fpuna.is2.rest.services.UsuarioFacadeREST.class);
        resources.add(py.fpuna.is2.rest.services.VacunaFacadeREST.class);
        
    }
    
}
