package examen_parcial_nro1;

import java.util.ArrayList;

public class Pacientes extends Persona implements Informacion{
    private int numeroDeTelefono;
    private int tipoDeSangre;
    private ArrayList<String> historialMedico;

    public int getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(int numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public int getTipoDeSangre() {
        return tipoDeSangre;
    }

    public void setTipoDeSangre(int tipoDeSangre) {
        this.tipoDeSangre = tipoDeSangre;
    }

    public ArrayList <String> getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(ArrayList <String> historialMedico) {
        this.historialMedico = historialMedico;
    }

    public Pacientes(String nombre, int dni, int fechaDeNacimiento, int numeroDeTelefono, int tipoDeSangre, ArrayList <String> historialMedico) {
        super(nombre, dni, fechaDeNacimiento);
        this.numeroDeTelefono = numeroDeTelefono;
        this.tipoDeSangre = tipoDeSangre;
        this.historialMedico = historialMedico;
    }

    @Override
    public void verHistorialDeEventos() {
        System.out.println("Historial Medico");
        System.out.println(historialMedico);
    }
}
