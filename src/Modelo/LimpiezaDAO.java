package Modelo;

import java.awt.Image;
import java.util.*;
import javax.swing.*;
import Vista.VentanaLimpieza;
import java.awt.Color;

public class LimpiezaDAO {
    VentanaLimpieza objVentanaLimpieza;
    ConsultarLimpieza objConsultarLimpieza;
    LimpiezaBean objLimpiezaBean;
    ArrayList<LimpiezaBean> lista;
    
    public LimpiezaDAO(VentanaLimpieza objVentanaAseo){
        this.objVentanaLimpieza=objVentanaAseo;
        this.objConsultarLimpieza = new ConsultarLimpieza();
        
        //this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/vivandalogo.png")).getImage());
    }
    
    public void Listar(){
            lista=objConsultarLimpieza.ConsultarLimpieza();
            objVentanaLimpieza.modelo.setNumRows(lista.size());
            int i=0;
            for(LimpiezaBean objAs:lista){
                objVentanaLimpieza.modelo.setValueAt(""+objAs.getCodigo(),i,0);
                objVentanaLimpieza.modelo.setValueAt(""+objAs.getCategoria(),i,1);
                objVentanaLimpieza.modelo.setValueAt(objAs.getSubcategoria(),i,2);
                objVentanaLimpieza.modelo.setValueAt(""+objAs.getMarca(),i,3);
                objVentanaLimpieza.modelo.setValueAt(objAs.getDescripcion(),i,4);
                objVentanaLimpieza.modelo.setValueAt(""+objAs.getCantidad(),i,5);
                objVentanaLimpieza.modelo.setValueAt(objAs.getPrecio(),i,6);
                objVentanaLimpieza.modelo.setValueAt(objAs.getCantidad()*objAs.getPrecio(),i,7);
                objVentanaLimpieza.modelo.setValueAt(""+objAs.getNombre(),i,8);
                    i++;
            }
            objVentanaLimpieza.TablaLimpieza.setModel(objVentanaLimpieza.modelo);
    }
    
    public void BorrarDato(){
        int i=0;
        objLimpiezaBean=null;
        if(objVentanaLimpieza.txtCodigo.getText().length()!=0){
            objLimpiezaBean= new LimpiezaBean();
            objLimpiezaBean.setCodigo(Integer.parseInt(objVentanaLimpieza.txtCodigo.getText()));
            i= objConsultarLimpieza.eliminarDatos(objLimpiezaBean);
            
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
        objLimpiezaBean=null;
            objLimpiezaBean= new LimpiezaBean();
            i= objConsultarLimpieza.vaciarDatos(objLimpiezaBean);
            
                        JOptionPane.showMessageDialog(null, "Registro Vaciado");
        }
        
        if (msj==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Registro No Vaciado");
        }
        
        if (msj==JOptionPane.CLOSED_OPTION){
            
        } 
    }
    
      public void Seleccionar(){
        objVentanaLimpieza.txtCodigo.setText((String) objVentanaLimpieza.TablaLimpieza.getValueAt(objVentanaLimpieza.TablaLimpieza.getSelectedRow(),0));
            objVentanaLimpieza.txtCategoria.setText(objVentanaLimpieza.TablaLimpieza.getValueAt(objVentanaLimpieza.TablaLimpieza.getSelectedRow(),1).toString());
            objVentanaLimpieza.txtSubcategoria.setText(objVentanaLimpieza.TablaLimpieza.getValueAt(objVentanaLimpieza.TablaLimpieza.getSelectedRow(),2).toString());
            objVentanaLimpieza.txtDescripcion.setText(objVentanaLimpieza.TablaLimpieza.getValueAt(objVentanaLimpieza.TablaLimpieza.getSelectedRow(),4).toString());
            objVentanaLimpieza.txtCantidad.setText(objVentanaLimpieza.TablaLimpieza.getValueAt(objVentanaLimpieza.TablaLimpieza.getSelectedRow(),5).toString());
            objVentanaLimpieza.txtPrecio.setText(objVentanaLimpieza.TablaLimpieza.getValueAt(objVentanaLimpieza.TablaLimpieza.getSelectedRow(),6).toString());
            String z = objVentanaLimpieza.TablaLimpieza.getValueAt(objVentanaLimpieza.TablaLimpieza.getSelectedRow(),8).toString();
            String s = objVentanaLimpieza.TablaLimpieza.getValueAt(objVentanaLimpieza.TablaLimpieza.getSelectedRow(),2).toString();
            
            ImageIcon producto = new ImageIcon(getClass().getResource("/Productos/Limpieza/"+s+"/"+z));
            ImageIcon icono = new ImageIcon(producto.getImage().getScaledInstance(objVentanaLimpieza.Imagen.getWidth(), objVentanaLimpieza.Imagen.getHeight(), Image.SCALE_DEFAULT));
            objVentanaLimpieza.Imagen.setIcon(icono);
            //lblImagen.setIcon((Icon) TablaAseo.getValueAt(TablaAseo.getSelectedRow(),7));
            
            String y = objVentanaLimpieza.TablaLimpieza.getValueAt(objVentanaLimpieza.TablaLimpieza.getSelectedRow(),3).toString();
            ImageIcon marca = new ImageIcon(getClass().getResource("/Marcas/"+y+".png"));
            ImageIcon logo = new ImageIcon(marca.getImage().getScaledInstance(objVentanaLimpieza.jLabel1.getWidth(), objVentanaLimpieza.jLabel1.getHeight(), Image.SCALE_DEFAULT));
            objVentanaLimpieza.jLabel1.setIcon(logo);
    }
      
    public void LimpiarCampos(){
        objVentanaLimpieza.txtCodigo.setText("");
        objVentanaLimpieza.txtCategoria.setText("");
        objVentanaLimpieza.txtSubcategoria.setText("");
        objVentanaLimpieza.txtDescripcion.setText("");
        objVentanaLimpieza.txtCantidad.setText("");
        objVentanaLimpieza.txtPrecio.setText("");
    }
    
    public void ActualizarDatos(){
        int i=0;
        objLimpiezaBean=null;
        if(objVentanaLimpieza.txtCodigo.getText().length()!=0){
            objLimpiezaBean= new LimpiezaBean();
            objLimpiezaBean.setCodigo(Integer.parseInt(objVentanaLimpieza.txtCodigo.getText()));
            objLimpiezaBean.setDescripcion(objVentanaLimpieza.txtDescripcion.getText());
            objLimpiezaBean.setCantidad(Integer.parseInt(objVentanaLimpieza.txtCantidad.getText()));
            objLimpiezaBean.setPrecio(Double.parseDouble(objVentanaLimpieza.txtPrecio.getText()));
            
            ConsultarLimpieza objM=new ConsultarLimpieza();
            i=objM.modificarDatos(objLimpiezaBean);
        
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
        if(objVentanaLimpieza.btnOnOff.isSelected()){
            objVentanaLimpieza.btnOnOff.setBackground(Color.green);
            objVentanaLimpieza.btnOnOff.setText("ON");
            Listar();
            objVentanaLimpieza.TablaLimpieza.setVisible(true);
        }else{
            objVentanaLimpieza.btnOnOff.setBackground(Color.red);
            objVentanaLimpieza.btnOnOff.setText("OFF");
            objVentanaLimpieza.TablaLimpieza.setVisible(false);
        }
    }
}
