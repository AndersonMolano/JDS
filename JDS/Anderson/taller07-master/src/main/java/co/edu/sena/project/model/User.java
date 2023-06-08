package co.edu.sena.project.model;
public class User {
        private Integer id_Usuario;
        private Enum tipo_usuario;
        private String nombre_Usuario;
        private String apellido_Usuario;
        private String correo_usuario;
        private String contraseña_Usuario;
        private String es_administrador;
    public User() {
    }

    public User(Integer id_Usuario, Enum tipo_usuario, String nombre_Usuario, String apellido_Usuario, String correo_usuario, String contraseña_Usuario, String es_administrador) {
        this.id_Usuario = id_Usuario;
        this.tipo_usuario = tipo_usuario;
        this.nombre_Usuario = nombre_Usuario;
        this.apellido_Usuario = apellido_Usuario;
        this.correo_usuario = correo_usuario;
        this.contraseña_Usuario = contraseña_Usuario;
        this.es_administrador = es_administrador;
    }

    public User(String nombre_Usuario, String apellido_Usuario, String correo_usuario, String contraseña_Usuario, String es_administrador) {
        this.nombre_Usuario = nombre_Usuario;
        this.apellido_Usuario = apellido_Usuario;
        this.correo_usuario = correo_usuario;
        this.contraseña_Usuario = contraseña_Usuario;
        this.es_administrador = es_administrador;
    }

    public Integer getid_Usuario() {
        return id_Usuario;
    }

    public void setid_Usuario(Integer id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public Enum gettipo_usuario() {
        return tipo_usuario;
    }

    public void settipo_usuario(Enum tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getnombre_Usuario() {
        return nombre_Usuario;
    }

    public void setnombre_Usuario(String nombre_Usuario) {
        this.nombre_Usuario = nombre_Usuario;
    }

    public String getapellido_Usuario() {
        return apellido_Usuario;
    }

    public void setapellido_Usuario(String apellido_Usuario) {
        this.apellido_Usuario = apellido_Usuario;
    }

    public String getcorreo_usuario() {
        return correo_usuario;
    }

    public void setcorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public String getcontraseña_Usuario() {
        return contraseña_Usuario;
    }

    public void setcontraseña_Usuario(String Contraseña_Usuario) {
        this.contraseña_Usuario = correo_usuario;
    }
    public String getes_administrador() {
        return es_administrador;
    }

    public void setes_administrador(String es_administrador) {
        this.es_administrador = es_administrador;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_Usuario=" + id_Usuario +
                ", tipo_Usuario='" + tipo_usuario + '\'' +
                ", nombre_Usuario='" + nombre_Usuario + '\'' +
                ", apellido_Usuario='" + apellido_Usuario + '\'' +
                ", correo_usuario='" + correo_usuario + '\'' +
                ", contraseña_Usuario='" + contraseña_Usuario + '\'' +
                ", es_administrador='" + es_administrador + '\'' +
                '}';
    }
}

