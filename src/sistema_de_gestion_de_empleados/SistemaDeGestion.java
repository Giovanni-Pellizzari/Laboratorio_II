package sistema_de_gestion_de_empleados;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeGestion {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();

        while (true) {
            System.out.println("Menú Principal:");
            System.out.println("1. Agregar Empleado");
            System.out.println("2. Modificar Empleado");
            System.out.println("3. Eliminar Empleado");
            System.out.println("4. Calcular Sueldo e Impuesto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarEmpleado(scanner, gestor);
                    break;

                case 2:
                    System.out.println("\nIngrese el id del empleado que quiere modificar: ");
                    try{
                        gestor.modificarEmpleado(scanner.nextInt());
                    } catch(Exception e) {
                        break;
                    }
                case 3:
                    System.out.println("\nIngrese el id del empleado que quiere eliminar: ");
                    try{
                        gestor.eliminarEmpleado(scanner.nextInt());
                    } catch(Exception e){
                        break;
                    }
                case 4:
                    System.out.println("\nIngrese el id del empleado del que quiere calcular el sueldo:");
                    gestor.calcularSueldo();
                    break;

                case 5:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
    private static void agregarEmpleado(Scanner scanner, GestorEmpleados gestor) {
        System.out.println("Seleccione el tipo de empleado:");
        System.out.println("1. Empleado por Horas");
        System.out.println("2. Empleado Asalariado");
        System.out.println("3. Empleado de Comisión");
        System.out.print("Ingrese el número correspondiente: ");
        int tipoEmpleado = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del empleado: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese el sueldo base del empleado: ");
        double sueldoBase = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        switch (tipoEmpleado) {
            case 1:
                System.out.print("Ingrese las horas trabajadas: ");
                int horasTrabajadas = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                Empleado empleadoPorHoras = new EmpleadoPorHoras(nombre, id, sueldoBase, horasTrabajadas);
                gestor.agregarEmpleado(empleadoPorHoras);
                System.out.println("Empleado por Horas agregado con éxito.");
                break;

            case 2:
                Empleado empleadoAsalariado = new EmpleadoAsalariado(nombre, id, sueldoBase);
                gestor.agregarEmpleado(empleadoAsalariado);
                System.out.println("Empleado Asalariado agregado con éxito.");
                break;

            case 3:
                System.out.print("Ingrese las ventas realizadas: ");
                double ventasRealizadas = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea
                Empleado empleadoComision = new EmpleadoComision(nombre, id, sueldoBase, ventasRealizadas);
                gestor.agregarEmpleado(empleadoComision);
                System.out.println("Empleado de Comisión agregado con éxito.");
                break;

            default:
                System.out.println("Tipo de empleado no válido.");
                break;
        }
    }
}
