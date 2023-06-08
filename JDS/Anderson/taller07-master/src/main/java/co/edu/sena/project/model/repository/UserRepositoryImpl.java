package co.edu.sena.project.model.repository;
import co.edu.sena.project.model.User;
import co.edu.sena.project.ConnectionTest.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements Repository<User>{

    private String sql = null;

    @Override
    public List<User> listAllObj() throws SQLException {
        sql = "select id_Usuario, tipo_usuario, nombre_Usuario, apellido_Usuario, correo_usuario, contraseña_Usuario, es_administrador from usuarios order by id_Usuario;";
        List<User> users = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                User u = createObj(rs);
                users.add(u);
            }
        }
        return users;
    }

    @Override
    public User byIdObj(Integer id) throws SQLException {
        sql = "select id_Usuario, tipo_usuario, nombre_Usuario, apellido_Usuario, correo_usuario, contraseña_Usuario,es_administrador from usuarios where id_Usuario = ?;";
        User user = null;

        try (
                Connection conn = ConnectionPool.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    user = createObj(rs);
                }
            }
        }
        return user;
    }

    @Override
    public Integer SaveObj(User user) throws SQLException {
        int rowsAffected = 0;

        if(user.getid_Usuario() != null && user.getid_Usuario() > 0){
            sql = "update usuarios set id_Usuario = ?, tipo_usuario = ?, nombre_Usuario = ?, apellido_Usuario = ?, correo_usuario = ?, contraseña_Usuario = ? , es_administrador = ?";
        } else{
            sql = "insert into usuarios (id_Usuario, tipo_usuario, nombre_Usuario, apellido_Usuario, correo_usuario, contraseña_Usuario,  es_administrador) values ( upper(?), upper(?), lower(?)))";
        }

        try(Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, user.getnombre_Usuario());
            ps.setString(2, user.getapellido_Usuario());
            ps.setString(3, user.getcorreo_usuario());
            ps.setString(4, user.getcontraseña_Usuario());
            if(user.getid_Usuario() != null && user.getid_Usuario() > 0){
                ps.setInt(5, user.getid_Usuario());
            }

            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql = "delete from users_tbl where user_id = ?";
        try(Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    @Override
    public User createObj(ResultSet rs) throws SQLException {
        User user = new User();
        user.setid_Usuario(rs.getInt("id_Usuario"));
        user.setnombre_Usuario(rs.getString("nombre_Usuario"));
        user.setapellido_Usuario(rs.getString("apellido_Usuario"));
        user.setcorreo_usuario(rs.getString("correo_usuario"));
        user.setcontraseña_Usuario(rs.getString("contraseña_Usuario"));
        return user;    }
}
