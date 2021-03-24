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
public class ModeloServicios extends Servicios {
    
    
     //CONSTRUCTORES NECESARIOS 
    
    public static Conexion con = new Conexion();

    public ModeloServicios() {
    }

    public ModeloServicios(String Codigo_ser) {
        super(Codigo_ser);
    }

    public ModeloServicios(String Codigo_ser, String Nombre_ser, String Descripcion, double Precio) {
        super(Codigo_ser, Nombre_ser, Descripcion, Precio);
    }
    
     //METODO  CREAR PERSONA JURI EN LA BD
    
    public boolean Crear_Servicio() {
        String sql;
        sql = "INSERT INTO servicios(codigo,nombre,descripcion, precio) ";
        sql += "VALUES ('" + getCodigo_ser() + "','" + getNombre_ser() + "','" + getDescripcion() + "','" + getPrecio() + "')";

        if (con.noquery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Servicios> Listar(String encontrar) {
        try {
            String query = "SELECT * FROM servicios WHERE LOWER(codigo) LIKE LOWER('" + encontrar + "%')"
                    + " OR LOWER(nombre) LIKE LOWER('" + encontrar + "%')";

            ResultSet rs = con.query(query);

            List<Servicios> lista = new ArrayList<Servicios>();
            while (rs.next()) {
                Servicios pj = new Servicios();
                pj.setCodigo_ser(rs.getString("codigo"));
                pj.setNombre_ser(rs.getString("nombre"));
                pj.setDescripcion(rs.getString("descripcion"));
                pj.setPrecio(rs.getDouble("precio"));
                lista.add(pj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            System.out.println("Inconsistencia");
            return null;
        }
    }

    public boolean Eliminar_Servicio() {
        String sql = "DELETE FROM servicios WHERE codigo='" + getCodigo_ser() + "'";
        return (con.noquery(sql) == null);
    }

    public boolean Editar_Servicio() {

        String sql;
        sql = "UPDATE servicios SET nombre='" + getNombre_ser() + "',"
                + "descripcion='" + getDescripcion() + "', precio=" + getPrecio() + "  "
                + "WHERE codigo='" + getCodigo_ser() + "';";
        if (con.noquery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public List<Servicios> Buscar_Servicio() {
        try {
            String query = "SELECT * FROM servicios WHERE codigo='" + getCodigo_ser() + "';";
            ResultSet rs = con.query(query);
            List<Servicios> lista = new ArrayList<Servicios>();

            while (rs.next()) {
                Servicios ser = new Servicios();
                ser.setCodigo_ser(rs.getString("codigo"));
                ser.setNombre_ser(rs.getString("nombre"));
                ser.setDescripcion(rs.getString("descripcion"));
                ser.setPrecio(rs.getDouble("precio"));

                lista.add(ser);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloServicios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
   
        
}
