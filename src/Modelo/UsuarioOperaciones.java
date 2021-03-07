package Modelo;
   import java.sql.*;
import Util.conectar;
public class UsuarioOperaciones
{    Connection                con=null;
     PreparedStatement   pt=null;
     ResultSet                   rs=null;
   public boolean  ValidarUsuario(String nombre,String contra)
    { 
        boolean   estado=false;
         try
         {
             conectar objc=new conectar();
             con=objc.conexion();// estoy conectandome a la BD
             pt=con.prepareStatement("select *  from personales where  pers_nombre=?  and  pers_password=? ;");
             pt.setString(1, nombre);
             pt.setString(2, contra);
             rs= pt.executeQuery();
            if(rs.next())
            {
                estado=true;
            }
            pt.close();
            rs.close();
            con.close();           
         } 
         catch (Exception e) 
        {
        }               
      return  estado;    
    } 
}

