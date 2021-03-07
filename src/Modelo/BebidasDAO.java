package Modelo;

import java.awt.Image;
import java.util.*;
import javax.swing.*;
import Vista.VentanaBebidas;
import java.awt.Color;

public class BebidasDAO {
    VentanaBebidas objVentanaBebidas;
    ConsultarBebidas objConsultarBebidas;
    BebidasBean objBebidasBean;
    ArrayList<BebidasBean> lista;
    
    public BebidasDAO(VentanaBebidas objVentanaBebidas){
        this.objVentanaBebidas=objVentanaBebidas;
        this.objConsultarBebidas = new ConsultarBebidas();
        
        //this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/vivandalogo.png")).getImage());
    }
    
    public void Listar(){
            lista=objConsultarBebidas.ConsultarBebidas();
            objVentanaBebidas.modelo.setNumRows(lista.size());
            int i=0;
            for(BebidasBean objAs:lista){
                objVentanaBebidas.modelo.setValueAt(""+objAs.getCodigo(),i,0);
                objVentanaBebidas.modelo.setValueAt(""+objAs.getCategoria(),i,1);
                objVentanaBebidas.modelo.setValueAt(objAs.getSubcategoria(),i,2);
                objVentanaBebidas.modelo.setValueAt(""+objAs.getMarca(),i,3);
                objVentanaBebidas.modelo.setValueAt(objAs.getDescripcion(),i,4);
                objVentanaBebidas.modelo.setValueAt(""+objAs.getCantidad(),i,5);
                objVentanaBebidas.modelo.setValueAt(objAs.getPrecio(),i,6);
                objVentanaBebidas.modelo.setValueAt(objAs.getCantidad()*objAs.getPrecio(),i,7);
                objVentanaBebidas.modelo.setValueAt(""+objAs.getNombre(),i,8);
                    i++;
            }
            objVentanaBebidas.TablaBebidas.setModel(objVentanaBebidas.modelo);
    }
    
    public void BorrarDato(){
        int i=0;
        objBebidasBean=null;
        if(objVentanaBebidas.txtCodigo.getText().length()!=0){
            objBebidasBean= new BebidasBean();
            objBebidasBean.setCodigo(Integer.parseInt(objVentanaBebidas.txtCodigo.getText()));
            i= objConsultarBebidas.eliminarDatos(objBebidasBean);
            
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
        objBebidasBean=null;
            objBebidasBean= new BebidasBean();
            i= objConsultarBebidas.vaciarDatos(objBebidasBean);
            
                        JOptionPane.showMessageDialog(null, "Registro Vaciado");
        }
        
        if (msj==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Registro No Vaciado");
        }
        
        if (msj==JOptionPane.CLOSED_OPTION){
            
        } 
    }
    
      public void Seleccionar(){
        objVentanaBebidas.txtCodigo.setText((String) objVentanaBebidas.TablaBebidas.getValueAt(objVentanaBebidas.TablaBebidas.getSelectedRow(),0));
            objVentanaBebidas.txtCategoria.setText(objVentanaBebidas.TablaBebidas.getValueAt(objVentanaBebidas.TablaBebidas.getSelectedRow(),1).toString());
            objVentanaBebidas.txtSubcategoria.setText(objVentanaBebidas.TablaBebidas.getValueAt(objVentanaBebidas.TablaBebidas.getSelectedRow(),2).toString());
            objVentanaBebidas.txtDescripcion.setText(objVentanaBebidas.TablaBebidas.getValueAt(objVentanaBebidas.TablaBebidas.getSelectedRow(),4).toString());
            objVentanaBebidas.txtCantidad.setText(objVentanaBebidas.TablaBebidas.getValueAt(objVentanaBebidas.TablaBebidas.getSelectedRow(),5).toString());
            objVentanaBebidas.txtPrecio.setText(objVentanaBebidas.TablaBebidas.getValueAt(objVentanaBebidas.TablaBebidas.getSelectedRow(),6).toString());
            String z = objVentanaBebidas.TablaBebidas.getValueAt(objVentanaBebidas.TablaBebidas.getSelectedRow(),8).toString();
            String s = objVentanaBebidas.TablaBebidas.getValueAt(objVentanaBebidas.TablaBebidas.getSelectedRow(),2).toString();
            
            ImageIcon producto = new ImageIcon(getClass().getResource("/Productos/Bebidas/"+s+"/"+z));
            ImageIcon icono = new ImageIcon(producto.getImage().getScaledInstance(objVentanaBebidas.Imagen.getWidth(), objVentanaBebidas.Imagen.getHeight(), Image.SCALE_DEFAULT));
            objVentanaBebidas.Imagen.setIcon(icono);
            //lblImagen.setIcon((Icon) TablaAseo.getValueAt(TablaAseo.getSelectedRow(),7));
            
            String y = objVentanaBebidas.TablaBebidas.getValueAt(objVentanaBebidas.TablaBebidas.getSelectedRow(),3).toString();
            ImageIcon marca = new ImageIcon(getClass().getResource("/Marcas/"+y+".png"));
            ImageIcon logo = new ImageIcon(marca.getImage().getScaledInstance(objVentanaBebidas.jLabel1.getWidth(), objVentanaBebidas.jLabel1.getHeight(), Image.SCALE_DEFAULT));
            objVentanaBebidas.jLabel1.setIcon(logo);
    }
      
    public void LimpiarCampos(){
        objVentanaBebidas.txtCodigo.setText("");
        objVentanaBebidas.txtCategoria.setText("");
        objVentanaBebidas.txtSubcategoria.setText("");
        objVentanaBebidas.txtDescripcion.setText("");
        objVentanaBebidas.txtCantidad.setText("");
        objVentanaBebidas.txtPrecio.setText("");
    }
    
    public void ActualizarDatos(){
        int i=0;
        objBebidasBean=null;
        if(objVentanaBebidas.txtCodigo.getText().length()!=0){
            objBebidasBean= new BebidasBean();
            objBebidasBean.setCodigo(Integer.parseInt(objVentanaBebidas.txtCodigo.getText()));
            //objAseoBean.setCategoria(txtCategoria.getText());
            //objAseoBean.setSubcategoria(txtSubcategoria.getText());
            objBebidasBean.setDescripcion(objVentanaBebidas.txtDescripcion.getText());
            objBebidasBean.setCantidad(Integer.parseInt(objVentanaBebidas.txtCantidad.getText()));
            objBebidasBean.setPrecio(Double.parseDouble(objVentanaBebidas.txtPrecio.getText()));
            
            ConsultarBebidas objM=new ConsultarBebidas();
            i=objM.modificarDatos(objBebidasBean);
        
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
        if(objVentanaBebidas.btnOnOff.isSelected()){
            objVentanaBebidas.btnOnOff.setBackground(Color.green);
            objVentanaBebidas.btnOnOff.setText("ON");
            Listar();
            objVentanaBebidas.TablaBebidas.setVisible(true);
        }else{
            objVentanaBebidas.btnOnOff.setBackground(Color.red);
            objVentanaBebidas.btnOnOff.setText("OFF");
            objVentanaBebidas.TablaBebidas.setVisible(false);
        }
    }
}
