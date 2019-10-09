package pojos;
//Pojo de nuestra tabla 
import java.io.Serializable;

/**
 *
 * @author exkapp
 */
public class Persona implements Serializable{
    private String clave;
    private String nombre;
    private String direccion;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
