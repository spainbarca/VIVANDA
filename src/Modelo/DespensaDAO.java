package Modelo;

import java.awt.Image;
import java.util.*;
import javax.swing.*;
import Vista.VentanaDespensa;
import java.awt.Color;

public class DespensaDAO {
    VentanaDespensa objVentanaDespensa;
    ConsultarDespensa objConsultarDespensa;
    DespensaBean objDespensaBean;
    ArrayList<DespensaBean> lista;
    
    public DespensaDAO(VentanaDespensa objVentanaDespensa){
        this.objVentanaDespensa=objVentanaDespensa;
        this.objConsultarDespensa = new ConsultarDespensa();
        
        //this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/vivandalogo.png")).getImage());
    }
    
    public void Listar(){
            lista=objConsultarDespensa.ConsultarDespensa();
            objVentanaDespensa.modelo.setNumRows(lista.size());
            int i=0;
            for(DespensaBean objAs:lista){
                objVentanaDespensa.modelo.setValueAt(""+objAs.getCodigo(),i,0);
                objVentanaDespensa.modelo.setValueAt(""+objAs.getCategoria(),i,1);
                objVentanaDespensa.modelo.setValueAt(objAs.getSubcategoria(),i,2);
                objVentanaDespensa.modelo.setValueAt(""+objAs.getMarca(),i,3);
                objVentanaDespensa.modelo.setValueAt(objAs.getDescripcion(),i,4);
                objVentanaDespensa.modelo.setValueAt(""+objAs.getCantidad(),i,5);
                objVentanaDespensa.modelo.setValueAt(objAs.getPrecio(),i,6);
                objVentanaDespensa.modelo.setValueAt(objAs.getCantidad()*objAs.getPrecio(),i,7);
                objVentanaDespensa.modelo.setValueAt(""+objAs.getNombre(),i,8);
                    i++;
            }
            objVentanaDespensa.TablaDespensa.setModel(objVentanaDespensa.modelo);
    }
    
    public void BorrarDato(){
        int i=0;
        objDespensaBean=null;
        if(objVentanaDespensa.txtCodigo.getText().length()!=0){
            objDespensaBean= new DespensaBean();
            objDespensaBean.setCodigo(Integer.parseInt(objVentanaDespensa.txtCodigo.getText()));
            i= objConsultarDespensa.eliminarDatos(objDespensaBean);
            
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
        objDespensaBean=null;
            objDespensaBean= new DespensaBean();
            i= objConsultarDespensa.vaciarDatos(objDespensaBean);
            
                        JOptionPane.showMessageDialog(null, "Registro Vaciado");
        }
        
        if (msj==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Registro No Vaciado");
        }
        
        if (msj==JOptionPane.CLOSED_OPTION){
            
        } 
    }
    
      public void Seleccionar(){
        objVentanaDespensa.txtCodigo.setText((String) objVentanaDespensa.TablaDespensa.getValueAt(objVentanaDespensa.TablaDespensa.getSelectedRow(),0));
            objVentanaDespensa.txtCategoria.setText(objVentanaDespensa.TablaDespensa.getValueAt(objVentanaDespensa.TablaDespensa.getSelectedRow(),1).toString());
            objVentanaDespensa.txtSubcategoria.setText(objVentanaDespensa.TablaDespensa.getValueAt(objVentanaDespensa.TablaDespensa.getSelectedRow(),2).toString());
            objVentanaDespensa.txtDescripcion.setText(objVentanaDespensa.TablaDespensa.getValueAt(objVentanaDespensa.TablaDespensa.getSelectedRow(),4).toString());
            objVentanaDespensa.txtCantidad.setText(objVentanaDespensa.TablaDespensa.getValueAt(objVentanaDespensa.TablaDespensa.getSelectedRow(),5).toString());
            objVentanaDespensa.txtPrecio.setText(objVentanaDespensa.TablaDespensa.getValueAt(objVentanaDespensa.TablaDespensa.getSelectedRow(),6).toString());
            String z = objVentanaDespensa.TablaDespensa.getValueAt(objVentanaDespensa.TablaDespensa.getSelectedRow(),8).toString();
            String s = objVentanaDespensa.TablaDespensa.getValueAt(objVentanaDespensa.TablaDespensa.getSelectedRow(),2).toString();
            
            ImageIcon producto = new ImageIcon(getClass().getResource("/Productos/Despensa/"+s+"/"+z));
            ImageIcon icono = new ImageIcon(producto.getImage().getScaledInstance(objVentanaDespensa.Imagen.getWidth(), objVentanaDespensa.Imagen.getHeight(), Image.SCALE_DEFAULT));
            objVentanaDespensa.Imagen.setIcon(icono);
            //lblImagen.setIcon((Icon) TablaAseo.getValueAt(TablaAseo.getSelectedRow(),7));
            
            String y = objVentanaDespensa.TablaDespensa.getValueAt(objVentanaDespensa.TablaDespensa.getSelectedRow(),3).toString();
            ImageIcon marca = new ImageIcon(getClass().getResource("/Marcas/"+y+".png"));
            ImageIcon logo = new ImageIcon(marca.getImage().getScaledInstance(objVentanaDespensa.jLabel1.getWidth(), objVentanaDespensa.jLabel1.getHeight(), Image.SCALE_DEFAULT));
            objVentanaDespensa.jLabel1.setIcon(logo);
    }
      
    public void LimpiarCampos(){
        objVentanaDespensa.txtCodigo.setText("");
        objVentanaDespensa.txtCategoria.setText("");
        objVentanaDespensa.txtSubcategoria.setText("");
        objVentanaDespensa.txtDescripcion.setText("");
        objVentanaDespensa.txtCantidad.setText("");
        objVentanaDespensa.txtPrecio.setText("");
    }
    
    public void ActualizarDatos(){
        int i=0;
        objDespensaBean=null;
        if(objVentanaDespensa.txtCodigo.getText().length()!=0){
            objDespensaBean= new DespensaBean();
            objDespensaBean.setCodigo(Integer.parseInt(objVentanaDespensa.txtCodigo.getText()));
            //objAseoBean.setCategoria(txtCategoria.getText());
            //objAseoBean.setSubcategoria(txtSubcategoria.getText());
            objDespensaBean.setDescripcion(objVentanaDespensa.txtDescripcion.getText());
            objDespensaBean.setCantidad(Integer.parseInt(objVentanaDespensa.txtCantidad.getText()));
            objDespensaBean.setPrecio(Double.parseDouble(objVentanaDespensa.txtPrecio.getText()));
            
            ConsultarDespensa objM=new ConsultarDespensa();
            i=objM.modificarDatos(objDespensaBean);
        
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
        if(objVentanaDespensa.btnOnOff.isSelected()){
            objVentanaDespensa.btnOnOff.setBackground(Color.green);
            objVentanaDespensa.btnOnOff.setText("ON");
            Listar();
            objVentanaDespensa.TablaDespensa.setVisible(true);
        }else{
            objVentanaDespensa.btnOnOff.setBackground(Color.red);
            objVentanaDespensa.btnOnOff.setText("OFF");
            objVentanaDespensa.TablaDespensa.setVisible(false);
        }
    }
}
