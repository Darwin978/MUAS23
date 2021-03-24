
package Modelo;


public  class Persona {
    
    //ATRIBUTOS
    
    private String Codigo;
    private String DNI;
    private String Nombres;
    private String Apellidos;
    private String Direccion;
    private String Correo;
    private String Telefono;
    private String Celular;
    private String Usuario;
    private String Clave;
    
    //CONSTRUCTORES

    public Persona() {
    }

    public Persona(String DNI) {
        this.DNI = DNI;
    }
    
    
public Persona(String Codigo, String DNI, String Nombres, String Apellidos, String Direccion, String Correo, String Telefono, String Celular, String Usuario, String Clave) {
        this.Codigo = Codigo;
        this.DNI = DNI;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Direccion = Direccion;
        this.Correo = Correo;
        this.Telefono = Telefono;
        this.Celular = Celular;
        this.Usuario = Usuario;
        this.Clave = Clave;
    }
    
    
    
    //METODOS GETTER Y SETTER

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }


    

   
}
