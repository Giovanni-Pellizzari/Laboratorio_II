package recursion_iteracion;

import java.util.Scanner;

public class Sumatoria {
    public static int sumatoriaRecursiva(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n + sumatoriaRecursiva(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        System.out.println("Ingrese un numero: ");
        numero = scanner.nextInt();

        int resultado = sumatoriaRecursiva(numero);
        System.out.println("La sumatoria de los números enteros hasta " + numero + " es: " + resultado);
    }
}
