package co.edu.sena.project.ConnectionTest;

import java.sql.*;

public class UseBasicConnectionSingleton {
    public static void main(String[] args) throws
            SQLException {
        try (Connection conn = BasicConnectionSingleton.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM usuario.usuarios")) {
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
    } // end try
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
} // UseBasicConnectionSingleton