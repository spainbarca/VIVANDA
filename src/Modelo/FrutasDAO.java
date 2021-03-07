package Modelo;

import java.awt.Image;
import java.util.*;
import javax.swing.*;
import Vista.VentanaFrutas;
import java.awt.Color;

public class FrutasDAO {
    VentanaFrutas objVentanaFrutas;
    ConsultarFrutas objConsultarFrutas;
    FrutasBean objFrutasBean;
    ArrayList<FrutasBean> lista;
    
    public FrutasDAO(VentanaFrutas objVentanaFrutas){
        this.objVentanaFrutas=objVentanaFrutas;
        this.objConsultarFrutas = new ConsultarFrutas();
        
        //this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/vivandalogo.png")).getImage());
    }
    
    public void Listar(){
            lista=objConsultarFrutas.ConsultarFrutas();
            objVentanaFrutas.modelo.setNumRows(lista.size());
            int i=0;
            for(FrutasBean objAs:lista){
                objVentanaFrutas.modelo.setValueAt(""+objAs.getCodigo(),i,0);
                objVentanaFrutas.modelo.setValueAt(""+objAs.getCategoria(),i,1);
                objVentanaFrutas.modelo.setValueAt(objAs.getSubcategoria(),i,2);
                objVentanaFrutas.modelo.setValueAt(""+objAs.getMarca(),i,3);
                objVentanaFrutas.modelo.setValueAt(objAs.getDescripcion(),i,4);
                objVentanaFrutas.modelo.setValueAt(""+objAs.getCantidad(),i,5);
                objVentanaFrutas.modelo.setValueAt(objAs.getPrecio(),i,6);
                objVentanaFrutas.modelo.setValueAt(objAs.getCantidad()*objAs.getPrecio(),i,7);
                objVentanaFrutas.modelo.setValueAt(""+objAs.getNombre(),i,8);
                    i++;
            }
            objVentanaFrutas.TablaFrutas.setModel(objVentanaFrutas.modelo);
    }
    
    public void BorrarDato(){
        int i=0;
        objFrutasBean=null;
        if(objVentanaFrutas.txtCodigo.getText().length()!=0){
            objFrutasBean= new FrutasBean();
            objFrutasBean.setCodigo(Integer.parseInt(objVentanaFrutas.txtCodigo.getText()));
            i= objConsultarFrutas.eliminarDatos(objFrutasBean);
            
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
        objFrutasBean=null;
            objFrutasBean= new FrutasBean();
            i= objConsultarFrutas.vaciarDatos(objFrutasBean);
            
                        JOptionPane.showMessageDialog(null, "Registro Vaciado");
        }
        
        if (msj==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Registro No Vaciado");
        }
        
        if (msj==JOptionPane.CLOSED_OPTION){
            
        } 
    }
    
      public void Seleccionar(){
        objVentanaFrutas.txtCodigo.setText((String) objVentanaFrutas.TablaFrutas.getValueAt(objVentanaFrutas.TablaFrutas.getSelectedRow(),0));
            objVentanaFrutas.txtCategoria.setText(objVentanaFrutas.TablaFrutas.getValueAt(objVentanaFrutas.TablaFrutas.getSelectedRow(),1).toString());
            objVentanaFrutas.txtSubcategoria.setText(objVentanaFrutas.TablaFrutas.getValueAt(objVentanaFrutas.TablaFrutas.getSelectedRow(),2).toString());
            objVentanaFrutas.txtDescripcion.setText(objVentanaFrutas.TablaFrutas.getValueAt(objVentanaFrutas.TablaFrutas.getSelectedRow(),4).toString());
            objVentanaFrutas.txtCantidad.setText(objVentanaFrutas.TablaFrutas.getValueAt(objVentanaFrutas.TablaFrutas.getSelectedRow(),5).toString());
            objVentanaFrutas.txtPrecio.setText(objVentanaFrutas.TablaFrutas.getValueAt(objVentanaFrutas.TablaFrutas.getSelectedRow(),6).toString());
            String z = objVentanaFrutas.TablaFrutas.getValueAt(objVentanaFrutas.TablaFrutas.getSelectedRow(),8).toString();
            String s = objVentanaFrutas.TablaFrutas.getValueAt(objVentanaFrutas.TablaFrutas.getSelectedRow(),2).toString();
            
            ImageIcon producto = new ImageIcon(getClass().getResource("/Productos/FrutasVerduras/"+s+"/"+z));
            ImageIcon icono = new ImageIcon(producto.getImage().getScaledInstance(objVentanaFrutas.Imagen.getWidth(), objVentanaFrutas.Imagen.getHeight(), Image.SCALE_DEFAULT));
            objVentanaFrutas.Imagen.setIcon(icono);
            //lblImagen.setIcon((Icon) TablaAseo.getValueAt(TablaAseo.getSelectedRow(),7));
            
            String y = objVentanaFrutas.TablaFrutas.getValueAt(objVentanaFrutas.TablaFrutas.getSelectedRow(),3).toString();
            ImageIcon marca = new ImageIcon(getClass().getResource("/Marcas/"+y+".png"));
            ImageIcon logo = new ImageIcon(marca.getImage().getScaledInstance(objVentanaFrutas.jLabel1.getWidth(), objVentanaFrutas.jLabel1.getHeight(), Image.SCALE_DEFAULT));
            objVentanaFrutas.jLabel1.setIcon(logo);
    }
      
    public void LimpiarCampos(){
        objVentanaFrutas.txtCodigo.setText("");
        objVentanaFrutas.txtCategoria.setText("");
        objVentanaFrutas.txtSubcategoria.setText("");
        objVentanaFrutas.txtDescripcion.setText("");
        objVentanaFrutas.txtCantidad.setText("");
        objVentanaFrutas.txtPrecio.setText("");
    }
    
    public void ActualizarDatos(){
        int i=0;
        objFrutasBean=null;
        if(objVentanaFrutas.txtCodigo.getText().length()!=0){
            objFrutasBean= new FrutasBean();
            objFrutasBean.setCodigo(Integer.parseInt(objVentanaFrutas.txtCodigo.getText()));
            //objAseoBean.setCategoria(txtCategoria.getText());
            //objAseoBean.setSubcategoria(txtSubcategoria.getText());
            objFrutasBean.setDescripcion(objVentanaFrutas.txtDescripcion.getText());
            objFrutasBean.setCantidad(Integer.parseInt(objVentanaFrutas.txtCantidad.getText()));
            objFrutasBean.setPrecio(Double.parseDouble(objVentanaFrutas.txtPrecio.getText()));
            
            ConsultarFrutas objM=new ConsultarFrutas();
            i=objM.modificarDatos(objFrutasBean);
        
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
        if(objVentanaFrutas.btnOnOff.isSelected()){
            objVentanaFrutas.btnOnOff.setBackground(Color.green);
            objVentanaFrutas.btnOnOff.setText("ON");
            Listar();
            objVentanaFrutas.TablaFrutas.setVisible(true);
        }else{
            objVentanaFrutas.btnOnOff.setBackground(Color.red);
            objVentanaFrutas.btnOnOff.setText("OFF");
            objVentanaFrutas.TablaFrutas.setVisible(false);
        }
    }
}
