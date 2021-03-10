/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;

/**
 *
 * @author MarcoVi
 */
public class Persona_Natural extends Persona {
    
    
    //ATRIBUTOS
    
    private Image Foto;
    
    //constructor

    public Persona_Natural(String DNI) {
        super(DNI);
    }

    public Persona_Natural() {
    }

   

    public Persona_Natural(Image Foto, String Codigo, String DNI, String Nombres, String Apellidos, String Direccion, String Correo, String Telefono, String Celular, String Usuario, String Clave) {
        super(Codigo, DNI, Nombres, Apellidos, Direccion, Correo, Telefono, Celular, Usuario, Clave);
        this.Foto = Foto;
    }
    
    //metodo getter y setter

    public Image getFoto() {
        return Foto;
    }

    public void setFoto(Image Foto) {
        this.Foto = Foto;
    }
    
    
}
