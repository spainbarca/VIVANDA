
package Modelo;

import java.sql.*;
import Util.*;
import java.util.*;

public class ConsultarPan {
    ArrayList<PanBean> lista=null;
    PanBean objPanBean=null;
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    
    public ArrayList<PanBean> ConsultarPan(){
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("select * from panaderia_y_pasteleria");
            //pt.setString(1, objDistritoBean.getNombdistri());
            rs= pt.executeQuery();
            lista=new ArrayList<PanBean>();
            while(rs.next()){
                objPanBean=new PanBean();
                objPanBean.setCodigo(rs.getInt(1));
                objPanBean.setCategoria(rs.getString(2));
                objPanBean.setSubcategoria(rs.getString(3));
                objPanBean.setMarca(rs.getString(4));
                objPanBean.setDescripcion(rs.getString(5));
                objPanBean.setCantidad(rs.getInt(6));
                objPanBean.setPrecio(rs.getDouble(7));
                objPanBean.setNombre(rs.getString(8));
                
                lista.add(objPanBean);
            }
            pt.close();
            rs.close();
            cn.close();
        }catch(Exception e){
        }
        return lista;
    }
    
    public int guardarDatos(PanBean objPanBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("insert into panaderia_y_pasteleria values(?,?,?,?,?,?,?,?)");
            pt.setInt(1, objPanBean.getCodigo());
            pt.setString(2, objPanBean.getCategoria());
            pt.setString(3, objPanBean.getSubcategoria());
            pt.setString(4, objPanBean.getMarca());
            pt.setString(5, objPanBean.getDescripcion());
            pt.setInt(6, objPanBean.getCantidad());
            pt.setDouble(7, objPanBean.getPrecio());
            pt.setString(8, objPanBean.getNombre());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int eliminarDatos(PanBean objPanBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from panaderia_y_pasteleria where Codigo=?");
            pt.setInt(1, objPanBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int modificarDatos(PanBean objPanBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("update panaderia_y_pasteleria set Descripcion=?, Cantidad=?, Preciounitario=? where Codigo=?");
            pt.setString(1, objPanBean.getDescripcion());
            pt.setInt(2, objPanBean.getCantidad());
            pt.setDouble(3, objPanBean.getPrecio());
            pt.setInt(4, objPanBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int vaciarDatos(PanBean objPanBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from panaderia_y_pasteleria");
            
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
}
