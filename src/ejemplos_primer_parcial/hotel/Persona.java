package ejemplos_primer_parcial.hotel;

import java.io.Serializable;

public abstract class Persona implements Serializable {
   private String nombre;
    private String apellido;
    private int dni;

    public Persona(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public abstract void mostrarInformacion();
}




