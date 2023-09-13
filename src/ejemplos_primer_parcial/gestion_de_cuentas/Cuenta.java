package ejemplos_primer_parcial.gestion_de_cuentas;

public abstract class Cuenta {

    //Atributos Protegidos

    protected int numeroCuenta;
    protected float saldo;

    public Cuenta(int numeroCuenta, float saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
//Metodos abstractos

    public abstract void depositar(float cantidad);

    public abstract void retirar(float cantidad);

    public abstract void mostrarInformacion();
}
