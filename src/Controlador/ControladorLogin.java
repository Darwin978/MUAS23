/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaLogin;
import com.placeholder.PlaceHolder;

/**
 *
 * @author MarcoVi
 */
public class ControladorLogin {
    
    Vista.VistaLogin vl= new VistaLogin();
    PlaceHolder holder = new PlaceHolder(vl.getTxtUsuario(), "Usuario");
    PlaceHolder mod = new PlaceHolder(vl.getTxtClave(), "Contraseña");
}
