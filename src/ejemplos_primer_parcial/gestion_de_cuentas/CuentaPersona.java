package ejemplos_primer_parcial.gestion_de_cuentas;

public class CuentaPersona extends Cuenta{
    private String nombre;
    private String apellido;

    public CuentaPersona(int numeroCuenta, String nombre, String apellido, float saldo) {
        super(numeroCuenta, saldo);
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void depositar(float cantidad) {
        this.saldo+= cantidad;
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
        System.out.println("Nombre: "+nombre);
        System.out.println("Apellido: "+apellido);
        System.out.println("Saldo: $"+saldo);
    }
}
