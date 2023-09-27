package archivos_directorios;

import java.io.File;

public class ListarArchivo {
    public static void main(String[] args) {

        /*Usamos el constructor que nos pide el patch
         * Usamos File.separator para que traiga el separador de carpetas
         * sin problemas
         * */
        File directorio = new File("/Users/JOVA/Desktop/Laboratorio_II");

        String [] nombres = directorio.list();

        // lista todos los elementos que se enceuntran en la carpeta
        System.out.println("Listado de archivos:");

        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }
}
