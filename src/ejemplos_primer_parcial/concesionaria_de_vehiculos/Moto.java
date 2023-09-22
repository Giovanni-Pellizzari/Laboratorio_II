package ejemplos_primer_parcial.concesionaria_de_vehiculos;

public class Moto extends Vehiculo{

    public Moto(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }

    @Override
    public void calcularimpuesto() {
        double impuesto = precio * 0.1;
        System.out.println("el valor de los impuestos a pagar sobre este vehiculo es de: $" + impuesto);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("[MARCA]:" + marca + " / " + "[MODELO]:" + modelo + " / " + "[PRECIO]:" + precio );
    }
}
