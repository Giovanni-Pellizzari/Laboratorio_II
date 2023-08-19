package recursion_iteracion;

public class Factorial {
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    public static long factorial(long n,boolean iteracion) {
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(factorial(num));
        System.out.println(factorial(num,true));
    }

}
