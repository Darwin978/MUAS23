/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloEmpleado;
import Modelo.ModeloJuridica;
import Modelo.ModeloNatural;
import Modelo.ModeloServicios;
import Vista.Registro_opciones;
import Vista.VistaGestionEmpleado;
import Vista.VistaPersonaJuridica;
import Vista.VistaPersonaNatural;
import Vista.VistaServicios;
import static java.awt.Frame.MAXIMIZED_BOTH;

/**
 *
 * @author MarcoVi
 */
public class ControladorMenuRegistro {
    Registro_opciones rgo;
    
    //CONSTRUCTOR

    public ControladorMenuRegistro(Registro_opciones rgo) {
        this.rgo = rgo;
        rgo.setExtendedState(MAXIMIZED_BOTH);
        rgo.setVisible(true);
    }
    
     public void iniciarControl(){
        rgo.getJur().addActionListener(l->crudJuridica());
        rgo.getNatu().addActionListener(l->crudNatural());
        rgo.getEmp().addActionListener(l->crudEmpleado());
        rgo.getSer().addActionListener(l->crudServicio());

    }
    
    public void crudJuridica(){
         ModeloJuridica modelo = new ModeloJuridica();
         VistaPersonaJuridica vstper = new VistaPersonaJuridica();
        vstper.setVisible(true);
         ControladorJuridica ctrper = new ControladorJuridica(modelo, vstper);
         ctrper.Iniciar_Control(); 
  
    }
    
     public void crudNatural(){
         ModeloNatural modelo = new ModeloNatural();
         VistaPersonaNatural vstper = new VistaPersonaNatural();
        vstper.setVisible(true);
         ControladorNatural ctrper = new ControladorNatural(modelo, vstper);
         ctrper.Iniciar_Control(); 
  
    }
      public void crudEmpleado(){
          ModeloEmpleado modelo = new ModeloEmpleado();
          VistaGestionEmpleado vstper = new VistaGestionEmpleado();
        vstper.setVisible(true);
         ControladorEmpleado ctrper = new ControladorEmpleado(modelo, vstper);
         ctrper.Iniciar_Control(); 
         
  
    }
       public void crudServicio(){
           ModeloServicios modelo = new ModeloServicios();
           VistaServicios vstper = new VistaServicios();
        vstper.setVisible(true);
         ControladorServicios ctrper = new ControladorServicios(modelo, vstper);
         ctrper.Iniciar_Control(); 
  
    }
    
    
    
    
    
    
    
    
    
    
}
