/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Registro_opciones;
import Vista.VistaMenuPrincipal;

import static java.awt.Frame.MAXIMIZED_BOTH;



/**
 *
 * @author MarcoVi
 */
public class ControladorMenuPrincipal {
    VistaMenuPrincipal vmp;
    //CONSTRUCTOR

    public ControladorMenuPrincipal(VistaMenuPrincipal vmp) {
        this.vmp = vmp;
        vmp.setExtendedState(MAXIMIZED_BOTH);
        vmp.setVisible(true);
    }
    public void iniciarControl(){
        vmp.getBtnRegistrar().addActionListener(l->CRUDS());
        
    }
    
    
    public void CRUDS(){
       
         
        Registro_opciones ro=new Registro_opciones();
        ControladorMenuRegistro cmr=new ControladorMenuRegistro(ro);
        cmr.iniciarControl();
        
         
    }
    
}
