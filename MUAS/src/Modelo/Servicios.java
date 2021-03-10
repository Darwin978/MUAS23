/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author MarcoVi
 */
public class Servicios {
    
    
    //ATRIBUTOS 
    
    private String Codigo_ser;
    private String Nombre_ser;
    private String Descripcion;
    private double Precio;
    
    
  //CONSTRUCTORES

    public Servicios(String Codigo_ser, String Nombre_ser, String Descripcion, double Precio) {
        this.Codigo_ser = Codigo_ser;
        this.Nombre_ser = Nombre_ser;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
    }
    
    //METODOS GETTER Y SETTER

    public String getCodigo_ser() {
        return Codigo_ser;
    }

    public void setCodigo_ser(String Codigo_ser) {
        this.Codigo_ser = Codigo_ser;
    }

    public String getNombre_ser() {
        return Nombre_ser;
    }

    public void setNombre_ser(String Nombre_ser) {
        this.Nombre_ser = Nombre_ser;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
    
    
  
}
