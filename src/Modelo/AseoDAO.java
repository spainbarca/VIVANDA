package Modelo;

import java.awt.Image;
import java.util.*;
import javax.swing.*;
import Vista.VentanaAseo;
import java.awt.Color;

public class AseoDAO {
    VentanaAseo objVentanaAseo;
    ConsultarAseo objConsultarAseo;
    AseoBean objAseoBean;
    ArrayList<AseoBean> lista;
    
    public AseoDAO(VentanaAseo objVentanaAseo){
        this.objVentanaAseo=objVentanaAseo;
        this.objConsultarAseo = new ConsultarAseo();
        
        //this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/vivandalogo.png")).getImage());
    }
    
    public void Listar(){
            lista=objConsultarAseo.ConsultarAseo();
            objVentanaAseo.modelo.setNumRows(lista.size());
            int i=0;
            for(AseoBean objAs:lista){
                objVentanaAseo.modelo.setValueAt(""+objAs.getCodigo(),i,0);
                objVentanaAseo.modelo.setValueAt(""+objAs.getCategoria(),i,1);
                objVentanaAseo.modelo.setValueAt(objAs.getSubcategoria(),i,2);
                objVentanaAseo.modelo.setValueAt(""+objAs.getMarca(),i,3);
                objVentanaAseo.modelo.setValueAt(objAs.getDescripcion(),i,4);
                objVentanaAseo.modelo.setValueAt(""+objAs.getCantidad(),i,5);
                objVentanaAseo.modelo.setValueAt(objAs.getPrecio(),i,6);
                objVentanaAseo.modelo.setValueAt(objAs.getCantidad()*objAs.getPrecio(),i,7);
                objVentanaAseo.modelo.setValueAt(""+objAs.getNombre(),i,8);
                    i++;
            }
            objVentanaAseo.TablaAseo.setModel(objVentanaAseo.modelo);
    }
    
    public void BorrarDato(){
        int i=0;
        objAseoBean=null;
        if(objVentanaAseo.txtCodigo.getText().length()!=0){
            objAseoBean= new AseoBean();
            objAseoBean.setCodigo(Integer.parseInt(objVentanaAseo.txtCodigo.getText()));
            i= objConsultarAseo.eliminarDatos(objAseoBean);
            
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
        objAseoBean=null;
            objAseoBean= new AseoBean();
            i= objConsultarAseo.vaciarDatos(objAseoBean);
            
                        JOptionPane.showMessageDialog(null, "Registro Vaciado");
        }
        
        if (msj==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Registro No Vaciado");
        }
        
        if (msj==JOptionPane.CLOSED_OPTION){
            
        } 
    }
    
      public void Seleccionar(){
        objVentanaAseo.txtCodigo.setText((String) objVentanaAseo.TablaAseo.getValueAt(objVentanaAseo.TablaAseo.getSelectedRow(),0));
            objVentanaAseo.txtCategoria.setText(objVentanaAseo.TablaAseo.getValueAt(objVentanaAseo.TablaAseo.getSelectedRow(),1).toString());
            objVentanaAseo.txtSubcategoria.setText(objVentanaAseo.TablaAseo.getValueAt(objVentanaAseo.TablaAseo.getSelectedRow(),2).toString());
            objVentanaAseo.txtDescripcion.setText(objVentanaAseo.TablaAseo.getValueAt(objVentanaAseo.TablaAseo.getSelectedRow(),4).toString());
            objVentanaAseo.txtCantidad.setText(objVentanaAseo.TablaAseo.getValueAt(objVentanaAseo.TablaAseo.getSelectedRow(),5).toString());
            objVentanaAseo.txtPrecio.setText(objVentanaAseo.TablaAseo.getValueAt(objVentanaAseo.TablaAseo.getSelectedRow(),6).toString());
            String z = objVentanaAseo.TablaAseo.getValueAt(objVentanaAseo.TablaAseo.getSelectedRow(),8).toString();
            String s= objVentanaAseo.TablaAseo.getValueAt(objVentanaAseo.TablaAseo.getSelectedRow(),2).toString();
            
            ImageIcon producto = new ImageIcon(getClass().getResource("/Productos/Aseo/"+s+"/"+z));
            ImageIcon icono = new ImageIcon(producto.getImage().getScaledInstance(objVentanaAseo.Imagen.getWidth(), objVentanaAseo.Imagen.getHeight(), Image.SCALE_DEFAULT));
            objVentanaAseo.Imagen.setIcon(icono);
            //lblImagen.setIcon((Icon) TablaAseo.getValueAt(TablaAseo.getSelectedRow(),7));
            
            String y = objVentanaAseo.TablaAseo.getValueAt(objVentanaAseo.TablaAseo.getSelectedRow(),3).toString();
            ImageIcon marca = new ImageIcon(getClass().getResource("/Marcas/"+y+".png"));
            ImageIcon logo = new ImageIcon(marca.getImage().getScaledInstance(objVentanaAseo.jLabel1.getWidth(), objVentanaAseo.jLabel1.getHeight(), Image.SCALE_DEFAULT));
            objVentanaAseo.jLabel1.setIcon(logo);
    }
      
    public void LimpiarCampos(){
        objVentanaAseo.txtCodigo.setText("");
        objVentanaAseo.txtCategoria.setText("");
        objVentanaAseo.txtSubcategoria.setText("");
        objVentanaAseo.txtDescripcion.setText("");
        objVentanaAseo.txtCantidad.setText("");
        objVentanaAseo.txtPrecio.setText("");
    }
    
    public void ActualizarDatos(){
        int i=0;
        objAseoBean=null;
        if(objVentanaAseo.txtCodigo.getText().length()!=0){
            objAseoBean= new AseoBean();
            objAseoBean.setCodigo(Integer.parseInt(objVentanaAseo.txtCodigo.getText()));
            //objAseoBean.setCategoria(txtCategoria.getText());
            //objAseoBean.setSubcategoria(txtSubcategoria.getText());
            objAseoBean.setDescripcion(objVentanaAseo.txtDescripcion.getText());
            objAseoBean.setCantidad(Integer.parseInt(objVentanaAseo.txtCantidad.getText()));
            objAseoBean.setPrecio(Double.parseDouble(objVentanaAseo.txtPrecio.getText()));
            
            ConsultarAseo objM=new ConsultarAseo();
            i=objM.modificarDatos(objAseoBean);
        
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
        if(objVentanaAseo.btnOnOff.isSelected()){
            objVentanaAseo.btnOnOff.setBackground(Color.green);
            objVentanaAseo.btnOnOff.setText("ON");
            Listar();
            objVentanaAseo.TablaAseo.setVisible(true);
        }else{
            objVentanaAseo.btnOnOff.setBackground(Color.red);
            objVentanaAseo.btnOnOff.setText("OFF");
            objVentanaAseo.TablaAseo.setVisible(false);
        }
    }
}
