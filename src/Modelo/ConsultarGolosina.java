
package Modelo;

import java.sql.*;
import Util.*;
import java.util.*;

public class ConsultarGolosina {
    ArrayList<GolosinaBean> lista=null;
    GolosinaBean objGolosinaBean=null;
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    
    public ArrayList<GolosinaBean> ConsultarGolosina(){
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("select * from golosinas");
            //pt.setString(1, objDistritoBean.getNombdistri());
            rs= pt.executeQuery();
            lista=new ArrayList<GolosinaBean>();
            while(rs.next()){
                objGolosinaBean=new GolosinaBean();
                objGolosinaBean.setCodigo(rs.getInt(1));
                objGolosinaBean.setCategoria(rs.getString(2));
                objGolosinaBean.setSubcategoria(rs.getString(3));
                objGolosinaBean.setMarca(rs.getString(4));
                objGolosinaBean.setDescripcion(rs.getString(5));
                objGolosinaBean.setCantidad(rs.getInt(6));
                objGolosinaBean.setPrecio(rs.getDouble(7));
                objGolosinaBean.setNombre(rs.getString(8));
                
                lista.add(objGolosinaBean);
            }
            pt.close();
            rs.close();
            cn.close();
        }catch(Exception e){
        }
        return lista;
    }
    
    public int guardarDatos(GolosinaBean objGolosinaBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("insert into golosinas values(?,?,?,?,?,?,?,?)");
            pt.setInt(1, objGolosinaBean.getCodigo());
            pt.setString(2, objGolosinaBean.getCategoria());
            pt.setString(3, objGolosinaBean.getSubcategoria());
            pt.setString(4, objGolosinaBean.getMarca());
            pt.setString(5, objGolosinaBean.getDescripcion());
            pt.setInt(6, objGolosinaBean.getCantidad());
            pt.setDouble(7, objGolosinaBean.getPrecio());
            pt.setString(8, objGolosinaBean.getNombre());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int eliminarDatos(GolosinaBean objGolosinaBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from golosinas where Codigo=?");
            pt.setInt(1, objGolosinaBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int modificarDatos(GolosinaBean objGolosinaBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("update golosinas set Descripcion=?, Cantidad=?, Preciounitario=? where Codigo=?");
            pt.setString(1, objGolosinaBean.getDescripcion());
            pt.setInt(2, objGolosinaBean.getCantidad());
            pt.setDouble(3, objGolosinaBean.getPrecio());
            pt.setInt(4, objGolosinaBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int vaciarDatos(GolosinaBean objGolosinaBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from golosinas");
            
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
}
