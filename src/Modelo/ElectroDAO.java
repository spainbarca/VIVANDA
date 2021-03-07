package Modelo;

import java.awt.Image;
import java.util.*;
import javax.swing.*;
import Vista.VentanaElectro;
import java.awt.Color;

public class ElectroDAO {
    VentanaElectro objVentanaElectro;
    ConsultarElectro objConsultarElectro;
    ElectroBean objElectroBean;
    ArrayList<ElectroBean> lista;
    
    public ElectroDAO(VentanaElectro objVentanaElectro){
        this.objVentanaElectro=objVentanaElectro;
        this.objConsultarElectro = new ConsultarElectro();
        
        //this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/vivandalogo.png")).getImage());
    }
    
    public void Listar(){
            lista=objConsultarElectro.ConsultarElectro();
            objVentanaElectro.modelo.setNumRows(lista.size());
            int i=0;
            for(ElectroBean objAs:lista){
                objVentanaElectro.modelo.setValueAt(""+objAs.getCodigo(),i,0);
                objVentanaElectro.modelo.setValueAt(""+objAs.getCategoria(),i,1);
                objVentanaElectro.modelo.setValueAt(objAs.getSubcategoria(),i,2);
                objVentanaElectro.modelo.setValueAt(""+objAs.getMarca(),i,3);
                objVentanaElectro.modelo.setValueAt(objAs.getDescripcion(),i,4);
                objVentanaElectro.modelo.setValueAt(""+objAs.getCantidad(),i,5);
                objVentanaElectro.modelo.setValueAt(objAs.getPrecio(),i,6);
                objVentanaElectro.modelo.setValueAt(objAs.getCantidad()*objAs.getPrecio(),i,7);
                objVentanaElectro.modelo.setValueAt(""+objAs.getNombre(),i,8);
                    i++;
            }
            objVentanaElectro.TablaElectro.setModel(objVentanaElectro.modelo);
    }
    
    public void BorrarDato(){
        int i=0;
        objElectroBean=null;
        if(objVentanaElectro.txtCodigo.getText().length()!=0){
            objElectroBean= new ElectroBean();
            objElectroBean.setCodigo(Integer.parseInt(objVentanaElectro.txtCodigo.getText()));
            i= objConsultarElectro.eliminarDatos(objElectroBean);
            
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
        objElectroBean=null;
            objElectroBean= new ElectroBean();
            i= objConsultarElectro.vaciarDatos(objElectroBean);
            
                        JOptionPane.showMessageDialog(null, "Registro Vaciado");
        }
        
        if (msj==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Registro No Vaciado");
        }
        
        if (msj==JOptionPane.CLOSED_OPTION){
            
        } 
    }
    
      public void Seleccionar(){
        objVentanaElectro.txtCodigo.setText((String) objVentanaElectro.TablaElectro.getValueAt(objVentanaElectro.TablaElectro.getSelectedRow(),0));
            objVentanaElectro.txtCategoria.setText(objVentanaElectro.TablaElectro.getValueAt(objVentanaElectro.TablaElectro.getSelectedRow(),1).toString());
            objVentanaElectro.txtSubcategoria.setText(objVentanaElectro.TablaElectro.getValueAt(objVentanaElectro.TablaElectro.getSelectedRow(),2).toString());
            objVentanaElectro.txtDescripcion.setText(objVentanaElectro.TablaElectro.getValueAt(objVentanaElectro.TablaElectro.getSelectedRow(),4).toString());
            objVentanaElectro.txtCantidad.setText(objVentanaElectro.TablaElectro.getValueAt(objVentanaElectro.TablaElectro.getSelectedRow(),5).toString());
            objVentanaElectro.txtPrecio.setText(objVentanaElectro.TablaElectro.getValueAt(objVentanaElectro.TablaElectro.getSelectedRow(),6).toString());
            String z = objVentanaElectro.TablaElectro.getValueAt(objVentanaElectro.TablaElectro.getSelectedRow(),8).toString();
            String s = objVentanaElectro.TablaElectro.getValueAt(objVentanaElectro.TablaElectro.getSelectedRow(),2).toString();
            
            ImageIcon producto = new ImageIcon(getClass().getResource("/Productos/ElectroHogar/"+s+"/"+z));
            ImageIcon icono = new ImageIcon(producto.getImage().getScaledInstance(objVentanaElectro.Imagen.getWidth(), objVentanaElectro.Imagen.getHeight(), Image.SCALE_DEFAULT));
            objVentanaElectro.Imagen.setIcon(icono);
            //lblImagen.setIcon((Icon) TablaAseo.getValueAt(TablaAseo.getSelectedRow(),7));
            
            String y = objVentanaElectro.TablaElectro.getValueAt(objVentanaElectro.TablaElectro.getSelectedRow(),3).toString();
            ImageIcon marca = new ImageIcon(getClass().getResource("/Marcas/"+y+".png"));
            ImageIcon logo = new ImageIcon(marca.getImage().getScaledInstance(objVentanaElectro.jLabel1.getWidth(), objVentanaElectro.jLabel1.getHeight(), Image.SCALE_DEFAULT));
            objVentanaElectro.jLabel1.setIcon(logo);
    }
      
    public void LimpiarCampos(){
        objVentanaElectro.txtCodigo.setText("");
        objVentanaElectro.txtCategoria.setText("");
        objVentanaElectro.txtSubcategoria.setText("");
        objVentanaElectro.txtDescripcion.setText("");
        objVentanaElectro.txtCantidad.setText("");
        objVentanaElectro.txtPrecio.setText("");
    }
    
    public void ActualizarDatos(){
        int i=0;
        objElectroBean=null;
        if(objVentanaElectro.txtCodigo.getText().length()!=0){
            objElectroBean= new ElectroBean();
            objElectroBean.setCodigo(Integer.parseInt(objVentanaElectro.txtCodigo.getText()));
            //objAseoBean.setCategoria(txtCategoria.getText());
            //objAseoBean.setSubcategoria(txtSubcategoria.getText());
            objElectroBean.setDescripcion(objVentanaElectro.txtDescripcion.getText());
            objElectroBean.setCantidad(Integer.parseInt(objVentanaElectro.txtCantidad.getText()));
            objElectroBean.setPrecio(Double.parseDouble(objVentanaElectro.txtPrecio.getText()));
            
            ConsultarElectro objM=new ConsultarElectro();
            i=objM.modificarDatos(objElectroBean);
        
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
        if(objVentanaElectro.btnOnOff.isSelected()){
            objVentanaElectro.btnOnOff.setBackground(Color.green);
            objVentanaElectro.btnOnOff.setText("ON");
            Listar();
            objVentanaElectro.TablaElectro.setVisible(true);
        }else{
            objVentanaElectro.btnOnOff.setBackground(Color.red);
            objVentanaElectro.btnOnOff.setText("OFF");
            objVentanaElectro.TablaElectro.setVisible(false);
        }
    }
}
