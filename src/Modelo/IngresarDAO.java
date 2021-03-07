
package Modelo;

import Util.conectar;
import  java.sql.*;

public class IngresarDAO {
    Connection   cn=null;
   PreparedStatement  pt=null;
   ResultSet          rs=null;
   UsuarioBean     objUsuarioBean=null;
   conectar obj=new conectar();
   public boolean ValidarUsuario(String nombre, String contra){
       boolean estado=false; 
           try {
             
             cn=obj.conexion();// estoy conectandome a la BD
             pt=cn.prepareStatement("select *  from  personales where  pers_nombre=?  and  pers_password=? ;");
             pt.setString(1, nombre);
             pt.setString(2, contra);
             rs= pt.executeQuery();
            if(rs.next())
            {
                estado=true;
            }
            pt.close();
            rs.close();
            cn.close();           
         } 
        
         catch (Exception e) 
        {
        }               
      return  estado;  
   }
   public int RegistrarUsuario(UsuarioBean objUsuarioBean){
       this.objUsuarioBean=objUsuarioBean;
       int estadoRegistro=0;
       try {
           cn=obj.conexion();
           pt=cn.prepareStatement("INSERT INTO  personales(pers_nombre,pers_password)VALUES(?,?) ");
           pt.setString(1,objUsuarioBean.getUsuarioo());
           pt.setString(2,objUsuarioBean.getClavee());
           estadoRegistro=pt.executeUpdate();
           pt.close();
           cn.close();
                      
       } catch (Exception e) 
       {
       }
      return  estadoRegistro;
       }
   }
   
