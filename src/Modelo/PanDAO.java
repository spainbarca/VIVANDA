package Modelo;

import java.awt.Image;
import java.util.*;
import javax.swing.*;
import Vista.VentanaPan;
import java.awt.Color;

public class PanDAO {
    VentanaPan objVentanaPan;
    ConsultarPan objConsultarPan;
    PanBean objPanBean;
    ArrayList<PanBean> lista;
    
    public PanDAO(VentanaPan objVentanaAseo){
        this.objVentanaPan=objVentanaAseo;
        this.objConsultarPan = new ConsultarPan();
        
        //this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/vivandalogo.png")).getImage());
    }
    
    public void Listar(){
            lista=objConsultarPan.ConsultarPan();
            objVentanaPan.modelo.setNumRows(lista.size());
            int i=0;
            for(PanBean objAs:lista){
                objVentanaPan.modelo.setValueAt(""+objAs.getCodigo(),i,0);
                objVentanaPan.modelo.setValueAt(""+objAs.getCategoria(),i,1);
                objVentanaPan.modelo.setValueAt(objAs.getSubcategoria(),i,2);
                objVentanaPan.modelo.setValueAt(""+objAs.getMarca(),i,3);
                objVentanaPan.modelo.setValueAt(objAs.getDescripcion(),i,4);
                objVentanaPan.modelo.setValueAt(""+objAs.getCantidad(),i,5);
                objVentanaPan.modelo.setValueAt(objAs.getPrecio(),i,6);
                objVentanaPan.modelo.setValueAt(objAs.getCantidad()*objAs.getPrecio(),i,7);
                objVentanaPan.modelo.setValueAt(""+objAs.getNombre(),i,8);
                    i++;
            }
            objVentanaPan.TablaPan.setModel(objVentanaPan.modelo);
    }
    
    public void BorrarDato(){
        int i=0;
        objPanBean=null;
        if(objVentanaPan.txtCodigo.getText().length()!=0){
            objPanBean= new PanBean();
            objPanBean.setCodigo(Integer.parseInt(objVentanaPan.txtCodigo.getText()));
            i= objConsultarPan.eliminarDatos(objPanBean);
            
            switch(i){
                case 1:{
                        JOptionPane.showMessageDialog(null, "Registro Eliminado");
                        break;
                }
                default:{
                        JOptionPane.showMessageDialog(null, "Registro no eliminado");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione por favor un registro para eliminar");
        }
    }
    
    public void VaciarDato(){
        int msj=JOptionPane.showConfirmDialog(null, "¿Está seguro de vaciar todos los registros?");
        
        if (msj==JOptionPane.YES_OPTION){
            int i=0;
        objPanBean=null;
            objPanBean= new PanBean();
            i= objConsultarPan.vaciarDatos(objPanBean);
            
                        JOptionPane.showMessageDialog(null, "Registro Vaciado");
        }
        
        if (msj==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Registro No Vaciado");
        }
        
        if (msj==JOptionPane.CLOSED_OPTION){
            
        } 
    }
    
      public void Seleccionar(){
        objVentanaPan.txtCodigo.setText((String) objVentanaPan.TablaPan.getValueAt(objVentanaPan.TablaPan.getSelectedRow(),0));
            objVentanaPan.txtCategoria.setText(objVentanaPan.TablaPan.getValueAt(objVentanaPan.TablaPan.getSelectedRow(),1).toString());
            objVentanaPan.txtSubcategoria.setText(objVentanaPan.TablaPan.getValueAt(objVentanaPan.TablaPan.getSelectedRow(),2).toString());
            objVentanaPan.txtDescripcion.setText(objVentanaPan.TablaPan.getValueAt(objVentanaPan.TablaPan.getSelectedRow(),4).toString());
            objVentanaPan.txtCantidad.setText(objVentanaPan.TablaPan.getValueAt(objVentanaPan.TablaPan.getSelectedRow(),5).toString());
            objVentanaPan.txtPrecio.setText(objVentanaPan.TablaPan.getValueAt(objVentanaPan.TablaPan.getSelectedRow(),6).toString());
            String z = objVentanaPan.TablaPan.getValueAt(objVentanaPan.TablaPan.getSelectedRow(),8).toString();
            String s = objVentanaPan.TablaPan.getValueAt(objVentanaPan.TablaPan.getSelectedRow(),2).toString();
            
            ImageIcon producto = new ImageIcon(getClass().getResource("/Productos/Panes/"+s+"/"+z));
            ImageIcon icono = new ImageIcon(producto.getImage().getScaledInstance(objVentanaPan.Imagen.getWidth(), objVentanaPan.Imagen.getHeight(), Image.SCALE_DEFAULT));
            objVentanaPan.Imagen.setIcon(icono);
            //lblImagen.setIcon((Icon) TablaAseo.getValueAt(TablaAseo.getSelectedRow(),7));
            
            String y = objVentanaPan.TablaPan.getValueAt(objVentanaPan.TablaPan.getSelectedRow(),3).toString();
            ImageIcon marca = new ImageIcon(getClass().getResource("/Marcas/"+y+".png"));
            ImageIcon logo = new ImageIcon(marca.getImage().getScaledInstance(objVentanaPan.jLabel1.getWidth(), objVentanaPan.jLabel1.getHeight(), Image.SCALE_DEFAULT));
            objVentanaPan.jLabel1.setIcon(logo);
    }
      
    public void LimpiarCampos(){
        objVentanaPan.txtCodigo.setText("");
        objVentanaPan.txtCategoria.setText("");
        objVentanaPan.txtSubcategoria.setText("");
        objVentanaPan.txtDescripcion.setText("");
        objVentanaPan.txtCantidad.setText("");
        objVentanaPan.txtPrecio.setText("");
    }
    
    public void ActualizarDatos(){
        int i=0;
        objPanBean=null;
        if(objVentanaPan.txtCodigo.getText().length()!=0){
            objPanBean= new PanBean();
            objPanBean.setCodigo(Integer.parseInt(objVentanaPan.txtCodigo.getText()));
            objPanBean.setDescripcion(objVentanaPan.txtDescripcion.getText());
            objPanBean.setCantidad(Integer.parseInt(objVentanaPan.txtCantidad.getText()));
            objPanBean.setPrecio(Double.parseDouble(objVentanaPan.txtPrecio.getText()));
            
            ConsultarPan objM=new ConsultarPan();
            i=objM.modificarDatos(objPanBean);
        
        switch(i){
            case 1:{
                    JOptionPane.showMessageDialog(null, "Se modificó los datos");
                    break;
            }
            default:{
                    JOptionPane.showMessageDialog(null, "No se modificó los datos");
            }
        }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione por favor un registro para modificar");
        }
    }
    
    public void ONOFF(){
        if(objVentanaPan.btnOnOff.isSelected()){
            objVentanaPan.btnOnOff.setBackground(Color.green);
            objVentanaPan.btnOnOff.setText("ON");
            Listar();
            objVentanaPan.TablaPan.setVisible(true);
        }else{
            objVentanaPan.btnOnOff.setBackground(Color.red);
            objVentanaPan.btnOnOff.setText("OFF");
            objVentanaPan.TablaPan.setVisible(false);
        }
    }
}
