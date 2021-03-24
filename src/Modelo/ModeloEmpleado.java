/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MarcoVi
 */
public class ModeloEmpleado extends Empleado{
    
    //CONSTRUCTORES NECESARIOS 
    public static Conexion con = new Conexion();

    public ModeloEmpleado() {
    }

    public ModeloEmpleado(String DNI) {
        super(DNI);
    }

    public ModeloEmpleado(String Cargo, double Sueldo, String Codigo, String DNI, String Nombres, String Apellidos, String Direccion, String Correo, String Telefono, String Celular, String Usuario, String Clave) {
        super(Cargo, Sueldo, Codigo, DNI, Nombres, Apellidos, Direccion, Correo, Telefono, Celular, Usuario, Clave);
    }

     //METODO  CREAR PERSONA JURI EN LA BD
    
    public boolean Crear_Empleado() {
        String sql;
        sql = "INSERT INTO empleado(codigo,cedula,nombres,apellidos,direccion,correo,telefono,celular,cargo,sueldo, usuario,clave) ";
          sql+= "VALUES ('" + getCodigo()+ "','" + getDNI() + "','" + getNombres() + "','" + getApellidos() + "','" + getDireccion()+ "','" + getCorreo() + "','" + getTelefono() + "','" + getCelular() + "','" + getCargo() + "','" + getSueldo()+ "','" + getUsuario() + "','" +getClave() + "')";

        if (con.noquery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
     public static List<Empleado> Listar(String encontrar){
         try {
             String query = "SELECT * FROM empleado WHERE LOWER(cedula) LIKE LOWER('"+encontrar+"%')"
                    + " OR LOWER(codigo) LIKE LOWER('"+encontrar+"%')" 
                    + " OR LOWER(nombres) LIKE LOWER('"+encontrar+"%')"
                    + "OR LOWER (apellidos) LIKE LOWER('"+encontrar+"%')";
             ResultSet rs=con.query(query);
           
            List<Empleado> lista = new ArrayList<Empleado>();
            while(rs.next()){
                Empleado pj=new Empleado();
                pj.setCodigo(rs.getString("codigo"));
                pj.setDNI(rs.getString("cedula"));
                pj.setNombres(rs.getString("nombres"));
                pj.setApellidos(rs.getString("apellidos"));
                pj.setDireccion(rs.getString("direccion"));
                pj.setCorreo(rs.getString("correo"));
                pj.setTelefono(rs.getString("telefono"));
                pj.setCelular(rs.getString("celular"));
                pj.setCargo(rs.getString("cargo"));
                pj.setSueldo(rs.getDouble("sueldo"));
                pj.setUsuario(rs.getString("usuario"));
                pj.setClave(rs.getString("clave"));
               
                lista.add(pj);
                
            }
            rs.close();
            return lista;
         } catch (SQLException ex) {
            System.out.println("Inconsistencia");
            return null;
        }
     }
     
     public boolean Eliminar_Empleado(){
        String sql= "DELETE FROM empleado WHERE cedula='"+getDNI()+"'";
        return (con.noquery(sql)==null);
    }
    
     public boolean Editar_Empleado() {

        String sql;
        sql = "UPDATE empleado SET nombres='" + getNombres() + "',"
                + "apellidos='" + getApellidos()+ "', direccion='" + getDireccion()+ "',  "
                + "correo='" + getCorreo()+ "', telefono='" + getTelefono()+ "' , "
                + "celular='" + getCelular()+ "', cargo='" + getCargo() + "'  ,"
                + "sueldo=" + getSueldo()+ ", usuario='" + getUsuario()+ "' , "
                + "clave='" + getClave()+ "'  "
              
                + "WHERE codigo='" + getCodigo()+ "';";
        if (con.noquery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
     
     
      public List<Empleado> Buscar_Empleado() {
        try {
             String query = "SELECT * FROM empleado WHERE cedula='" + getDNI()+ "';";
             ResultSet rs=con.query(query);
           
            List<Empleado> lista = new ArrayList<Empleado>();
            while(rs.next()){
                Empleado pj=new Empleado();
                pj.setCodigo(rs.getString("codigo"));
                pj.setDNI(rs.getString("cedula"));
                pj.setNombres(rs.getString("nombres"));
                pj.setApellidos(rs.getString("apellidos"));
                pj.setDireccion(rs.getString("direccion"));
                pj.setCorreo(rs.getString("correo"));
                pj.setTelefono(rs.getString("telefono"));
                pj.setCelular(rs.getString("celular"));
                pj.setCargo(rs.getString("cargo"));
                pj.setSueldo(rs.getDouble("sueldo"));
                pj.setUsuario(rs.getString("usuario"));
                pj.setClave(rs.getString("clave"));
               
                lista.add(pj);
                
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     
     
     
     
     
     
     
     
}
