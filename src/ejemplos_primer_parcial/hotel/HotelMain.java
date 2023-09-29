package ejemplos_primer_parcial.hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelMain {
    public static void main(String[] args){
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Menú del hotel " + hotel.cargarNombreDelHotel());
            System.out.println("1- Ver lista de habitaciones");
            System.out.println("2- Reservar una habitación");
            System.out.println("3- Cancelar una reserva");
            System.out.println("4- Guardar reservas en un archivo");
            System.out.println("5- Cargar reservas de un archivo");
            System.out.println("6- Salir");

            int opc = scanner.nextInt();

            switch (opc){

                case 1:{
                    hotel.verListaDeHabitaciones();
                }
                break;
                case 2:{
                    System.out.print("Ingrese el nombre del huésped: ");
                    String nombreHuesped = scanner.next();
                    System.out.print("Ingrese el apellido del huésped: ");
                    String apellidoHuesped = scanner.next();
                    System.out.print("Ingrese el DNI del huésped: ");
                    int dniHuesped = scanner.nextInt();

                    // Crear un objeto Huesped con la información proporcionada
                    Huesped nuevoHuesped = new Huesped(nombreHuesped, apellidoHuesped, dniHuesped);

                    Habitacion habitacionDisponible = null;
                    for (Habitacion habitacion : hotel.getHabitaciones()) {
                        if (!habitacion.isOcupada()) {
                            habitacionDisponible = habitacion;
                            break; // Encontramos una habitación disponible, salimos del bucle
                        }
                    }

                    if (habitacionDisponible != null) {
                        // Realizar la reserva
                        habitacionDisponible.reservar(nuevoHuesped);
                    } else {
                        System.out.println("Lo siento, no hay habitaciones disponibles.");
                    }
                }
                break;
                case 3:{
                    System.out.print("Ingrese el número de habitación a cancelar: ");
                    int numeroHabitacion = scanner.nextInt();

                    // Buscar la habitación por número
                    Habitacion habitacionSeleccionada = null;
                    for (Habitacion habitacion : hotel.getHabitaciones()) {
                        if (habitacion.getNumero() == numeroHabitacion) {
                            habitacionSeleccionada = habitacion;
                            break;
                        }
                    }
                    if (habitacionSeleccionada != null && habitacionSeleccionada.isOcupada()) {
                        // Cancelar la reserva
                        habitacionSeleccionada.cancelarReserva();
                    } else {
                        System.out.println("La habitación no existe o no está ocupada.");
                    }
                }
                break;
                case 4:{
                    System.out.println("we");
                }
                break;
                case 5:{
                    System.out.println("wer");
                }
                break;
                case 6:{
                    System.out.println("chau");
                    return;
                }
            }

        }while (true);
    }
}
