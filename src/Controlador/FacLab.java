
package Controlador;

import Modelo.ModeloJuridica;
import Modelo.ModeloNatural;
import Vista.VistaLogin;
import Vista.VistaMenuPrincipal;
import Vista.VistaPersonaJuridica;
import Vista.VistaPersonaNatural;
import Vista.VistaServicios;
import com.placeholder.PlaceHolder;


public class FacLab {

   
    public static void main(String[] args) {
        VistaMenuPrincipal vista = new VistaMenuPrincipal();
     ControladorMenuPrincipal cmp = new ControladorMenuPrincipal(vista);
     cmp.iniciarControl();
     
      
       
    }
    
}
