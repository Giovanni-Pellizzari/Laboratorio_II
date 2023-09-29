package ejemplos_primer_parcial.hotel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Hotel implements Serializable {
    private String nombreHotel;
    private ArrayList<Habitacion> habitaciones;

    public Hotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
        this.habitaciones = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        this.habitaciones.add(habitacion);
    }


    public void verListaHabitaciones() {
        System.out.println("Nombre del Hotel: " + nombreHotel + "\n");
        System.out.println("LISTA DE HABITACIONES: \n");

        for (Habitacion habitacion : habitaciones) {
            habitacion.mostrarInformacion();
            System.out.println();
        }
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void guardarReservasEnArchivo(String nombreArchivo) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            salida.writeObject(this);
            System.out.println("Reservas guardadas en archivo exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar las reservas en el archivo: " + e.getMessage());
        }
    }

    public static Hotel cargarReservasDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (Hotel) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar las reservas desde el archivo: " + e.getMessage());
            return null;
        }
    }

    /*public String cargarNombreDelHotel(String nombreHotel) {
        String nombreDelHotel = "Nombre Predeterminado"; // Nombre predeterminado en caso de que la carga falle

        try (FileInputStream fileInputStream = new FileInputStream(nombreHotel);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            nombreDelHotel = bufferedReader.readLine();

        } catch (IOException e) {
            System.out.println("No se pudo cargar el nombre del hotel desde el archivo. Se usará un nombre predeterminado.");
        }

        return nombreDelHotel;
    }*/
}
