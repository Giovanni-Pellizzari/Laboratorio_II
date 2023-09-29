package ejemplos_primer_parcial.hotel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Habitacion implements MostrarInformacion, Serializable {
   private int numeroHabitacion;
    private int cantidadCamas;
    private int capacidad;
    private boolean ocupado;
    private ArrayList<Huesped> huespedes;

    public Habitacion(int numero, int cantidadCamas, int capacidad) {
        this.numeroHabitacion = numero;
        this.cantidadCamas = cantidadCamas;
        this.capacidad = capacidad;
        this.ocupado = false;
        this.huespedes = new ArrayList<>();
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }


    public void reservar(List<Huesped> huespedes){
        this.ocupado = true;
        this.huespedes.addAll(huespedes);
    }

    public void cancelarReserva() {
        if (ocupado) {
            huespedes.clear();
            ocupado = false;
            System.out.println("Reserva en la habitación " + numeroHabitacion + " cancelada.");
        } else {
            System.out.println("La habitación " + numeroHabitacion + " no está ocupada.");
        }
    }

    public void agregarHuesped(Huesped huesped) {
        this.huespedes.add(huesped);
    }

    public void eliminarHuesped(int indice) {
        if (indice >= 0 && indice < this.huespedes.size()) {
            this.huespedes.remove(indice);
        }
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Número de Habitación: " + numeroHabitacion);
        System.out.println("Cantidad de Camas: " + cantidadCamas);
        System.out.println("Capacidad de Huéspedes: " + capacidad);
        System.out.println("Estado: " + (ocupado ? "Ocupada" : "Disponible"));

        if (ocupado) {
            System.out.println("Huéspedes:");
            for (Huesped huesped : huespedes) {
                huesped.mostrarInformacion();
            }
        }
    }
}

