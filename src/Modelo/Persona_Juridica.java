
package Modelo;


public class Persona_Juridica extends Persona{
    
    //Atributos
    
    private String Razon_social;
    private  int Socios;
    
    //Constructor

    public Persona_Juridica() {
    }

    public Persona_Juridica(String DNI) {
        super(DNI);
    }

    
    
    public Persona_Juridica(String Razon_social, int Socios, String Codigo, String DNI, String Nombres, String Apellidos, String Direccion, String Correo, String Telefono, String Celular, String Usuario, String Clave) {
        super(Codigo, DNI, Nombres, Apellidos, Direccion, Correo, Telefono, Celular, Usuario, Clave);
        this.Razon_social = Razon_social;
        this.Socios = Socios;
    }

    
    
    //metodo getter y setter

    public String getRazon_social() {
        return Razon_social;
    }

    public void setRazon_social(String Razon_social) {
        this.Razon_social = Razon_social;
    }

    public int getSocios() {
        return Socios;
    }

    public void setSocios(int Socios) {
        this.Socios = Socios;
    }
    
    
}
