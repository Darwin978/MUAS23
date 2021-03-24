/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.postgresql.util.Base64;

/**
 *
 * @author MarcoVi
 */
public class ModeloNatural  extends Persona_Natural {
    
    public static Conexion con = new Conexion();

    public ModeloNatural() {
    }
    public ModeloNatural(String DNI) {
        super(DNI);
    }
    public ModeloNatural(Image Foto, String Codigo, String DNI, String Nombres, String Apellidos, String Direccion, String Correo, String Telefono, String Celular, String Usuario, String Clave) {
        super(Foto, Codigo, DNI, Nombres, Apellidos, Direccion, Correo, Telefono, Celular, Usuario, Clave);
    }

    public ModeloNatural(String Codigo, String DNI, String Nombres, String Apellidos, String Direccion, String Correo, String Telefono, String Celular, String Usuario, String Clave) {
        super(Codigo, DNI, Nombres, Apellidos, Direccion, Correo, Telefono, Celular, Usuario, Clave);
    }

    
    
    
    public boolean Crear_Persona_Natural() {
        String foto64 = null;
        //Transformar imgagen a base64 para postgresql
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = imgBimage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            foto64 = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        String sql;
        sql = "INSERT INTO persona_natural(codigo,ruc,nombres,apellidos,direccion,correo,telefono,celular,usuario,clave, foto) "
                + "VALUES ('" + getCodigo() + "','" + getDNI() + "','" + getNombres() + "','" + getApellidos() + "','" + getDireccion() + "','" + getCorreo() + "','" + getTelefono() + "','" + getCelular() + "','" + getUsuario() + "','" + getClave() + "','" + foto64 + "')";

        if (con.noquery(sql) == null) {
            return true;
        } else {
            return false;
        }

    }

    public static List<Persona_Natural> Listar(String encontrar) {

        try {
            String query = "SELECT * FROM persona_natural WHERE LOWER(ruc) LIKE LOWER('" + encontrar + "%')"
                    + " OR LOWER(nombres) LIKE LOWER('" + encontrar + "%')"
                    + " OR LOWER(codigo) LIKE LOWER('" + encontrar + "%')"
                    + "OR LOWER (apellidos) LIKE LOWER('" + encontrar + "%')";

            ResultSet rs = con.query(query);

            List<Persona_Natural> lista = new ArrayList<Persona_Natural>();

            byte[] bf;
            while (rs.next()) {
                Persona_Natural persona = new Persona_Natural();
                persona.setCodigo(rs.getString("codigo"));
                persona.setDNI(rs.getString("ruc"));
                persona.setNombres(rs.getString("nombres"));
                persona.setApellidos(rs.getString("apellidos"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setCorreo(rs.getString("correo"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setCelular(rs.getString("celular"));
                persona.setUsuario(rs.getString("usuario"));
                persona.setClave(rs.getString("clave"));

                bf = rs.getBytes("foto");
                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    try {
                        //OBTENER IMAGEN
                        persona.setFoto(obtenImagen(bf));
                    } catch (IOException ex) {
                        persona.setFoto(null);
                        Logger.getLogger(ModeloNatural.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    persona.setFoto(null);
                }
                lista.add(persona);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            System.out.println("Inconsistencia");
            return null;
        }
    }

    public boolean Eliminar_Natural() {
        String sql = "DELETE FROM persona_natural WHERE ruc='" + getDNI() + "'";
        return (con.noquery(sql) == null);
    }

    public boolean Editar_Natural() {
        String foto64 = null;
        //Transformar imgagen a base64 para postgresql

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            BufferedImage img = imgBimage(getFoto());
            ImageIO.write(img, "PNG", bos);
            //CODIFICA LA IMAGEN
            byte[] imgb = bos.toByteArray();
            foto64 = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        String sql;
        sql = "UPDATE persona_natural SET nombres='" + getNombres() + "',"
                + "apellidos='" + getApellidos() + "', direccion='" + getDireccion() + "',  "
                + "correo='" + getCorreo() + "', telefono='" + getTelefono() + "',  "
                + "celular='" + getCelular() + "', usuario='" + getUsuario() + "',  "
                + "clave='" + getClave() + "',foto='"+foto64+"'  "
                + "WHERE codigo='" + getCodigo() + "';";
        if (con.noquery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public List<Persona_Natural> Buscar_Natural() {
        try {
            String query = "SELECT * FROM persona_natural WHERE ruc='" + getDNI()+ "';";
            ResultSet rs = con.query(query);
            byte[] bf;
            List<Persona_Natural> lista = new ArrayList<Persona_Natural>();

            while (rs.next()) {
                Persona_Natural persona = new Persona_Natural();
                persona.setCodigo(rs.getString("codigo"));
                persona.setDNI(rs.getString("ruc"));
                persona.setNombres(rs.getString("nombres"));
                persona.setApellidos(rs.getString("apellidos"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setCorreo(rs.getString("correo"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setCelular(rs.getString("celular"));
                persona.setUsuario(rs.getString("usuario"));
                persona.setClave(rs.getString("clave"));

                bf = rs.getBytes("foto");
                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    try {
                        //OBTENER IMAGEN
                        persona.setFoto(obtenImagen(bf));
                    } catch (IOException ex) {
                        persona.setFoto(null);
                        Logger.getLogger(ModeloNatural.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    persona.setFoto(null);
                }
                lista.add(persona);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloServicios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //METODOS PÁRA LA IMAGEN
    private BufferedImage imgBimage(Image img) {

        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        BufferedImage bi = new BufferedImage(
                img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D bGR = bi.createGraphics();
        bGR.drawImage(img, 0, 0, null);
        bGR.dispose();
        return bi;
    }

    public static Image obtenImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) it.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        return reader.read(0, param);
    }

    
}
