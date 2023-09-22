package ejemplos_primer_parcial.concesionaria_de_vehiculos;

import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args){

        Concesionaria concesionaria = new Concesionaria();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("-------------MENU-------------");
            System.out.println("1- Agregar Auto");
            System.out.println("2- Agregar Moto");
            System.out.println("3- Eliminar");
            System.out.println("4- Editar");
            System.out.println("5- Listar ");
            System.out.println("6- Guardar");
            System.out.println("7- Cargar ");
            System.out.println("8- Fin");


            System.out.println("Ingrese una opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    try {
                        System.out.println("ingrese los datos: MARCA - MODELO - PRECIO");
                        concesionaria.agregarVehiculo(new Coche(scanner.next(), scanner.next(), scanner.nextDouble()));
                    }catch (Exception e){
                        System.out.println("Un parametro es incorrecto");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("ingrese los datos: MARCA - MODELO - PRECIO");
                        concesionaria.agregarVehiculo(new Moto(scanner.next(), scanner.next(), scanner.nextDouble()));
                    }catch (Exception e){
                        System.out.println("Un parametro es incorrecto");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Ingrese la marca y el modelo que desea eliminar: ");
                        concesionaria.eliminarVehiculo(scanner.next(), scanner.next());
                    }catch (Exception e){
                        System.out.println("Un parametro es incorrecto");
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Ingrese la marca y el modelo que desea editar y por ultimo su nuevo valor: ");
                        concesionaria.editarPrecio(scanner.next(), scanner.next(), scanner.nextDouble());
                    }catch (Exception e){
                        System.out.println("Parametro incorrecto");
                    }
                    break;
                case 5:
                    try {
                        concesionaria.mostrarInventario();
                    }catch (Exception e){
                        System.out.println("El Nro de cuenta es incorrecto");
                    }
                    break;
                case 6:
                    try {
                        concesionaria.guardar("fichero.txt");
                    }catch (Exception e){
                        System.out.println("El Nro de cuenta es incorrecto");
                    }
                    break;
                case 7:
                    try {
                        concesionaria.cargar("fichero.txt");
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
