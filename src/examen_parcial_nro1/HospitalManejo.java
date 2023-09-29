package examen_parcial_nro1;



import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManejo {

    private ArrayList<Pacientes> pacientes;
    private ArrayList<Doctores> doctores;

    public HospitalManejo() {
        this.pacientes = new ArrayList <>();
        this.doctores = new ArrayList <>();
    }

    public void agregarPaciente(Pacientes pacientes){
        this.pacientes.add(pacientes);
    }

    public void agregarDoctor(Doctores doctores){
        this.doctores.add(doctores);
    }

    public void listarDoctores(){
        for (Doctores doctores : doctores){
            System.out.println("Doctor/a:" + doctores.getNombre() + "- Especialidad: " + doctores.getEspecialidad());
        }
    }



    public void guardarReservasEnArchivo(String nombreArchivo) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            salida.writeObject(this);
            System.out.println("Registros guardados en archivo exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }

    public HospitalManejo cargarReservasDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (HospitalManejo) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar desde el archivo: " + e.getMessage());
            return null;
        }
    }

    public void actualizarInfo(int dni){
        Scanner scanner = new Scanner(System.in);
        for (Pacientes pacientes : pacientes){
            if (pacientes.getDni() == dni){
                System.out.println("cuantos desea ingresar:");
                int cantidad = scanner.nextInt();
                for (int i = 0; i <cantidad ; i++) {
                    for (int j = 0; j <1 ; j++) {
                        ArrayList<String> enfermedad = new ArrayList <>();
                        pacientes.setHistorialMedico(enfermedad);
                    }
                }
            }

        }

    }
}
