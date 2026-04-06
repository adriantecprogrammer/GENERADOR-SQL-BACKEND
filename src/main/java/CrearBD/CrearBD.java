package CrearBD;

import java.sql.*;
import java.util.List;

public class CrearBD {

    public void createBD(String nombreBD) {

            String url = "jdbc:mysql://localhost:3306/";
            String usuario = "root";
            String contrasena = "adr1an2004";

            try {
                // 0. Registrar el driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // 1. Conectar al servidor MySQL
                Connection conexion = DriverManager.getConnection(url, usuario, contrasena);
                System.out.println(" Conectado al servidor MySQL");

                // 2. Crear la base de datos
                String sqlCrearBD = "CREATE DATABASE IF NOT EXISTS " + nombreBD;
                Statement statement = conexion.createStatement();
                statement.executeUpdate(sqlCrearBD);
                System.out.println(" Base de datos '" + nombreBD + "' creada o ya existe");

                // 3. Cerrar conexión inicial
                statement.close();
                conexion.close();

                System.out.println("¡Proceso completado!");

            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(" Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
        public void createTables(String nombreBD, List<String> sqlTablas){
            String url = "jdbc:mysql://localhost:3306/" + nombreBD;
            String usuario = "root";
            String contrasena = "adr1an2004";

            try {
                // 0. Registrar el driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // 1. Conectar a la base de datos específica
                Connection conexion = DriverManager.getConnection(url, usuario, contrasena);
                System.out.println(" Conectado a la BD " + nombreBD);

                Statement statement = conexion.createStatement();

                statement.execute("SET FOREIGN_KEY_CHECKS = 0");

                for (String sql : sqlTablas) {
                    statement.executeUpdate(sql);
                    System.out.println("✅ Tabla creada.");
                }

                // 4. Reactivar las llaves foráneas
                statement.execute("SET FOREIGN_KEY_CHECKS = 1");

                // 5. Cerrar conexión
                statement.close();
                conexion.close();

                System.out.println("¡Tablas creadas exitosamente!");

            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(" Error al crear tablas: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
