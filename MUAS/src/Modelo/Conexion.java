
package Modelo;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    private String url="jdbc:postgresql://localhost:5432/faclab";
    private String user="postgres";
    private String pass="1234";
    
    private Connection con;
    
    public Conexion() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver no encontrado");
        }
        
        try {
            con= DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println("Conexión no realizada correctamente");
        }
    }
    
    //SELECT * FROM 
    public ResultSet query(String sql){
        
        try {
            java.sql.Statement st;
            st= con.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException ex) {
            return null;
        } 
    }
    
    //INSERT-UPDATE-DELETE
    public SQLException noquery(String nsql){
        try {
            java.sql.Statement st;
            st= con.createStatement();
            st.execute(nsql); 
            return null;
        } catch (SQLException ex) {
            System.out.println("Error: " +ex);
            return ex;
        }   
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
