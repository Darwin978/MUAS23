
package Controlador;

import Modelo.ModeloJuridica;
import Vista.VistaLogin;
import Vista.VistaPerJuridica;
import com.placeholder.PlaceHolder;


public class FacLab {

   
    public static void main(String[] args) {
       Vista.VistaPerJuridica v=new VistaPerJuridica();
       Modelo.ModeloJuridica modelo=new ModeloJuridica();
        ControladorJuridica ctrper = new ControladorJuridica(modelo,v);
         ctrper.Iniciar_Control(); 
//   Vista.VistaLogin vl= new VistaLogin();
//    PlaceHolder holder = new PlaceHolder(vl.getTxtUsuario(), "Usuario");
//    PlaceHolder mod = new PlaceHolder(vl.getTxtClave(), "Contraseña");
//    vl.setVisible(true);
       
    }
    
}
