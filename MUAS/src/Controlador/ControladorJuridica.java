/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloJuridica;
import Modelo.Persona_Juridica;
import Vista.VistaPerJuridica;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;

/**
 *
 * @author MarcoVi
 */
public class ControladorJuridica {
    
    private ModeloJuridica modelo;
    private VistaPerJuridica vista;
    
    public ControladorJuridica(ModeloJuridica modelo,VistaPerJuridica vista){
        this.modelo=modelo;
    this.vista=vista;
    vista.setVisible(true);
    }
      public void Iniciar_Control() {
          vista.getBtnGrabar().addActionListener(al -> grabarPersona());
            vista.getBtnlistar().addActionListener(al -> cargaLista("")); //cambie
           vista.getBtneliminar().addActionListener(al->Eliminar_Juridica());
            
            
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {

            }

            @Override
            public void keyPressed(KeyEvent ke) {

            }

            @Override
            public void keyReleased(KeyEvent ke) {
                cargaLista(vista.getTxtbuscar().getText());
            }
        };
        vista.getTxtbuscar().addKeyListener(kl);
            
        
      }

      private void grabarPersona() {
          String razon=vista.getTxtrazon().getText();
          String codigo=vista.getTxtcodigo().getText();
          int socios=Integer.parseInt(vista.getTxtsocios().getText());
          String dni=vista.getTxtruc().getText();
          String nombres=vista.getTxtnombres().getText();
          String apellidos=vista.getTxtapellidos().getText();
          String dire=vista.getTxtdireccion().getText();
          String correo=vista.getTxtcorreo().getText();
          String tele=vista.getTxttelefono().getText();
          String celular=vista.getTxtcelular().getText();
          String usuario=vista.getTxtusuario().getText();
          String clave=vista.getTxtclave().getText();
          
          ModeloJuridica juridica = new ModeloJuridica(razon,socios,codigo,dni,nombres,apellidos,dire,correo,tele,celular,usuario,clave);
          if (juridica.Crear_Persona_Juridica()) {
            JOptionPane.showMessageDialog(vista, "Registro grabado Satisfactoriamente");
           cargaLista("");
//            vista.getDialogo_persona().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");
        }
      }
      
      
   private void cargaLista(String aguja){
        
        
//        vista.getTabla_juridica().setDefaultRenderer(Object.class, new ImagenTabla());
//        vista.getTabla_juridica().setRowHeight(100);
//        DefaultTableCellRenderer renderer= new DefaultTableCellHeaderRenderer();
        
        DefaultTableModel tblModel;
        tblModel=(DefaultTableModel)vista.getTabla_juridica().getModel();
        tblModel.setNumRows(0);
        List<Persona_Juridica> lista=ModeloJuridica.Listar(aguja);
        int ncols=tblModel.getColumnCount();

        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1->{
             
           tblModel.addRow(new Object[ncols]);
           vista.getTabla_juridica().setValueAt(p1.getCodigo(), i.value , 0);
           vista.getTabla_juridica().setValueAt(p1.getDNI(), i.value , 1);
            vista.getTabla_juridica().setValueAt(p1.getNombres(), i.value , 2);
            vista.getTabla_juridica().setValueAt(p1.getApellidos(), i.value , 3);
            vista.getTabla_juridica().setValueAt(p1.getRazon_social(), i.value , 4);
            vista.getTabla_juridica().setValueAt(p1.getDireccion(), i.value , 5);
            vista.getTabla_juridica().setValueAt(p1.getCorreo(), i.value , 6);
            vista.getTabla_juridica().setValueAt(p1.getTelefono(), i.value , 7);
            vista.getTabla_juridica().setValueAt(p1.getCelular(), i.value , 8);
            vista.getTabla_juridica().setValueAt(p1.getUsuario(), i.value, 9);
            vista.getTabla_juridica().setValueAt(p1.getClave(), i.value, 10);
            vista.getTabla_juridica().setValueAt(p1.getSocios(), i.value, 11);
            
            
           
//            //completar datos
//           Image img = p1.getFoto();
//           if(img!=null){
//                Image newimg = img.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);
//                ImageIcon icon = new ImageIcon(newimg);
//                renderer.setIcon(icon);
//                vista.getTabla_juridica().setValueAt(new JLabel(icon), i.value, 9);
//           }else{
//               vista.getTabla_juridica().setValueAt(null, i.value, 9);
//           }
           i.value++;
          ;
        });
    }

   
   //ELIMINAR DE LA TABLA-BASE
    private void Eliminar_Juridica() {
        String idSeleccion = "";
        int fila = vista.getTabla_juridica().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            JTable tabla = vista.getTabla_juridica();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();
            ModeloJuridica persona = new ModeloJuridica(idSeleccion);
            if (persona.Eliminar_Juridica()) {
                cargaLista("");
                JOptionPane.showMessageDialog(vista, "El registro ha sido eliminado");
            } else {
                System.out.println("Sin eliminar");
            }
        }

    }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
