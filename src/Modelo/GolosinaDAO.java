package Modelo;

import java.awt.Image;
import java.util.*;
import javax.swing.*;
import Vista.VentanaGolosina;
import java.awt.Color;

public class GolosinaDAO {
    VentanaGolosina objVentanaGolosina;
    ConsultarGolosina objConsultarGolosina;
    GolosinaBean objGolosinaBean;
    ArrayList<GolosinaBean> lista;
    
    public GolosinaDAO(VentanaGolosina objVentanaGolosina){
        this.objVentanaGolosina=objVentanaGolosina;
        this.objConsultarGolosina = new ConsultarGolosina();
        
        //this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/vivandalogo.png")).getImage());
    }
    
    public void Listar(){
            lista=objConsultarGolosina.ConsultarGolosina();
            objVentanaGolosina.modelo.setNumRows(lista.size());
            int i=0;
            for(GolosinaBean objAs:lista){
                objVentanaGolosina.modelo.setValueAt(""+objAs.getCodigo(),i,0);
                objVentanaGolosina.modelo.setValueAt(""+objAs.getCategoria(),i,1);
                objVentanaGolosina.modelo.setValueAt(objAs.getSubcategoria(),i,2);
                objVentanaGolosina.modelo.setValueAt(""+objAs.getMarca(),i,3);
                objVentanaGolosina.modelo.setValueAt(objAs.getDescripcion(),i,4);
                objVentanaGolosina.modelo.setValueAt(""+objAs.getCantidad(),i,5);
                objVentanaGolosina.modelo.setValueAt(objAs.getPrecio(),i,6);
                objVentanaGolosina.modelo.setValueAt(objAs.getCantidad()*objAs.getPrecio(),i,7);
                objVentanaGolosina.modelo.setValueAt(""+objAs.getNombre(),i,8);
                    i++;
            }
            objVentanaGolosina.TablaGolosina.setModel(objVentanaGolosina.modelo);
    }
    
    public void BorrarDato(){
        int i=0;
        objGolosinaBean=null;
        if(objVentanaGolosina.txtCodigo.getText().length()!=0){
            objGolosinaBean= new GolosinaBean();
            objGolosinaBean.setCodigo(Integer.parseInt(objVentanaGolosina.txtCodigo.getText()));
            i= objConsultarGolosina.eliminarDatos(objGolosinaBean);
            
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
        objGolosinaBean=null;
            objGolosinaBean= new GolosinaBean();
            i= objConsultarGolosina.vaciarDatos(objGolosinaBean);
            
                        JOptionPane.showMessageDialog(null, "Registro Vaciado");
        }
        
        if (msj==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Registro No Vaciado");
        }
        
        if (msj==JOptionPane.CLOSED_OPTION){
            
        } 
    }
    
      public void Seleccionar(){
        objVentanaGolosina.txtCodigo.setText((String) objVentanaGolosina.TablaGolosina.getValueAt(objVentanaGolosina.TablaGolosina.getSelectedRow(),0));
            objVentanaGolosina.txtCategoria.setText(objVentanaGolosina.TablaGolosina.getValueAt(objVentanaGolosina.TablaGolosina.getSelectedRow(),1).toString());
            objVentanaGolosina.txtSubcategoria.setText(objVentanaGolosina.TablaGolosina.getValueAt(objVentanaGolosina.TablaGolosina.getSelectedRow(),2).toString());
            objVentanaGolosina.txtDescripcion.setText(objVentanaGolosina.TablaGolosina.getValueAt(objVentanaGolosina.TablaGolosina.getSelectedRow(),4).toString());
            objVentanaGolosina.txtCantidad.setText(objVentanaGolosina.TablaGolosina.getValueAt(objVentanaGolosina.TablaGolosina.getSelectedRow(),5).toString());
            objVentanaGolosina.txtPrecio.setText(objVentanaGolosina.TablaGolosina.getValueAt(objVentanaGolosina.TablaGolosina.getSelectedRow(),6).toString());
            String z = objVentanaGolosina.TablaGolosina.getValueAt(objVentanaGolosina.TablaGolosina.getSelectedRow(),8).toString();
            String s = objVentanaGolosina.TablaGolosina.getValueAt(objVentanaGolosina.TablaGolosina.getSelectedRow(),2).toString();
            
            ImageIcon producto = new ImageIcon(getClass().getResource("/Productos/Golosinas/"+s+"/"+z));
            ImageIcon icono = new ImageIcon(producto.getImage().getScaledInstance(objVentanaGolosina.Imagen.getWidth(), objVentanaGolosina.Imagen.getHeight(), Image.SCALE_DEFAULT));
            objVentanaGolosina.Imagen.setIcon(icono);
            //lblImagen.setIcon((Icon) TablaAseo.getValueAt(TablaAseo.getSelectedRow(),7));
            
            String y = objVentanaGolosina.TablaGolosina.getValueAt(objVentanaGolosina.TablaGolosina.getSelectedRow(),3).toString();
            ImageIcon marca = new ImageIcon(getClass().getResource("/Marcas/"+y+".png"));
            ImageIcon logo = new ImageIcon(marca.getImage().getScaledInstance(objVentanaGolosina.jLabel1.getWidth(), objVentanaGolosina.jLabel1.getHeight(), Image.SCALE_DEFAULT));
            objVentanaGolosina.jLabel1.setIcon(logo);
    }
      
    public void LimpiarCampos(){
        objVentanaGolosina.txtCodigo.setText("");
        objVentanaGolosina.txtCategoria.setText("");
        objVentanaGolosina.txtSubcategoria.setText("");
        objVentanaGolosina.txtDescripcion.setText("");
        objVentanaGolosina.txtCantidad.setText("");
        objVentanaGolosina.txtPrecio.setText("");
    }
    
    public void ActualizarDatos(){
        int i=0;
        objGolosinaBean=null;
        if(objVentanaGolosina.txtCodigo.getText().length()!=0){
            objGolosinaBean= new GolosinaBean();
            objGolosinaBean.setCodigo(Integer.parseInt(objVentanaGolosina.txtCodigo.getText()));
            objGolosinaBean.setDescripcion(objVentanaGolosina.txtDescripcion.getText());
            objGolosinaBean.setCantidad(Integer.parseInt(objVentanaGolosina.txtCantidad.getText()));
            objGolosinaBean.setPrecio(Double.parseDouble(objVentanaGolosina.txtPrecio.getText()));
            
            ConsultarGolosina objM=new ConsultarGolosina();
            i=objM.modificarDatos(objGolosinaBean);
        
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
        if(objVentanaGolosina.btnOnOff.isSelected()){
            objVentanaGolosina.btnOnOff.setBackground(Color.green);
            objVentanaGolosina.btnOnOff.setText("ON");
            Listar();
            objVentanaGolosina.TablaGolosina.setVisible(true);
        }else{
            objVentanaGolosina.btnOnOff.setBackground(Color.red);
            objVentanaGolosina.btnOnOff.setText("OFF");
            objVentanaGolosina.TablaGolosina.setVisible(false);
        }
    }
}
