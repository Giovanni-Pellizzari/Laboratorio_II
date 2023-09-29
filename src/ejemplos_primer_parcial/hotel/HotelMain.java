package ejemplos_primer_parcial.hotel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelMain {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String nombreHotel = "Nombre Predeterminado"; // Nombre predeterminado en caso de que la carga falle

        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\JOVA\\Desktop\\nombreHotel.txt");
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            nombreHotel = bufferedReader.readLine();

        } catch (IOException e) {
            System.out.println("No se pudo cargar el nombre del hotel desde el archivo. Se usará un nombre predeterminado.");
        }

        Hotel hotel = new Hotel(nombreHotel);

        hotel.agregarHabitacion(new Habitacion(1,2,2));
        hotel.agregarHabitacion(new Habitacion(2,2,2));
        hotel.agregarHabitacion(new Habitacion(3,4,4));

        do {
            System.out.println("Menú del hotel " + nombreHotel);
            System.out.println("1- Ver lista de habitaciones");
            System.out.println("2- Reservar una habitación");
            System.out.println("3- Cancelar una reserva");
            System.out.println("4- Guardar reservas en un archivo");
            System.out.println("5- Cargar reservas de un archivo");
            System.out.println("6- Salir");

            int opc = scanner.nextInt();

            switch (opc){

                case 1:
                    hotel.verListaHabitaciones();

                break;
                case 2:
                    System.out.println("Ingrese el número de habitación que desea reservar: ");
                    int numeroHabitacion = scanner.nextInt();
                    System.out.println("Ingrese la cantidad de huéspedes que se hospedarán en la habitación: ");
                    int cantidadHuespedes = scanner.nextInt();
                    List<Huesped> huespedes = new ArrayList<>();
                    for (int i = 0; i < cantidadHuespedes; i++) {
                        System.out.println("Ingrese el nombre del huésped " + (i + 1) + ": ");
                        String nombre = scanner.next();
                        System.out.println("Ingrese apellido del huésped " + (i + 1) + ": ");
                        String apellido = scanner.next();
                        System.out.println("Ingrese su DNI o número de pasaporte: ");
                        int dni = scanner.nextInt();
                        huespedes.add(new Huesped(nombre, apellido, dni));
                    }
                    Habitacion habitacion = null;
                    for (Habitacion h : hotel.getHabitaciones()) {
                        if (h.getNumeroHabitacion() == numeroHabitacion) {
                            habitacion = h;
                            break;
                        }
                    }
                    if (habitacion != null) {
                        habitacion.reservar(huespedes);
                        System.out.println("Habitación reservada exitosamente.");
                    } else {
                        System.out.println("No se encontró la habitación con el número ingresado.");
                    }

                break;
                case 3:
                    System.out.println("Ingrese el número de habitación que desea cancelar la reserva: ");
                    numeroHabitacion = scanner.nextInt();
                    habitacion = null;
                    for (Habitacion h : hotel.getHabitaciones()) {
                        if (h.getNumeroHabitacion() == numeroHabitacion) {
                            habitacion = h;
                            break;
                        }
                    }
                    if (habitacion != null) {
                        habitacion.cancelarReserva();
                        System.out.println("Reserva cancelada exitosamente.");
                    } else {
                        System.out.println("No se encontró la habitación con el número ingresado.");
                    }

                break;
                case 4:
                    hotel.guardarReservasEnArchivo("Reservas.txt");
                break;
                case 5:{
                    hotel = Hotel.cargarReservasDesdeArchivo("Reservas.txt");
                }
                break;
                case 6:{
                    System.out.println("chau");
                    return;
                }
                default:
                    System.out.println("Opcion no valida, intente nuevamente con una opcion entre 1 y 6");
            }

        }while (true);
    }
}
