package recursion_iteracion;

public class Division {
    public static float division(double dividendo, double divisor) {
        int cociente = 0;

        while (dividendo >= divisor) {
            dividendo -= divisor;
            cociente++;
        }
        return cociente;
    }
    public static int division(int dividendo, int divisor) {
        if (dividendo < divisor) {
            return 0;
        } else {
            return 1 + division(dividendo - divisor, divisor);
        }
    }

    public static void main(String[] args) {

        System.out.println(division(50,2));
        System.out.println(division(40.4,2.2));

    }


}
