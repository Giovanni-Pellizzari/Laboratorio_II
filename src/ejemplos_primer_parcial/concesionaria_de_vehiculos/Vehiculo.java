package ejemplos_primer_parcial.concesionaria_de_vehiculos;

public abstract class Vehiculo {
    String marca;
    String modelo;
    double precio;

    public Vehiculo(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public abstract void calcularimpuesto();
    public abstract void mostrarInformacion();

}
