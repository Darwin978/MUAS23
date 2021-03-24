
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ModeloJuridica extends Persona_Juridica{

    
    //CONSTRUCTORES NECESARIOS 
    
    public static Conexion con = new Conexion();
    public ModeloJuridica() {
    }

    public ModeloJuridica(String DNI) {
        super(DNI);
    }
    
    
    public ModeloJuridica(String Razon_social, int Socios, String Codigo, String DNI, String Nombres, String Apellidos, String Direccion, String Correo, String Telefono, String Celular, String Usuario, String Clave) {
        super(Razon_social, Socios, Codigo, DNI, Nombres, Apellidos, Direccion, Correo, Telefono, Celular, Usuario, Clave);
    }
    
    //METODO  CREAR PERSONA JURI EN LA BD
    public boolean Crear_Persona_Juridica() {
        String sql;
        sql = "INSERT INTO persona_juridica(codigo,ruc,nombres,apellidos,razon_social,direccion,correo,telefono,celular,usuario,clave, socios) ";
        sql += "VALUES ('" + getCodigo() + "','" + getDNI() + "','" + getNombres() + "','" + getApellidos() + "','" + getRazon_social() + "','" + getDireccion() + "','" + getCorreo() + "','" + getTelefono() + "','" + getCelular() + "','" + getUsuario() + "','" + getClave() + "','" + getSocios() + "')";

        if (con.noquery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Persona_Juridica> Listar(String encontrar) {
        try {
            String query = "SELECT * FROM persona_juridica WHERE LOWER(ruc) LIKE LOWER('" + encontrar + "%')"
                    + " OR LOWER(codigo) LIKE LOWER('" + encontrar + "%')"
                    + " OR LOWER(nombres) LIKE LOWER('" + encontrar + "%')"
                    + "OR LOWER (apellidos) LIKE LOWER('" + encontrar + "%')";
            ResultSet rs = con.query(query);

            List<Persona_Juridica> lista = new ArrayList<Persona_Juridica>();
            while (rs.next()) {
                Persona_Juridica pj = new Persona_Juridica();
                pj.setCodigo(rs.getString("codigo"));
                pj.setDNI(rs.getString("ruc"));
                pj.setNombres(rs.getString("nombres"));
                pj.setApellidos(rs.getString("apellidos"));
                pj.setRazon_social(rs.getString("razon_social"));
                pj.setDireccion(rs.getString("direccion"));
                pj.setCorreo(rs.getString("correo"));
                pj.setTelefono(rs.getString("telefono"));
                pj.setCelular(rs.getString("celular"));
                pj.setUsuario(rs.getString("usuario"));
                pj.setClave(rs.getString("clave"));
                pj.setSocios(rs.getInt("socios"));
                lista.add(pj);

            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            System.out.println("Inconsistencia");
            return null;
        }
    }

    public boolean Editar_Natural() {

        String sql;
        sql = "UPDATE persona_juridica SET nombres='" + getNombres() + "',"
                + "apellidos='" + getApellidos() + "', razon_social='" + getRazon_social() + "', "
                + "direccion='" + getDireccion() + "' , "
                + "correo='" + getCorreo() + "', telefono='" + getTelefono() + "',  "
                + "celular='" + getCelular() + "', usuario='" + getUsuario() + "',  "
                + "clave='" + getClave() + "', socios=" + getSocios() + " "
                + "WHERE codigo='" + getCodigo() + "';";
        if (con.noquery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public List<Persona_Juridica> Buscar_Juridica() {
        try {
            String query = "SELECT * FROM persona_juridica WHERE ruc='" + getDNI()+ "';";
            ResultSet rs = con.query(query);
            byte[] bf;
            List<Persona_Juridica> lista = new ArrayList<Persona_Juridica>();

            while (rs.next()) {
                Persona_Juridica pj = new Persona_Juridica();
                pj.setCodigo(rs.getString("codigo"));
                pj.setDNI(rs.getString("ruc"));
                pj.setNombres(rs.getString("nombres"));
                pj.setApellidos(rs.getString("apellidos"));
                pj.setRazon_social(rs.getString("razon_social"));
                pj.setDireccion(rs.getString("direccion"));
                pj.setCorreo(rs.getString("correo"));
                pj.setTelefono(rs.getString("telefono"));
                pj.setCelular(rs.getString("celular"));
                pj.setUsuario(rs.getString("usuario"));
                pj.setClave(rs.getString("clave"));
                pj.setSocios(rs.getInt("socios"));
                lista.add(pj);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloServicios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean Eliminar_Juridica() {
        String sql = "DELETE FROM persona_juridica WHERE ruc='" + getDNI() + "'";
        return (con.noquery(sql) == null);
    }

  
}
