
package Controlador;
import Modelo.IngresarDAO;
import Modelo.UsuarioBean;
import Vista.Interfaz;
import javax.swing.*;
public class ControladorIngresar {
   Interfaz objInterfaz;
    IngresarDAO objUsuarioDAO;
    UsuarioBean objUsuarioBean;
    public ControladorIngresar(Interfaz objInterfaz){
      this.objInterfaz=objInterfaz;
      objUsuarioBean= new UsuarioBean();
        objUsuarioDAO=new IngresarDAO();
    }
    public boolean ValidarUsuarioControlador(UsuarioBean objUsuarioBean){
        boolean estado =false;
        
     try {
        
            estado=objUsuarioDAO.ValidarUsuario(objUsuarioBean.getUsuarioo(),objUsuarioBean.getClavee());
        }
        catch (Exception e){
            
        }
        return estado;
    
    }
    public boolean ValidarCampos(){
        boolean estadoCampo;
        String nombre=objInterfaz.usuario.getText();
        String contra=objInterfaz.contraseña.getText();
        
        if (nombre.length()==0 && contra.length()==0){
            JOptionPane.showMessageDialog(null,"Complete todos los campos");
            objInterfaz.usuario.requestFocus();// colocar el foco o cursor en el campo usuario
            estadoCampo = false;
    }else if(nombre.length()!=0 && contra.length()==0)
    {  JOptionPane.showMessageDialog(null,"Ingrese la contraseña !!");
       objInterfaz.contraseña.requestFocus();
       estadoCampo = false;
    }else if(nombre.length()==0 && contra.length()!=0)
    {  JOptionPane.showMessageDialog(null,"Ingrese el Usuario !!");
       objInterfaz.usuario.requestFocus(); 
       estadoCampo = false;
    }else
    {
        estadoCampo=true;
    }
      return estadoCampo;  
}
    public void GrabarUsuario(UsuarioBean objUsuarioBean){
        int estado=0;
        estado=objUsuarioDAO.RegistrarUsuario(objUsuarioBean);
        if(estado==1){
            JOptionPane.showMessageDialog(null,"Registro Insertado con Éxito");
            objInterfaz.usuario.setText("");
           objInterfaz.contraseña.setText("");
        } else {
            JOptionPane.showMessageDialog(null,"Registro no Insertado");
           
        }

    }
}