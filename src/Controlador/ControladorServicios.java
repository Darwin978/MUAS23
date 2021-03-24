/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloServicios;
import Modelo.Servicios;
import Vista.VistaServicios;
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
public class ControladorServicios {
    
     private ModeloServicios modelo;
    private VistaServicios vista;
    
    
    public ControladorServicios(ModeloServicios modelo,VistaServicios vista){
        this.modelo=modelo;
    this.vista=vista;
    vista.setVisible(true);
    }
      public void Iniciar_Control() {
          vista.getBtnGuardar().addActionListener(al -> grabarServicio());
          vista.getBtnActualizar().addActionListener(al->Rellenar_Dialogo_Editar());
          vista.getBtnGuardar_Act().addActionListener(al->Editar_Servicio());
           vista.getBtnEliminar().addActionListener(al->Eliminar_Servicio());
            
            
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {

            }

            @Override
            public void keyPressed(KeyEvent ke) {

            }

            @Override
            public void keyReleased(KeyEvent ke) {
                cargaLista(vista.getTxtBuscar().getText());
            }

             
           
        };
        vista.getTxtBuscar().addKeyListener(kl);
            
        
      }

      private void grabarServicio() {
          
          String codigo=vista.getTxtCodigo().getText(); 
          String nombres=vista.getTxtNombre().getText();
          String desc=vista.getTxtDescripcion().getText();
          Double precio=Double.parseDouble(vista.getTxtPrecio().getText());
          
      
         
          
          
           ModeloServicios ser=new ModeloServicios(codigo,nombres,desc,precio);
          if (ser.Crear_Servicio()) {
            JOptionPane.showMessageDialog(vista, "Registro grabado Satisfactoriamente");
           cargaLista("");
//            vista.getDialogo_persona().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");
        }
      }
      
      
   private void cargaLista(String aguja){
        
        
//        vista.getTablaServicios().setDefaultRenderer(Object.class, new ImagenTabla());
//        vista.getTablaServicios().setRowHeight(100);
//        DefaultTableCellRenderer renderer= new DefaultTableCellHeaderRenderer();
        
        DefaultTableModel tblModel;
        tblModel=(DefaultTableModel)vista.getTablaServicios().getModel();
        tblModel.setNumRows(0);
        List<Servicios> lista=ModeloServicios.Listar(aguja);
        int ncols=tblModel.getColumnCount();

        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1->{
             
           tblModel.addRow(new Object[ncols]);
           vista.getTablaServicios().setValueAt(p1.getCodigo_ser(), i.value , 0);
           
            vista.getTablaServicios().setValueAt(p1.getNombre_ser(), i.value , 1);
            vista.getTablaServicios().setValueAt(p1.getDescripcion(), i.value , 2);
            vista.getTablaServicios().setValueAt(p1.getPrecio(), i.value , 3);
            
  
            
            
           
//            //completar datos
//           Image img = p1.getFoto();
//           if(img!=null){
//                Image newimg = img.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);
//                ImageIcon icon = new ImageIcon(newimg);
//                renderer.setIcon(icon);
//                vista.getTablaServicios().setValueAt(new JLabel(icon), i.value, 9);
//           }else{
//               vista.getTablaServicios().setValueAt(null, i.value, 9);
//           }
           i.value++;
          ;
        });
    }

   
   //ELIMINAR DE LA TABLA-BASE
    private void Eliminar_Servicio() {
        String idSeleccion = "";
        int fila = vista.getTablaServicios().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            JTable tabla = vista.getTablaServicios();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();
            ModeloServicios persona = new ModeloServicios(idSeleccion);
            if (persona.Eliminar_Servicio()) {
                cargaLista("");
                JOptionPane.showMessageDialog(vista, "El registro ha sido eliminado");
            } else {
                System.out.println("Sin eliminar");
            }
        }

    }
   
    
    //SIRVE PARA RECUPERAR DATOS Y MANDAR A TXT
     public void Rellenar_Dialogo_Editar() {
        String idSeleccion = "";
        int fila = vista.getTablaServicios().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            JTable tabla = vista.getTablaServicios();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
        }

        ModeloServicios servicio = new ModeloServicios(idSeleccion);
        List<Servicios> lista = servicio.Buscar_Servicio();
        for (int i = 0; i < lista.size(); i++) {
            Servicios ser = lista.get(i);
            
            String codigo=ser.getCodigo_ser();
            String nombre=ser.getNombre_ser();
            String desc=ser.getDescripcion();
            Double precio=ser.getPrecio();
            
            
            vista.getjDialog1().setVisible(true);
            
            vista.getjDialog1().setTitle("EDITAR SERVICIO");
//            vista.getDialogo_persona().setSize(525, 525);
//            vista.getBtnaceptar().setText("EDITAR");
            vista.getjDialog1().setLocationRelativeTo(null);
            vista.getTxtCod_Act().setText(codigo);
            vista.getTxtNombre_Act().setText(nombre);
            vista.getTxtDescrip_Act().setText(desc);
            vista.getTxtPrecio_Act().setText(precio+"");
            
        }
    }
    
     //SIRVE PARA EDITAR
      private void Editar_Servicio() {
        String codigo=vista.getTxtCod_Act().getText();
        String nombre=vista.getTxtNombre_Act().getText();
        String desc=vista.getTxtDescrip_Act().getText();
        Double precio=Double.parseDouble(vista.getTxtPrecio_Act().getText());
        
        
       

        ModeloServicios ser = new ModeloServicios(codigo,nombre,desc,precio);
        
       
        if (ser.Editar_Servicio()) {
            JOptionPane.showMessageDialog(vista, "Registro Modificado");
            cargaLista("");
            vista.getjDialog1().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");
        }
    }
    
    
}
