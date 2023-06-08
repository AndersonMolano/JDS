package co.edu.sena.project.ConnectionTest;

import java.sql.*;

public class BasicConnection {
        public static void main(String[] args)
        {
            String url = "jdbc:mysql://localhost:3307/usuario?serverTimezone=America/Bogota";
            String username = "root";
            String password = "";
            String sql = null;
            Connection conn = null; 
            Statement stm = null;
            ResultSet rs = null;
            try {
                sql = "SELECT * FROM usuario.usuarios";
                conn = DriverManager.getConnection(url,
                                username, password);
                stm = conn.createStatement();
                rs = stm.executeQuery(sql);
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
            } finally {
                try {
                    rs.close();
                    stm.close();
                    conn.close();   
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }// end try-catch
        } // main
    } // BasicConnection

