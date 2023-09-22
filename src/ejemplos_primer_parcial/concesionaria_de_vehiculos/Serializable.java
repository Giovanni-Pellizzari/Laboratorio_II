package ejemplos_primer_parcial.concesionaria_de_vehiculos;

import java.io.IOException;

public interface Serializable {
    void guardar(String nombreArchivo)  throws IOException;
    void cargar(String nombreArchivo) throws IOException, ClassNotFoundException;
}
