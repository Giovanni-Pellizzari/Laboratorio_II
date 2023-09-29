package ejemplos_primer_parcial.hotel;

import java.io.Serializable;

public class Huesped extends Persona implements Serializable {

    public Huesped(String nombre, String apellido, int dni) {
        super(nombre, apellido, dni);
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("Nombre: "+ getNombre() + '\'' +
                "Apellido: " + getApellido() + '\'' +
                "DNI: " + getDni() );
    }
}
