package ejemplos_primer_parcial;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManipulacionArraylit {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> miLista = new ArrayList<>();

        miLista.add(1);
        miLista.add(2);
        miLista.add(3);
        miLista.add(4);
        miLista.add(5);

       // Manejo de excepciones usando try-catch
        try {
            System.out.println("agrega un numero entero: ");
            miLista.add(scanner.nextInt());

            System.out.println("ingrese la posicion que desea visualizar: ");
            int posicion = scanner.nextInt();
            System.out.println(miLista.get(posicion));

            System.out.println("ingese el indice que desea eliminar: ");
            int indice = scanner.nextInt();
            miLista.remove(indice);
            System.out.println(miLista);

        }catch (InputMismatchException e){
            System.out.println("Error,parameto equivocado!!!");
        }catch (IndexOutOfBoundsException e){
            System.out.println("Error, indice fuera de rango");
        }
    }
}
