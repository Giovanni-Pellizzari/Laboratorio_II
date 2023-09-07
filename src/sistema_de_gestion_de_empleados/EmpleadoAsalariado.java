package sistema_de_gestion_de_empleados;

public class EmpleadoAsalariado extends Empleado {
    public EmpleadoAsalariado(String nombre, int id, double sueldoBase) {
        super(nombre, id, sueldoBase);
    }

    @Override
    public double calcularSueldo() {
        // El sueldo ya está definido como fijo
        return getSueldoBase();
    }

    public double calcularImpuesto() {
        //Supongamos que los impuestos son del 30%
        return calcularSueldo()*0.30;
    }
}
