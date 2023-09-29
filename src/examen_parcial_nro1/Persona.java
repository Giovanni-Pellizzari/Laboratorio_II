package examen_parcial_nro1;

public class Persona {
    private String nombre;
    private int dni;
    private int fechaDeNacimiento;

    public Persona(String nombre, int dni, int fechaDeNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }
}
