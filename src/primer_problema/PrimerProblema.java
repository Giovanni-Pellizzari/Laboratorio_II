package primer_problema;

import java.util.Scanner;

public class PrimerProblema {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);


        System.out.print("ingrese el primer número: ");
        int primerNum = scanner.nextInt();
        System.out.print("ingrese el segundo número: ");
        int segundoNum = scanner.nextInt();
        System.out.print("ingrese el tercer número: ");
        int tercerNum = scanner.nextInt();

        if (primerNum > segundoNum){
            if (primerNum > tercerNum){
                if (segundoNum > tercerNum){
                    System.out.println("el orden de mayor a menor es el siguiente: "+ primerNum+ ", " + segundoNum + ", " + tercerNum);
                }else{
                    System.out.println("el orden de mayor a menor es el siguiente: "+ primerNum+ ", " + tercerNum + ", " + segundoNum);
                }
            }else{
                System.out.println("el orden de mayor a menor es el siguiente: "+ tercerNum+ ", " + primerNum + ", " + segundoNum);
            }
        }else{
            if(segundoNum > tercerNum){
                if(tercerNum > primerNum){
                    System.out.println("el orden de mayor a menor es el siguiente: "+ segundoNum+ ", " + tercerNum + ", " + primerNum);
                }else{
                    System.out.println("el orden de mayor a menor es el siguiente: "+ segundoNum+ ", " + primerNum + ", " + tercerNum);
                }
            }else{
                System.out.println("el orden de mayor a menor es el siguiente: "+ tercerNum+ ", " + segundoNum + ", " + primerNum);

            }
        }

    }
}

