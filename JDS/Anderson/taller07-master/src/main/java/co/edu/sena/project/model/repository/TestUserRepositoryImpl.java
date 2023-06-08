package co.edu.sena.project.model.repository;

import co.edu.sena.project.model.User;

import java.sql.*;

public class TestUserRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        Repository<User> repository = new UserRepositoryImpl();
            System.out.println("==========Save obj Insert==========");
            User userInsert = new User();
            userInsert.setid_Usuario(null);
            userInsert.settipo_usuario(null);
            userInsert.setnombre_Usuario("Sayra");
            userInsert.setapellido_Usuario("Segura");
            userInsert.setcorreo_usuario("hola@gmailcom");
            userInsert.setcontraseña_Usuario("Say27123");

            repository.SaveObj(userInsert);

            userInsert.setid_Usuario(null);
            userInsert.settipo_usuario(null);
            userInsert.setnombre_Usuario("Nicolas");
            userInsert.setapellido_Usuario("Zuñiga");
            userInsert.setcorreo_usuario("nico@gmailcom");
            userInsert.setcontraseña_Usuario("nico7123");
            repository.SaveObj(userInsert);

            System.out.println("=========listAllObj============");
            repository.listAllObj().forEach(System.out::println);
            System.out.println();

            System.out.println("==========SaveObj(Update)===========");
            User userUpdate= new User();
            userUpdate.setid_Usuario(2);
            userUpdate.settipo_usuario(null);
            userUpdate.setnombre_Usuario("Maria");
            userUpdate.setapellido_Usuario("Mar");
            userUpdate.setcontraseña_Usuario("Maria@gmail.com");
            userUpdate.setcontraseña_Usuario("Soymar123");
            repository.SaveObj(userUpdate);
            repository.listAllObj().forEach(System.out::println);
            System.out.println();

            System.out.println("=========deleteObj=========");
            repository.deleteObj(2);
            repository.listAllObj().forEach(System.out::println);
    }
}
