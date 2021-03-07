package Modelo;

    import java.sql.*;
    import Util.*;
    import java.util.*;

public class ConsultarAseo {
    ArrayList<AseoBean> lista=null;
    AseoBean objAseoBean=null;
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    
    public ArrayList<AseoBean> ConsultarAseo(){
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("select * from aseo_personal");
            //pt.setString(1, objDistritoBean.getNombdistri());
            rs= pt.executeQuery();
            lista=new ArrayList<AseoBean>();
            while(rs.next()){
                objAseoBean=new AseoBean();
                objAseoBean.setCodigo(rs.getInt(1));
                objAseoBean.setCategoria(rs.getString(2));
                objAseoBean.setSubcategoria(rs.getString(3));
                objAseoBean.setMarca(rs.getString(4));
                objAseoBean.setDescripcion(rs.getString(5));
                objAseoBean.setCantidad(rs.getInt(6));
                objAseoBean.setPrecio(rs.getDouble(7));
                objAseoBean.setNombre(rs.getString(8));
                
                lista.add(objAseoBean);
            }
            pt.close();
            rs.close();
            cn.close();
        }catch(Exception e){
        }
        return lista;
    }
    
    public int guardarDatos(AseoBean objAseoBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("insert into aseo_personal values(?,?,?,?,?,?,?,?)");
            pt.setInt(1, objAseoBean.getCodigo());
            pt.setString(2, objAseoBean.getCategoria());
            pt.setString(3, objAseoBean.getSubcategoria());
            pt.setString(4, objAseoBean.getMarca());
            pt.setString(5, objAseoBean.getDescripcion());
            pt.setInt(6, objAseoBean.getCantidad());
            pt.setDouble(7, objAseoBean.getPrecio());
            pt.setString(8, objAseoBean.getNombre());
            //archivoFoto=new FileInputStream()
           // pt.setBlob(8, objAseoBean.getImagen());
            //pt.setString(9, objAseoBean.getRuta());
            
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int eliminarDatos(AseoBean objAseoBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from aseo_personal where Codigo=?");
            pt.setInt(1, objAseoBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int modificarDatos(AseoBean objAseoBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("update aseo_personal set Descripcion=?, Cantidad=?, Preciounitario=? where Codigo=?");
            
            //pt.setString(1, objAseoBean.getCategoria());
            //pt.setString(2, objAseoBean.getSubcategoria());
            //pt.setString(3, objAseoBean.getMarca());
            pt.setString(1, objAseoBean.getDescripcion());
            pt.setInt(2, objAseoBean.getCantidad());
            pt.setDouble(3, objAseoBean.getPrecio());
           //pt.setLong(7, objAseoBean.getImagen());
            //pt.setString(8, objAseoBean.getRuta());
            pt.setInt(4, objAseoBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int vaciarDatos(AseoBean objAseoBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from aseo_personal");
            
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
}
