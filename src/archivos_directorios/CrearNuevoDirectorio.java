package archivos_directorios;

import java.io.File;
import java.io.IOException;

public class CrearNuevoDirectorio {
    public static void main(String[] args) {

        /*CREAR UNA CARPETA*/

        /* al colocar en el final el nombre del directorio que queremos crear y luego mkdir creamos el directorio */
        File carpeta = new File("C:" + File.separator + "Users" + File.separator + "JOVA" + File.separator + "Desktop" + File.separator + "Carpeta_Nueva");

        carpeta.mkdir(); /*crea la carpeta*/

        /*CREAR UN ARCHIVO VACIO*/

        File archivo = new File("C:" + File.separator + "Users" + File.separator + "JOVA" + File.separator + "Desktop" + File.separator + "arhivoVacio.txt");

        try {
            archivo.createNewFile(); /*Crea el archivo nuevo*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
