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
                FileOutputStream fileOutputStream = new FileOutputStream("fichero2.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(inventario);
                objectOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }


    @Override
    public void cargar(String nombreArchivo){
        try  {
            FileInputStream fileInputStream = new FileInputStream("fichero2.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Vehiculo inventarios = (Vehiculo) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("Concesionaria cargada desde " + nombreArchivo);
        }catch (IOException e){
             e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
