package herencia_polimorfismo;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main (String[] args){
        Empleado[] empleados = new Empleado[3];
        Scanner scanner = new Scanner(System.in);
        int opc;
        int numEmpleados = 0;


        do {
            System.out.println("-------------------- MENU -----------------------");
            System.out.println("1- Ingresar personal");
            System.out.println("2- Listar empleados");
            System.out.println("3- salir");
            opc = scanner.nextInt();

            switch (opc) {
                case 1: {

                    for (int i = 0; i < empleados.length; i++) {

                        System.out.println("Nombre: ");
                        String nombre = scanner.next();

                        System.out.println("Apellido: ");
                        String apellido = scanner.next();

                        System.out.println("Antiguedad: ");
                        int antiguedad = scanner.nextInt();

                        System.out.println("Sueldo: ");
                        double sueldo = scanner.nextDouble();

                        if (antiguedad > 3) {
                            empleados[i] = new Senior_dev(nombre, apellido, antiguedad, sueldo);
                        } else {
                            empleados[i] = new Junior_dev(nombre, apellido, antiguedad, sueldo);
                        }
                        numEmpleados++;
                    }
                }
                break;
                case 2: {
                    System.out.println("Lista de empleados:");
                    System.out.println("-------------------------------------------------------------------");

                    if (numEmpleados == 0) {
                        System.out.println("No hay empleados registrados.");
                    } else {
                         for (int i = 0; i < numEmpleados; i++) {
                            System.out.println("Nombre: " + empleados[i].getNombre());
                            System.out.println("Apellido: " + empleados[i].getApellido());
                            System.out.println("Antiguedad: " + empleados[i].getAntiguedad());
                            System.out.println("Sueldo: " + empleados[i].getSueldo());

                            System.out.println("------------------------------------------------------------");
                         }
                    }
                }
                break;
                case 3: {
                    System.out.println("HASTA LA PROXIMA");
                }
                break;
            }
        }while (opc!=3);
    }
}

