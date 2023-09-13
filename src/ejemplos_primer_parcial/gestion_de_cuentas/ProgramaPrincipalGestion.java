package ejemplos_primer_parcial.gestion_de_cuentas;

import java.util.Scanner;

public class ProgramaPrincipalGestion {
    public static void main(String[] args){

        GestorCuentas gestor = new GestorCuentas();
        Scanner scanner = new Scanner(System.in);

         while (true){
             System.out.println("-------------MENU-------------");
             System.out.println("1- Agregar cuenta de PERSONA");
             System.out.println("2- Agregar cuenta de SOCIEDAD");
             System.out.println("3- Listar las cuentas");
             System.out.println("4- Eliminar cuenta PERSONA");
             System.out.println("5- Eliminar cuenta SOCIEDAD");
             System.out.println("6- Editar cuenta PERSONA");
             System.out.println("7- Editar cuenta SOCIEDAD");
             System.out.println("8- Fin");

             System.out.println("Ingrese una opcion: ");
             int opcion = scanner.nextInt();

             switch (opcion) {
                 case 1:
                     try {
                        System.out.println("agregue la cuenta: ");
                        System.out.println("Nro de cuenta, Nombre, Apellido, Deposito inicial");
                        gestor.agregarCuentaPersona(new CuentaPersona(scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextFloat()));
                     }catch (Exception e){
                        System.out.println("Un parametro es incorrecto");
                     }
                     break;
                 case 2:
                     try {
                        System.out.println("agregue la cuenta: ");
                        System.out.println("Nro de cuenta, Empresa, Tipo, Deposito inicial");
                        gestor.agregarCuentaSociedad(new CuentaSociedad(scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextFloat()));
                     }catch (Exception e){
                        System.out.println("Un parametro es incorrecto");
                     }
                     break;
                 case 3:
                        System.out.println("-------------LISTADO DE CUENTAS-------------");
                        gestor.mostrarTodasLasCuentas();
                        break;
                 case 4:
                     try {
                        System.out.println("Ingrese el Nro de cuenta de la cuenta que desea eliminar: ");
                        gestor.eliminarCuentaPersona(scanner.nextInt());
                     }catch (Exception e){
                        System.out.println("El Nro de cuenta es incorrecto");
                     }
                     break;
                 case 5:
                     try {
                        System.out.println("Ingrese el Nro de cuenta de la cuenta que desea eliminar: ");
                        gestor.eliminarCuentaSociedad(scanner.nextInt());
                     }catch (Exception e){
                        System.out.println("El Nro de cuenta es incorrecto");
                     }
                     break;
                 case 6:
                     try {
                        System.out.println("Ingrese el Nro de cuenta de la cuenta que desea editar y seguido a ello, ingrese el nuevo saldo: ");
                        gestor.editarCuentaPersona(scanner.nextInt(),scanner.nextFloat());
                     }catch (Exception e){
                        System.out.println("El Nro de cuenta es incorrecto");
                     }
                     break;
                 case 7:
                     try {
                        System.out.println("Ingrese el Nro de cuenta de la cuenta que desea editar y seguido a ello, ingrese el nuevo saldo: ");
                        gestor.editarCuentaSociedad(scanner.nextInt(),scanner.nextFloat());
                     }catch (Exception e){
                        System.out.println("El Nro de cuenta es incorrecto");
                     }
                     break;
                 case 8:
                     return;
             }
        }
    }
}
