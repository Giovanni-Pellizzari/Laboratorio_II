package herencia_polimorfismo;



public class Empleado {
    String nombre;
    String apellido;
    int antiguedad;
    double sueldo;

    public Empleado(String nombre, String apellido, int antiguedad, double sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.antiguedad = antiguedad;
        this.sueldo = sueldo;

    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }



    @Override
    public String toString() {
        if(antiguedad>3){
            return "Empleado{" +
                    "nombre='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' +
                    ", antiguedad=" + antiguedad +
                    ", sueldo=" + (sueldo += sueldo * 0.30) +
                    '}' + " Senior dev.";
        }else {
            return "Empleado{" +
                    "nombre='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' +
                    ", antiguedad=" + antiguedad +
                    ", sueldo=" + sueldo +
                    '}'+ " Junior dev.";
        }

    }
}
