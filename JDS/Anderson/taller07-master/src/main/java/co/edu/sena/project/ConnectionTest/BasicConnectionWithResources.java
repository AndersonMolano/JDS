package co.edu.sena.project.ConnectionTest;

import java.sql.*;

public class BasicConnectionWithResources {

    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3307/usuario?serverTimezone=America/Bogota";
        String username = "root";
        String password = "";
        String sql = "SELECT * FROM usuario.usuarios";
        try (Connection conn =
                     DriverManager.getConnection(url,
                             username, password);
             Statement stmt =
                     conn.createStatement();
             ResultSet rs =
                     stmt.executeQuery(sql)) {
            while (rs.next()) {

                System.out.print(rs.getString("nombre_usuario"));
                System.out.print(" | ");

                System.out.print(rs.getString("apellido_usuario"));
                System.out.print(" | ");

                System.out.print(rs.getString("correo_usuario"));
                System.out.print(" | ");

                System.out.print(rs.getString("contraseña_Usuario"));
                System.out.print(" | ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } // end try-catch
    } // main
} // BasicConnectionWithResources
