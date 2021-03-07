package Modelo;

import java.awt.Image;
import java.util.*;
import javax.swing.*;
import Vista.VentanaCarnes;
import java.awt.Color;

public class CarnesDAO {
    VentanaCarnes objVentanaCarnes;
    ConsultarCarnes objConsultarCarnes;
    CarnesBean objCarnesBean;
    ArrayList<CarnesBean> lista;
    
    public CarnesDAO(VentanaCarnes objVentanaCarnes){
        this.objVentanaCarnes=objVentanaCarnes;
        this.objConsultarCarnes = new ConsultarCarnes();
        
        //this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/vivandalogo.png")).getImage());
    }
    
    public void Listar(){
            lista=objConsultarCarnes.ConsultarCarnes();
            objVentanaCarnes.modelo.setNumRows(lista.size());
            int i=0;
            for(CarnesBean objAs:lista){
                objVentanaCarnes.modelo.setValueAt(""+objAs.getCodigo(),i,0);
                objVentanaCarnes.modelo.setValueAt(""+objAs.getCategoria(),i,1);
                objVentanaCarnes.modelo.setValueAt(objAs.getSubcategoria(),i,2);
                objVentanaCarnes.modelo.setValueAt(""+objAs.getMarca(),i,3);
                objVentanaCarnes.modelo.setValueAt(objAs.getDescripcion(),i,4);
                objVentanaCarnes.modelo.setValueAt(""+objAs.getCantidad(),i,5);
                objVentanaCarnes.modelo.setValueAt(objAs.getPrecio(),i,6);
                objVentanaCarnes.modelo.setValueAt(objAs.getCantidad()*objAs.getPrecio(),i,7);
                objVentanaCarnes.modelo.setValueAt(""+objAs.getNombre(),i,8);
                    i++;
            }
            objVentanaCarnes.TablaCarnes.setModel(objVentanaCarnes.modelo);
    }
    
    public void BorrarDato(){
        int i=0;
        objCarnesBean=null;
        if(objVentanaCarnes.txtCodigo.getText().length()!=0){
            objCarnesBean= new CarnesBean();
            objCarnesBean.setCodigo(Integer.parseInt(objVentanaCarnes.txtCodigo.getText()));
            i= objConsultarCarnes.eliminarDatos(objCarnesBean);
            
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
        objCarnesBean=null;
            objCarnesBean= new CarnesBean();
            i= objConsultarCarnes.vaciarDatos(objCarnesBean);
            
                        JOptionPane.showMessageDialog(null, "Registro Vaciado");
        }
        
        if (msj==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Registro No Vaciado");
        }
        
        if (msj==JOptionPane.CLOSED_OPTION){
            
        } 
    }
    
      public void Seleccionar(){
        objVentanaCarnes.txtCodigo.setText((String) objVentanaCarnes.TablaCarnes.getValueAt(objVentanaCarnes.TablaCarnes.getSelectedRow(),0));
            objVentanaCarnes.txtCategoria.setText(objVentanaCarnes.TablaCarnes.getValueAt(objVentanaCarnes.TablaCarnes.getSelectedRow(),1).toString());
            objVentanaCarnes.txtSubcategoria.setText(objVentanaCarnes.TablaCarnes.getValueAt(objVentanaCarnes.TablaCarnes.getSelectedRow(),2).toString());
            objVentanaCarnes.txtDescripcion.setText(objVentanaCarnes.TablaCarnes.getValueAt(objVentanaCarnes.TablaCarnes.getSelectedRow(),4).toString());
            objVentanaCarnes.txtCantidad.setText(objVentanaCarnes.TablaCarnes.getValueAt(objVentanaCarnes.TablaCarnes.getSelectedRow(),5).toString());
            objVentanaCarnes.txtPrecio.setText(objVentanaCarnes.TablaCarnes.getValueAt(objVentanaCarnes.TablaCarnes.getSelectedRow(),6).toString());
            String z = objVentanaCarnes.TablaCarnes.getValueAt(objVentanaCarnes.TablaCarnes.getSelectedRow(),8).toString();
            String s = objVentanaCarnes.TablaCarnes.getValueAt(objVentanaCarnes.TablaCarnes.getSelectedRow(),2).toString();
            
            ImageIcon producto = new ImageIcon(getClass().getResource("/Productos/CarnesPescados/"+s+"/"+z));
            ImageIcon icono = new ImageIcon(producto.getImage().getScaledInstance(objVentanaCarnes.Imagen.getWidth(), objVentanaCarnes.Imagen.getHeight(), Image.SCALE_DEFAULT));
            objVentanaCarnes.Imagen.setIcon(icono);
            //lblImagen.setIcon((Icon) TablaAseo.getValueAt(TablaAseo.getSelectedRow(),7));
            
            String y = objVentanaCarnes.TablaCarnes.getValueAt(objVentanaCarnes.TablaCarnes.getSelectedRow(),3).toString();
            ImageIcon marca = new ImageIcon(getClass().getResource("/Marcas/"+y+".png"));
            ImageIcon logo = new ImageIcon(marca.getImage().getScaledInstance(objVentanaCarnes.jLabel1.getWidth(), objVentanaCarnes.jLabel1.getHeight(), Image.SCALE_DEFAULT));
            objVentanaCarnes.jLabel1.setIcon(logo);
    }
      
    public void LimpiarCampos(){
        objVentanaCarnes.txtCodigo.setText("");
        objVentanaCarnes.txtCategoria.setText("");
        objVentanaCarnes.txtSubcategoria.setText("");
        objVentanaCarnes.txtDescripcion.setText("");
        objVentanaCarnes.txtCantidad.setText("");
        objVentanaCarnes.txtPrecio.setText("");
    }
    
    public void ActualizarDatos(){
        int i=0;
        objCarnesBean=null;
        if(objVentanaCarnes.txtCodigo.getText().length()!=0){
            objCarnesBean= new CarnesBean();
            objCarnesBean.setCodigo(Integer.parseInt(objVentanaCarnes.txtCodigo.getText()));
            //objAseoBean.setCategoria(txtCategoria.getText());
            //objAseoBean.setSubcategoria(txtSubcategoria.getText());
            objCarnesBean.setDescripcion(objVentanaCarnes.txtDescripcion.getText());
            objCarnesBean.setCantidad(Integer.parseInt(objVentanaCarnes.txtCantidad.getText()));
            objCarnesBean.setPrecio(Double.parseDouble(objVentanaCarnes.txtPrecio.getText()));
            
            ConsultarCarnes objM=new ConsultarCarnes();
            i=objM.modificarDatos(objCarnesBean);
        
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
        if(objVentanaCarnes.btnOnOff.isSelected()){
            objVentanaCarnes.btnOnOff.setBackground(Color.green);
            objVentanaCarnes.btnOnOff.setText("ON");
            Listar();
            objVentanaCarnes.TablaCarnes.setVisible(true);
        }else{
            objVentanaCarnes.btnOnOff.setBackground(Color.red);
            objVentanaCarnes.btnOnOff.setText("OFF");
            objVentanaCarnes.TablaCarnes.setVisible(false);
        }
    }
}
