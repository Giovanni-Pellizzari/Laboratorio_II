package sistema_de_gestion_de_empleados;

public class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public EmpleadoPorHoras(String nombre, int id, double sueldoBase, int horasTrabajadas) {
        super(nombre, id, sueldoBase);
        this.horasTrabajadas = horasTrabajadas;
    }
    @Override
    public double calcularSueldo() {
        // Supongamos que el sueldo por hora es de $10
        double sueldoPorHora = 10.0;
        return getSueldoBase() + (horasTrabajadas * sueldoPorHora);
    }

    public double calcularImpuesto() {
        //Supongamos que los impuestos son del 30%
        return calcularSueldo()*0.30;
    }
}
