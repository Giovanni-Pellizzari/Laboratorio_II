package ejemplos_primer_parcial.concesionaria_de_vehiculos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Concesionaria implements Serializable {
     ArrayList<Vehiculo> inventario = new ArrayList<>();


    public void agregarVehiculo(Vehiculo vehiculo) {
        inventario.add(vehiculo);
    }

    public void eliminarVehiculo(String marca, String modelo){
        inventario.removeIf(vehiculo -> vehiculo.getMarca().equals(marca) && vehiculo.getModelo().equals(modelo));
    }

    public void mostrarInventario() {
        System.out.println("Inventario de la Concesionaria:");
        for (Vehiculo vehiculo : inventario) {
            vehiculo.mostrarInformacion();
        }
    }

    public void editarPrecio(String marca, String modelo, double nuevoPrecio){
        Scanner scanner = new Scanner(System.in);
        for (Vehiculo vehiculo : inventario){
            if (vehiculo.getMarca().equals(marca) && vehiculo.getModelo().equals(modelo)){
                System.out.print("ingrese el nuevo valor: $");
                nuevoPrecio = scanner.nextDouble();
                vehiculo.setPrecio(nuevoPrecio);
            }
        }
    }


    @Override
    public void guardar(String nombreArchivo) throws IOException{
        try {
            ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            // Escribe el objeto en un archivo
            flujoSalida.writeObject(inventario);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void cargar(String nombreArchivo){
        try  {
            ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream(nombreArchivo));
            Vehiculo concesionariaEntrada = (Vehiculo) flujoEntrada.readObject();
            System.out.println(concesionariaEntrada.toString());

            System.out.println("Concesionaria cargada desde " + nombreArchivo);
        }catch (IOException e){
             e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
