package Modelo;

import java.awt.Image;
import java.util.*;
import javax.swing.*;
import Vista.VentanaLacteos;
import java.awt.Color;

public class LacteosDAO {
    VentanaLacteos objVentanaLacteos;
    ConsultarLacteos objConsultarLacteos;
    LacteosBean objLacteosBean;
    ArrayList<LacteosBean> lista;
    
    public LacteosDAO(VentanaLacteos objVentanaLacteos){
        this.objVentanaLacteos=objVentanaLacteos;
        this.objConsultarLacteos = new ConsultarLacteos();
        
        //this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/vivandalogo.png")).getImage());
    }
    
    public void Listar(){
            lista=objConsultarLacteos.ConsultarLacteos();
            objVentanaLacteos.modelo.setNumRows(lista.size());
            int i=0;
            for(LacteosBean objAs:lista){
                objVentanaLacteos.modelo.setValueAt(""+objAs.getCodigo(),i,0);
                objVentanaLacteos.modelo.setValueAt(""+objAs.getCategoria(),i,1);
                objVentanaLacteos.modelo.setValueAt(objAs.getSubcategoria(),i,2);
                objVentanaLacteos.modelo.setValueAt(""+objAs.getMarca(),i,3);
                objVentanaLacteos.modelo.setValueAt(objAs.getDescripcion(),i,4);
                objVentanaLacteos.modelo.setValueAt(""+objAs.getCantidad(),i,5);
                objVentanaLacteos.modelo.setValueAt(objAs.getPrecio(),i,6);
                objVentanaLacteos.modelo.setValueAt(objAs.getCantidad()*objAs.getPrecio(),i,7);
                objVentanaLacteos.modelo.setValueAt(""+objAs.getNombre(),i,8);
                    i++;
            }
            objVentanaLacteos.TablaLacteos.setModel(objVentanaLacteos.modelo);
    }
    
    public void BorrarDato(){
        int i=0;
        objLacteosBean=null;
        if(objVentanaLacteos.txtCodigo.getText().length()!=0){
            objLacteosBean= new LacteosBean();
            objLacteosBean.setCodigo(Integer.parseInt(objVentanaLacteos.txtCodigo.getText()));
            i= objConsultarLacteos.eliminarDatos(objLacteosBean);
            
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
        objLacteosBean=null;
            objLacteosBean= new LacteosBean();
            i= objConsultarLacteos.vaciarDatos(objLacteosBean);
            
                        JOptionPane.showMessageDialog(null, "Registro Vaciado");
        }
        
        if (msj==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Registro No Vaciado");
        }
        
        if (msj==JOptionPane.CLOSED_OPTION){
            
        } 
    }
    
      public void Seleccionar(){
        objVentanaLacteos.txtCodigo.setText((String) objVentanaLacteos.TablaLacteos.getValueAt(objVentanaLacteos.TablaLacteos.getSelectedRow(),0));
            objVentanaLacteos.txtCategoria.setText(objVentanaLacteos.TablaLacteos.getValueAt(objVentanaLacteos.TablaLacteos.getSelectedRow(),1).toString());
            objVentanaLacteos.txtSubcategoria.setText(objVentanaLacteos.TablaLacteos.getValueAt(objVentanaLacteos.TablaLacteos.getSelectedRow(),2).toString());
            objVentanaLacteos.txtDescripcion.setText(objVentanaLacteos.TablaLacteos.getValueAt(objVentanaLacteos.TablaLacteos.getSelectedRow(),4).toString());
            objVentanaLacteos.txtCantidad.setText(objVentanaLacteos.TablaLacteos.getValueAt(objVentanaLacteos.TablaLacteos.getSelectedRow(),5).toString());
            objVentanaLacteos.txtPrecio.setText(objVentanaLacteos.TablaLacteos.getValueAt(objVentanaLacteos.TablaLacteos.getSelectedRow(),6).toString());
            String z = objVentanaLacteos.TablaLacteos.getValueAt(objVentanaLacteos.TablaLacteos.getSelectedRow(),8).toString();
            String s= objVentanaLacteos.TablaLacteos.getValueAt(objVentanaLacteos.TablaLacteos.getSelectedRow(),2).toString();
            
            ImageIcon producto = new ImageIcon(getClass().getResource("/Productos/Lacteos/"+s+"/"+z));
            ImageIcon icono = new ImageIcon(producto.getImage().getScaledInstance(objVentanaLacteos.Imagen.getWidth(), objVentanaLacteos.Imagen.getHeight(), Image.SCALE_DEFAULT));
            objVentanaLacteos.Imagen.setIcon(icono);
            //lblImagen.setIcon((Icon) TablaAseo.getValueAt(TablaAseo.getSelectedRow(),7));
            
            String y = objVentanaLacteos.TablaLacteos.getValueAt(objVentanaLacteos.TablaLacteos.getSelectedRow(),3).toString();
            ImageIcon marca = new ImageIcon(getClass().getResource("/Marcas/"+y+".png"));
            ImageIcon logo = new ImageIcon(marca.getImage().getScaledInstance(objVentanaLacteos.jLabel1.getWidth(), objVentanaLacteos.jLabel1.getHeight(), Image.SCALE_DEFAULT));
            objVentanaLacteos.jLabel1.setIcon(logo);
    }
      
    public void LimpiarCampos(){
        objVentanaLacteos.txtCodigo.setText("");
        objVentanaLacteos.txtCategoria.setText("");
        objVentanaLacteos.txtSubcategoria.setText("");
        objVentanaLacteos.txtDescripcion.setText("");
        objVentanaLacteos.txtCantidad.setText("");
        objVentanaLacteos.txtPrecio.setText("");
    }
    
    public void ActualizarDatos(){
        int i=0;
        objLacteosBean=null;
        if(objVentanaLacteos.txtCodigo.getText().length()!=0){
            objLacteosBean= new LacteosBean();
            objLacteosBean.setCodigo(Integer.parseInt(objVentanaLacteos.txtCodigo.getText()));
            //objAseoBean.setCategoria(txtCategoria.getText());
            //objAseoBean.setSubcategoria(txtSubcategoria.getText());
            objLacteosBean.setDescripcion(objVentanaLacteos.txtDescripcion.getText());
            objLacteosBean.setCantidad(Integer.parseInt(objVentanaLacteos.txtCantidad.getText()));
            objLacteosBean.setPrecio(Double.parseDouble(objVentanaLacteos.txtPrecio.getText()));
            
            ConsultarLacteos objM=new ConsultarLacteos();
            i=objM.modificarDatos(objLacteosBean);
        
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
        if(objVentanaLacteos.btnOnOff.isSelected()){
            objVentanaLacteos.btnOnOff.setBackground(Color.green);
            objVentanaLacteos.btnOnOff.setText("ON");
            Listar();
            objVentanaLacteos.TablaLacteos.setVisible(true);
        }else{
            objVentanaLacteos.btnOnOff.setBackground(Color.red);
            objVentanaLacteos.btnOnOff.setText("OFF");
            objVentanaLacteos.TablaLacteos.setVisible(false);
        }
    }
}
