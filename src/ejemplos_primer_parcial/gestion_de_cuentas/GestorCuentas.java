package ejemplos_primer_parcial.gestion_de_cuentas;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorCuentas {

    ArrayList<CuentaPersona> cuentaPersonas = new ArrayList<>();
    ArrayList<CuentaSociedad> cuentaSociedades = new ArrayList<>();


    public void agregarCuentaPersona(CuentaPersona cuenta){
        cuentaPersonas.add(cuenta);
    }

    public void agregarCuentaSociedad(CuentaSociedad cuenta){
        cuentaSociedades.add(cuenta);
    }

    public void eliminarCuentaPersona(int numeroCuenta){
        for (CuentaPersona cuentaPersona: cuentaPersonas) {
            if (cuentaPersona.getNumeroCuenta() == numeroCuenta) {
                cuentaPersonas.remove(cuentaPersona);
                break;
            }
        }
    }

    public void eliminarCuentaSociedad(int numeroCuenta){
        for (CuentaSociedad cuentaSociedad: cuentaSociedades){
            if(cuentaSociedad.getNumeroCuenta() == numeroCuenta){
               cuentaSociedades.remove(cuentaSociedad);
               break;
            }
        }
    }

    public void editarCuentaPersona(int numeroCuenta, float nuevoSaldo){
        for (CuentaPersona cuentaPersona: cuentaPersonas) {
            Scanner scanner = new Scanner(System.in);
            if (cuentaPersona.getNumeroCuenta() == numeroCuenta) {
                System.out.print("INGRESE EL NUEVO SALDO: $");
                nuevoSaldo = scanner.nextFloat();
                cuentaPersona.setSaldo(nuevoSaldo);
            }
        }
    }

    public void editarCuentaSociedad(int numeroCuenta, float nuevoSaldo){
        for (CuentaSociedad cuentaSociedad: cuentaSociedades){
            Scanner scanner = new Scanner(System.in);
            if (cuentaSociedad.getNumeroCuenta() == numeroCuenta){
                System.out.println("INGRESE EL NUEVO SALDO: $");
                nuevoSaldo = scanner.nextFloat();
                cuentaSociedad.setSaldo(nuevoSaldo);
            }
        }
    }

    public void mostrarTodasLasCuentas(){
        for (CuentaSociedad cuentaSociedad: cuentaSociedades){
          cuentaSociedad.mostrarInformacion();
        }
        for (CuentaPersona cuentaPersona: cuentaPersonas){
            cuentaPersona.mostrarInformacion();
        }
    }

}
