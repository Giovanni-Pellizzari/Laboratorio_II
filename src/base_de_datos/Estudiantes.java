package base_de_datos;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Estudiantes {
    public static void main(String[] args) {

        String url = "jdbc:mariadb://localhost:33061/universidad";
        String usuario = "root";
        String pass = "argentina30bolivia";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, pass);


            Statement statement = conexion.createStatement();


            String consulta = "SELECT * FROM estudiantes";
            ResultSet resultado = statement.executeQuery(consulta);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String legajo = resultado.getString("legajo");
                String dni = resultado.getString("dni");

                System.out.println("ID: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("Legajo: " + legajo);
                System.out.println("DNI: " + dni);
                System.out.println("-----------------------");
            }

            resultado.close();
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
