package ejemplos_primer_parcial.hotel;

import java.util.ArrayList;

public class Habitacion {
   private int numero;
    private int cantidadCamas;
    private int capacidad;
    private boolean ocupado;
    private ArrayList<Huesped> huespedes;

    public Habitacion(int numero, int cantidadCamas, int capacidad, boolean ocupado, ArrayList<Huesped> huespedes) {
        this.numero = numero;
        this.cantidadCamas = cantidadCamas;
        this.capacidad = capacidad;
        this.ocupado = false;
        this.huespedes = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupada() {
        return ocupado;
    }

    public void reservar(Huesped huesped){
        if (!ocupado) {
            huespedes.add(huesped);
            ocupado = true;
            System.out.println("Habitación " + numero + " reservada para " + huesped.getNombre());
        } else {
            System.out.println("La habitación " + numero + " ya está ocupada.");
        }
    }

    public void cancelarReserva() {
        if (ocupado) {
            huespedes.clear();
            ocupado = false;
            System.out.println("Reserva en la habitación " + numero + " cancelada.");
        } else {
            System.out.println("La habitación " + numero + " no está ocupada.");
        }
    }

    public void mostrarHuespedes() {
        if (ocupado) {
            System.out.println("Habitación " + numero + " ocupada por:");
            for (Huesped huesped : huespedes) {
                huesped.mostrarInformacion();
            }
        } else {
            System.out.println("La habitación " + numero + " no está ocupada.");
        }
    }

}

