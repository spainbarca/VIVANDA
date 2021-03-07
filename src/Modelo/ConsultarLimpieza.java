
package Modelo;

import java.sql.*;
import Util.*;
import java.util.*;

public class ConsultarLimpieza {
    ArrayList<LimpiezaBean> lista=null;
    LimpiezaBean objLimpiezaBean=null;
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    
    public ArrayList<LimpiezaBean> ConsultarLimpieza(){
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("select * from limpieza_domestica");
            //pt.setString(1, objDistritoBean.getNombdistri());
            rs= pt.executeQuery();
            lista=new ArrayList<LimpiezaBean>();
            while(rs.next()){
                objLimpiezaBean=new LimpiezaBean();
                objLimpiezaBean.setCodigo(rs.getInt(1));
                objLimpiezaBean.setCategoria(rs.getString(2));
                objLimpiezaBean.setSubcategoria(rs.getString(3));
                objLimpiezaBean.setMarca(rs.getString(4));
                objLimpiezaBean.setDescripcion(rs.getString(5));
                objLimpiezaBean.setCantidad(rs.getInt(6));
                objLimpiezaBean.setPrecio(rs.getDouble(7));
                objLimpiezaBean.setNombre(rs.getString(8));
                
                lista.add(objLimpiezaBean);
            }
            pt.close();
            rs.close();
            cn.close();
        }catch(Exception e){
        }
        return lista;
    }
    
    public int guardarDatos(LimpiezaBean objLimpiezaBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("insert into limpieza_domestica values(?,?,?,?,?,?,?,?)");
            pt.setInt(1, objLimpiezaBean.getCodigo());
            pt.setString(2, objLimpiezaBean.getCategoria());
            pt.setString(3, objLimpiezaBean.getSubcategoria());
            pt.setString(4, objLimpiezaBean.getMarca());
            pt.setString(5, objLimpiezaBean.getDescripcion());
            pt.setInt(6, objLimpiezaBean.getCantidad());
            pt.setDouble(7, objLimpiezaBean.getPrecio());
            pt.setString(8, objLimpiezaBean.getNombre());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int eliminarDatos(LimpiezaBean objLimpiezaBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from limpieza_domestica where Codigo=?");
            pt.setInt(1, objLimpiezaBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int modificarDatos(LimpiezaBean objLimpiezaBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("update limpieza_domestica set Descripcion=?, Cantidad=?, Preciounitario=? where Codigo=?");
            pt.setString(1, objLimpiezaBean.getDescripcion());
            pt.setInt(2, objLimpiezaBean.getCantidad());
            pt.setDouble(3, objLimpiezaBean.getPrecio());
            pt.setInt(4, objLimpiezaBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int vaciarDatos(LimpiezaBean objLimpiezaBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from limpieza_domestica");
            
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
}
