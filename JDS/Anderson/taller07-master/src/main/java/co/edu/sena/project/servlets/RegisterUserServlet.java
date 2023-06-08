package co.edu.sena.project.servlets;
import co.edu.sena.project.model.User;
import co.edu.sena.project.model.repository.Repository;
import co.edu.sena.project.model.repository.UserRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register-user")
public class RegisterUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //todo collect all from data

        String nombre_Usuario = request.getParameter("nombre_Usuario");
        String apellido_Usuario = request.getParameter("apellido_Usuario");
        String correo_usuario = request.getParameter("correo_usuario");
        String contraseña_Usuario = request.getParameter("contraseña_Usuario");
        String es_administrador = request.getParameter("es_administrador");
    
    //todo fill up in a User bean
        User user = new User(nombre_Usuario, apellido_Usuario, correo_usuario, contraseña_Usuario, es_administrador);
    //todo call repository layer and save the objects to BD
        Repository<User> repository = new UserRepositoryImpl();
        int rows=0;
        try{
        rows= repository.SaveObj(user);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        //todo prepare an information message for user about succes or failure of the operation
        String infoMesaage = null;
        if (rows==0){
            infoMesaage="Ocurrio un eror";
            System.out.println(infoMesaage);
        }
        else {
            System.out.println("registrado satisfactoriamente");
        }
    }
}
