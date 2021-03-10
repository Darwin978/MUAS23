
package Modelo;


public class Empleado extends Persona{
    
    //ATRIBUTOS
     private String Cargo;
     private double Sueldo;
    
     //CONSTRUCTOR

    public Empleado(String Cargo, double Sueldo, String Codigo, String DNI, String Nombres, String Apellidos, String Direccion, String Correo, String Telefono, String Celular, String Usuario, String Clave) {
        super(Codigo, DNI, Nombres, Apellidos, Direccion, Correo, Telefono, Celular, Usuario, Clave);
        this.Cargo = Cargo;
        this.Sueldo = Sueldo;
    }

    //Metodos getter y setter

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(double Sueldo) {
        this.Sueldo = Sueldo;
    }
    
    
     
     
    
    
    
}
