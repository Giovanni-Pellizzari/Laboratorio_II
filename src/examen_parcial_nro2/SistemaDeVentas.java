package examen_parcial_nro2;

import java.sql.*;
import java.util.ArrayList;

public class SistemaDeVentas {

    class DBHelper {
        private static final String URL = "jdbc:mysql://localhost:3306/ventas";
        private static final String USER = "root";
        private static final String PASSWORD = "your_password";

        public static void ejecutarConsulta(String consulta) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establecer la conexión con la base de datos
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

                // Crear la declaración
                try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                    // Ejecutar la consulta
                    statement.executeUpdate();
                }

                // Cerrar la conexión
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        public static ResultSet ejecutarConsultaConResultado(String consulta) {
            try {

                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

                PreparedStatement statement = connection.prepareStatement(consulta);

                return statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

static class Producto {
    private int producto_id;
    private String nombre;
    private double precio_por_unidad;
    private int stock;

    // Constructor
    public Producto(int producto_id, String nombre, double precio_por_unidad, int stock) {
        this.producto_id = producto_id;
        this.nombre = nombre;
        this.precio_por_unidad = precio_por_unidad;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "producto_id=" + producto_id +
                ", nombre='" + nombre + '\'' +
                ", precio_por_unidad=" + precio_por_unidad +
                ", stock=" + stock +
                '}';
    }
}

class Productos {

    /* 5. Generaci�n de Informe de Productos en Stock (2 p.) */
    public static void generarInforme() {

        String consulta = "SELECT * FROM productos";

        try (ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta)) {
            if (resultado != null) {
                System.out.println("Informe de Productos en Stock:");
                System.out.printf("%-30s%-8s%-10s%-5s\n", "Producto", "Stock", "Precio", "Total");
                System.out.println("----------------------------------------------------------");
                double valorTotalDeProductos = 0;
                while (resultado.next()) {
                    String nombre = resultado.getString("nombre");
                    int stock = resultado.getInt("stock");
                    double precioPorUnidad = resultado.getDouble("precio_por_unidad");
                    double valorTotal = stock * precioPorUnidad;
                    valorTotalDeProductos += valorTotal;
                    System.out.printf("%-30s%-8d%-10.2f%-15.2f\n", nombre, stock, precioPorUnidad, valorTotal);
                }
                System.out.println("----------------------------------------------------------");
                System.out.printf("%-30s%-8s%-10s%-5.2f\n", "", "", "Total:", valorTotalDeProductos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* 6. Obtener Producto por ID (1 p.) */
    public static Producto obtenerProducto(int productoID) {

        String consultaProducto = "SELECT * FROM productos WHERE producto_id = " + productoID;

        try (ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consultaProducto)) {
            if (resultado != null && resultado.next()) {
                int producto_id = resultado.getInt("producto_id");
                String nombre = resultado.getString("nombre");
                double precio_por_unidad = resultado.getDouble("precio_por_unidad");
                int stock = resultado.getInt("stock");

                return new Producto(producto_id, nombre, precio_por_unidad, stock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    /* 7. Obtener el Producto M�s Vendido (2 p.) */
    public static Producto obtenerProductoMasVendido() {
        String consultaVentas = "SELECT producto_id, SUM(cantidad_vendida) as total_vendido \n" +
                "FROM ventas\n" +
                "GROUP BY producto_id\n" +
                "ORDER BY total_vendido DESC\n" +
                "LIMIT 1";

        try (ResultSet resultadoVentas = DBHelper.ejecutarConsultaConResultado(consultaVentas)) {
            if (resultadoVentas != null && resultadoVentas.next()) {
                int producto_id = resultadoVentas.getInt("producto_id");
                return obtenerProducto(producto_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}


static class Vendedor {
    private int vendedor_id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fecha_nacimiento;
    private Date fecha_contratacion;

    public Vendedor(int vendedor_id, String nombre, String apellido, String dni, Date fecha_nacimiento, Date fecha_contratacion) {
        this.vendedor_id = vendedor_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_contratacion = fecha_contratacion;
    }

    public int getVendedor_id() {
        return vendedor_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public Date getFecha_contratacion() {
        return fecha_contratacion;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "vendedor_id=" + vendedor_id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", fecha_contratacion=" + fecha_contratacion +
                '}';
    }

    public Vendedor(String consultaBusqueda) {
        try (ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consultaBusqueda)) { // Realizar la consulta para obtener los datos del vendedor por ID
            if (resultado != null && resultado.next()) {
                this.vendedor_id = resultado.getInt("vendedor_id");
                this.nombre = resultado.getString("nombre");
                this.apellido = resultado.getString("apellido");
                this.dni = resultado.getString("dni");
                this.fecha_nacimiento = resultado.getDate("fecha_nacimiento");
                this.fecha_contratacion = resultado.getDate("fecha_contratacion");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class Venta {
    private int venta_id;
    private int vendedor_id;
    private int producto_id;
    private int cantidad_vendida;
    private Date fecha_venta;

    // Constructor
    public Venta(int venta_id, int vendedor_id, int producto_id, int cantidad_vendida, Date fecha_venta) {
        this.venta_id = venta_id;
        this.vendedor_id = vendedor_id;
        this.producto_id = producto_id;
        this.cantidad_vendida = cantidad_vendida;
        this.fecha_venta = fecha_venta;
    }

}


class Comerciales{

    /* 4. Obtener los datos de un Vendedor (1,5 p.) */
    public static Vendedor obtenerVendedorPorID(int vendedorID) {
        String consulta = "SELECT * FROM vendedores WHERE vendedor_id = " + vendedorID;

        try (ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta)) {
            if (resultado != null && resultado.next()) {
                int vendedor_id = resultado.getInt("vendedor_id");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String dni = resultado.getString("dni");
                Date fecha_nacimiento = resultado.getDate("fecha_nacimiento");
                Date fecha_contratacion = resultado.getDate("fecha_contratacion");

                return new Vendedor(vendedor_id, nombre, apellido, dni, fecha_nacimiento, fecha_contratacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /* 8. Obtener el Listado de Vendedores (2 p.) */
    public static ArrayList<Vendedor> listadoDeVendedores() {
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        String consulta = "SELECT * FROM vendedores";

        try (ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta)) {
            while (resultado != null && resultado.next()) {
                int vendedor_id = resultado.getInt("vendedor_id");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String dni = resultado.getString("dni");
                Date fecha_nacimiento = resultado.getDate("fecha_nacimiento");
                Date fecha_contratacion = resultado.getDate("fecha_contratacion");

                Vendedor vendedor = new Vendedor(vendedor_id, nombre, apellido, dni, fecha_nacimiento, fecha_contratacion);
                vendedores.add(vendedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vendedores;
    }

}
    public static void main(String[] args)  {


        System.out.println("\n2. Creaci�n de las Clases Producto y Vendedor");
        Producto producto1 = new Producto(1, "Producto 1", 10, 100);
        System.out.println(producto1);
        Vendedor vendedor1 = new Vendedor(1, "Vendedor 1", "Apellido 1", "12345678A", Date.valueOf("1990-01-01"), Date.valueOf("2010-01-01"));
        System.out.println(vendedor1);

        System.out.println("\n3. Creaci�n de un Constructor Adicional en la clase Vendedor");
        Vendedor vendedor2 = new Vendedor("SELECT * FROM vendedores WHERE vendedor_id = 2");
        System.out.println(vendedor2);

        System.out.println("\n4. Obtener un vendedor por ID:");
        Vendedor vendedorObjeto = Comerciales.obtenerVendedorPorID(2);
        System.out.println(vendedorObjeto);

        System.out.println("\n5. Generar Informe de Productos en Stock:");
        Productos.generarInforme();

        System.out.println("\n6. Obtener un producto por ID:");
        Producto producto = Productos.obtenerProducto(1);
        System.out.println(producto);

        System.out.println("\n7. Obtener el producto m�s vendido:");
        Producto productoObjeto = Productos.obtenerProductoMasVendido();
        System.out.println(productoObjeto);

        System.out.println("\n8. Listado de vendedores:");
        ArrayList<Vendedor> vendedores = Comerciales.listadoDeVendedores();
        for (Vendedor vendedor : vendedores) {
            System.out.println(vendedor);
        }




    }
}








