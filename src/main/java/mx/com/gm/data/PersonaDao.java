package mx.com.gm.data;

import java.util.List;
import mx.com.gm.domain.Persona;

public interface PersonaDao {
    
	/**
     * Método encargado de encontrar una persona una lista de usuarios.
     * ADVERTENCIA: Este método no funciona con personas de id mayor a 100.
     * 
     * @deprecated
     * @see {@link}
     * @since 2022-06-04
     * @author Dylan V.
     * @param id id de la perona
     * @return {@link Persona} la persona encontrada.
     */
    public List<Persona> encontrarPersonas();
    
    /**
     * Método encargado de encontrar una persona por id.
     * 
     * @param id id de la perona
     * @return {@link Persona} la persona encontrada.
     */
    public Persona encontrarPersona(Persona persona) throws NullPointerException;
    
    public void insertarPersona(Persona persona);
    
    public void actualizarPersona(Persona persona);
    
    public void eliminarPersona(Persona persona);
    
}
