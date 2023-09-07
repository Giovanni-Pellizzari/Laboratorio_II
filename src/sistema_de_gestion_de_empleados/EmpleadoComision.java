package sistema_de_gestion_de_empleados;

public class EmpleadoComision extends Empleado {
    private double ventasRealizadas;

    public double getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(double ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    public EmpleadoComision(String nombre, int id, double sueldoBase, double ventasRealizadas) {
        super(nombre, id, sueldoBase);
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    public double calcularSueldo() {
        // Supongamos que la comisión es del 7% de las ventas realizadas
        double comision = 0.07 * ventasRealizadas;
        return getSueldoBase() + comision;
    }

    public double calcularImpuesto() {
        //Supongamos que los impuestos son del 30%
        return calcularSueldo()*0.30;
    }

}
