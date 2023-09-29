package examen_parcial_nro1;

public class Doctores extends Persona {
    private String especialidad;

    public Doctores(String nombre, int dni, int fechaDeNacimiento, String especialidad) {
        super(nombre, dni, fechaDeNacimiento);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


}
