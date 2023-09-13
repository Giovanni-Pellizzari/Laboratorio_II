package ejemplos_primer_parcial.gestion_de_cuentas;

public class CuentaSociedad extends Cuenta {
    private String nombreEmpesa;
    private String tipoEmpesa;

    public CuentaSociedad(int numeroCuenta, String nombreEmpesa, String tipoEmpesa, float saldo) {
        super(numeroCuenta, saldo);
        this.nombreEmpesa = nombreEmpesa;
        this.tipoEmpesa = tipoEmpesa;
    }

    @Override
    public void depositar(float cantidad) {
        this.saldo += cantidad;
    }

    @Override
    public void retirar(float cantidad) {
        try {
            this.saldo-= cantidad;
        }catch (Exception e){
            System.out.println("No hay fondos suficientes");
        }
    }
    @Override
    public void mostrarInformacion() {
        System.out.println("Numero de cuenta: "+ numeroCuenta);
        System.out.println("Nombre de la Empresa: "+nombreEmpesa);
        System.out.println("Tipo de Emperesa: "+tipoEmpesa);
        System.out.println("Saldo: $"+saldo);
    }
}
