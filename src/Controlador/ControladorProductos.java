
package Controlador;
import Modelo.ProductosDAO;
import Modelo.ProductosBean;
import Vista.VentanaContinuarAlimentos;
import javax.swing.*;
public class ControladorProductos {
    VentanaContinuarAlimentos objVentanaContinuarAlimentos;
    ProductosBean objProductosBean;
    ProductosDAO objProductosDAO;
    public ControladorProductos(VentanaContinuarAlimentos objVentanaContinuarAlimentos){
        this.objVentanaContinuarAlimentos=objVentanaContinuarAlimentos;
        objProductosBean=new ProductosBean();
        objProductosDAO=new ProductosDAO(objVentanaContinuarAlimentos);
    }
    public void GrabarProductos(ProductosBean objProductosBean){
        int estado=0;
        estado=objProductosDAO.Agregar(objProductosBean);
        if(estado==1){
            JOptionPane.showMessageDialog(null, "REGISTRADO CON EXITO");
        } else {
            JOptionPane.showMessageDialog(null,"NO ESTA REGISTRADO");
        }
    }
    public boolean ValidarCampos(){
    boolean estadoCampo;    
        boolean num=objVentanaContinuarAlimentos.objeto.Validando(objVentanaContinuarAlimentos.txtCodigo.getText());
        boolean num1=objVentanaContinuarAlimentos.objeto.Validando(objVentanaContinuarAlimentos.txtCantidad.getText());
        boolean num2=objVentanaContinuarAlimentos.objeto2.Validando(objVentanaContinuarAlimentos.txtPrecio.getText());
        if (objVentanaContinuarAlimentos.txtCodigo.getText().length()==0  || objVentanaContinuarAlimentos.txtCantidad.getText().length()==0 || objVentanaContinuarAlimentos.txtImagen.getText().length()==0
          || objVentanaContinuarAlimentos.txtPrecio.getText().length()==0 || objVentanaContinuarAlimentos.txtDescripcion.getText().length()==0 || objVentanaContinuarAlimentos.ComboBoxCategoria.getSelectedItem().equals("Seleccionar...")
                || objVentanaContinuarAlimentos.ComboBoxSubcategoria.getSelectedItem().equals("Seleccionar...") || objVentanaContinuarAlimentos.ComboBoxMarca.getSelectedItem().equals("Seleccionar...")){
            JOptionPane.showMessageDialog(null,"Complete los campos vacíos");
            estadoCampo=false;
        } else {
            if (num!=true /*|| num1!=true || num2!=true*/){
                JOptionPane.showMessageDialog(null,"Ingrese solo numeros Enteros en el CODIGO");
                estadoCampo=false;
            }else {
                if (num1!=true){
                    JOptionPane.showMessageDialog(null,"Ingrese solo numeros Enteros en la CANTIDAD");
                    estadoCampo=false;
                } else{
                    if(num2!=true){
                        JOptionPane.showMessageDialog(null,"Ingrese solo numeros en el PRECIO");
                        estadoCampo=false;
                    }
                    else {
                        estadoCampo=true;
                    }
    }
    
}
        }
        return estadoCampo;
    }
}

   
