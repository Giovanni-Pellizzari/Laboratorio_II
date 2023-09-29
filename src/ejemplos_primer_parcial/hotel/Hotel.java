package ejemplos_primer_parcial.hotel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private ArrayList<Habitacion> habitaciones;

    Habitacion habitacion1 = new Habitacion(1,1,1,false,new ArrayList<Huesped>());
    Habitacion habitacion2 = new Habitacion(2,2,2,false,new ArrayList<Huesped>());
    Habitacion habitacion3 = new Habitacion(3,2,4,false,new ArrayList<Huesped>());

    public void hotel(String nombre) {
        this.nombre = nombre;
    }




    public void verListaDeHabitaciones() {
        System.out.println("Lista de habitaciones del hotel " + nombre);
        for (Habitacion habitacion : habitaciones) {
            System.out.println("Habitación " + habitacion.getNumero() + ": " + (habitacion.isOcupada() ? "Ocupada" : "Disponible"));
        }
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public String cargarNombreDelHotel() {
        String nombreDelHotel = "Nombre Predeterminado"; // Nombre predeterminado en caso de que la carga falle

        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Agustina\\Desktop\\nombre_hotel.txt");
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            nombreDelHotel = bufferedReader.readLine();

        } catch (IOException e) {
            System.out.println("No se pudo cargar el nombre del hotel desde el archivo. Se usará un nombre predeterminado.");
        }

        return nombreDelHotel;
    }
}
