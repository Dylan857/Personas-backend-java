package mx.com.gm.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mx.com.gm.data.PersonaDao;
import mx.com.gm.domain.Persona;

@Stateless
@Path("/personas")
public class PersonaServiceRS {
    
    @Inject
    private PersonaDao personaDao;
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Persona> listarPersonas() {
        List<Persona> personas = personaDao.encontrarPersonas();
        System.out.println("Personas encontradas: " + personas);
        return personas;
    }
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Persona encontrarPersona(@PathParam("id") Integer id) {
        Persona persona = personaDao.encontrarPersona(new Persona(id));
        
        System.out.println("Persona encontrada: " + persona);
        return persona;
    }
    
    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Persona agregarPersona(Persona persona) {
        personaDao.insertarPersona(persona);
        System.out.println("Persona agregada: " + persona);
        return persona;
    }
    
    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response actualizarPersona(@PathParam("id") Integer id, Persona personaModificada) {
        Persona persona = personaDao.encontrarPersona(new Persona(id));
        if(persona != null) {
            personaDao.actualizarPersona(personaModificada);
            System.out.println("Persona modificada " + personaModificada);
            return Response.ok().entity(personaModificada).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response eliminarPersona(@PathParam("id") Integer id) {
        personaDao.eliminarPersona(new Persona(id));
        System.out.println("Persona eliminada con el id: " + id);
        return Response.ok().build();
    }
    
}
