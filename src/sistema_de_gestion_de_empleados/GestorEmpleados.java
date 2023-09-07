package sistema_de_gestion_de_empleados;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorEmpleados {
    private ArrayList<Empleado> listaEmpleados;

    public GestorEmpleados() {
        listaEmpleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    public void modificarEmpleado(int id) {
        Scanner scanner = new Scanner(System.in);
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getId() == id) {
                System.out.println("El nombre actual es: "+empleado.getNombre()+". Ingrese el nuevo nombre: ");
                empleado.setNombre(scanner.nextLine());
                System.out.println("El sueldo base actual es: "+empleado.getSueldoBase()+". Ingrese el nuevo sueldo base: ");
                empleado.setSueldoBase(scanner.nextDouble());
                if(empleado instanceof EmpleadoPorHoras) {
                    System.out.println("El número de horas trabajadas actual es: "+((EmpleadoPorHoras)empleado).getHorasTrabajadas()+". Ingrese la nueva cantidad de horas trabajadas: ");
                    ((EmpleadoPorHoras)empleado).setHorasTrabajadas(scanner.nextInt());
                } else if (empleado instanceof EmpleadoComision){
                    System.out.println("La cantidad de ventas realizadas actual es: "+((EmpleadoComision)empleado).getVentasRealizadas()+". Ingrese la nueva cantidad correspondiente: ");
                    ((EmpleadoComision)empleado).setVentasRealizadas(scanner.nextDouble());
                }
            }
        }
    }

    public void eliminarEmpleado(int id) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getId()==id) {
                listaEmpleados.remove(empleado);
                break;
            }
        }
    }

    public void calcularSueldo(){
        int id;
        Scanner scanner=new Scanner(System.in);
        id=scanner.nextInt();
        for(Empleado empleado : listaEmpleados){
            if(empleado.getId()==id){
                System.out.println("El sueldo de "+empleado.getNombre()+" es "+empleado.calcularSueldo());
            }
        }
    }


    public ArrayList<Empleado> obtenerListaEmpleados() {
        return listaEmpleados;
    }

}
