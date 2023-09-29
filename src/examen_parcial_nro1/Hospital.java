package examen_parcial_nro1;

import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int opc;

        HospitalManejo hospitalManejo = new HospitalManejo();

        hospitalManejo.agregarDoctor(new Doctores("Juan",43234525,11031990,"Clinica"));
        hospitalManejo.agregarDoctor(new Doctores("Julia", 42444332,21011988,"Cirujia"));
        hospitalManejo.agregarDoctor(new Doctores("Agustina",43933727, 21012002,"Pediatra"));

        do {
            System.out.println("Hospital Julio C. Perrando - Av. 9 de Julio 1100 . 0362 444-2399");
            System.out.println("Menú: ");
            System.out.println("1- Listar Doctores");
            System.out.println("2- Registrar un nuevo paciente");
            System.out.println("3- Actualizar informacion personal de un paciente");
            System.out.println("4- Consultar el historial medico de un paciente");
            System.out.println("5- Guardar el historial de pacientes en archivo");
            System.out.println("6- Cargar historial de pacientes desde archivo");
            System.out.println("7- Salir");
            System.out.println("Ingrese una opcion");
            opc = scanner.nextInt();

            switch (opc){
                case 1:
                    hospitalManejo.listarDoctores();
                break;
                case 2:
                    System.out.println("ingrese los datos del paciente");
                    System.out.println("Nombre:");
                    String nombre = scanner.next();
                    System.out.println("DNI:");
                    int dni = scanner.nextInt();
                    System.out.println("Fecha de nacimiento DD/MM/AAAA:");
                    int fechaDeNacimiento = scanner.nextInt();
                    System.out.println("Numero de telefono:");
                    int numeroDeTelefono = scanner.nextInt();
                    System.out.println("Tipo de sangre:");
                    int tipoDeSangre = scanner.nextInt();
                    System.out.println("¿Tiene antecedentes medicos que declarar? 1: si  /  2: no");
                    int sino = scanner.nextInt();
                    if (sino <= 1){
                        System.out.println("¿Cuantos Ingresos desea declarar?");
                        int ingresos = scanner.nextInt();
                        for (int i = 0; i < ingresos; i++) {
                            System.out.println("Enfermedad:");
                            for (int j = 0; j < 1 ; j++) {
                                ArrayList<String> enfermedad = new ArrayList <>();
                                enfermedad.add(scanner.next());
                                hospitalManejo.agregarPaciente(new Pacientes(nombre,dni,fechaDeNacimiento,numeroDeTelefono,tipoDeSangre,enfermedad));
                            }
                        }
                    }else {
                            hospitalManejo.agregarPaciente(new Pacientes(nombre,dni,fechaDeNacimiento,numeroDeTelefono,tipoDeSangre,null));
                    }
                break;
                case 3:
                    System.out.println("ingrese dni:");
                    int dniactualizar = scanner.nextInt();
                    hospitalManejo.actualizarInfo(dniactualizar);

                break;
                case 4:
                    System.out.println("4");
                break;
                case 5:
                    hospitalManejo.guardarReservasEnArchivo("nombreDelArchivo");
                break;
                case 6:
                    hospitalManejo.cargarReservasDesdeArchivo("nombreDelArchivo");
                break;
                case 7:
                    System.out.println("hasta luego");
                return;

                default:
                    System.out.println("Opcion invalida");
            }
        }while (opc <= 7);
    }
}
