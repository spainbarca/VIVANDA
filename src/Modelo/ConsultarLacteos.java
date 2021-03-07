package Modelo;

    import java.sql.*;
    import Util.*;
    import java.util.*;

public class ConsultarLacteos {
    ArrayList<LacteosBean> lista=null;
    LacteosBean objLacteosBean=null;
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    
    public ArrayList<LacteosBean> ConsultarLacteos(){
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("select * from lacteos");
            //pt.setString(1, objDistritoBean.getNombdistri());
            rs= pt.executeQuery();
            lista=new ArrayList<LacteosBean>();
            while(rs.next()){
                objLacteosBean=new LacteosBean();
                objLacteosBean.setCodigo(rs.getInt(1));
                objLacteosBean.setCategoria(rs.getString(2));
                objLacteosBean.setSubcategoria(rs.getString(3));
                objLacteosBean.setMarca(rs.getString(4));
                objLacteosBean.setDescripcion(rs.getString(5));
                objLacteosBean.setCantidad(rs.getInt(6));
                objLacteosBean.setPrecio(rs.getDouble(7));
                objLacteosBean.setNombre(rs.getString(8));
                
                lista.add(objLacteosBean);
            }
            pt.close();
            rs.close();
            cn.close();
        }catch(Exception e){
        }
        return lista;
    }
    
    public int guardarDatos(LacteosBean objLacteosBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("insert into lacteos values(?,?,?,?,?,?,?,?)");
            pt.setInt(1, objLacteosBean.getCodigo());
            pt.setString(2, objLacteosBean.getCategoria());
            pt.setString(3, objLacteosBean.getSubcategoria());
            pt.setString(4, objLacteosBean.getMarca());
            pt.setString(5, objLacteosBean.getDescripcion());
            pt.setInt(6, objLacteosBean.getCantidad());
            pt.setDouble(7, objLacteosBean.getPrecio());
            pt.setString(8, objLacteosBean.getNombre());
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
    
    public int eliminarDatos(LacteosBean objLacteosBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from lacteos where Codigo=?");
            pt.setInt(1, objLacteosBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int modificarDatos(LacteosBean objLacteosBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("update lacteos set Descripcion=?, Cantidad=?, Preciounitario=? where Codigo=?");
            
            //pt.setString(1, objAseoBean.getCategoria());
            //pt.setString(2, objAseoBean.getSubcategoria());
            //pt.setString(3, objAseoBean.getMarca());
            pt.setString(1, objLacteosBean.getDescripcion());
            pt.setInt(2, objLacteosBean.getCantidad());
            pt.setDouble(3, objLacteosBean.getPrecio());
           //pt.setLong(7, objAseoBean.getImagen());
            //pt.setString(8, objAseoBean.getRuta());
            pt.setInt(4, objLacteosBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int vaciarDatos(LacteosBean objLacteosBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from lacteos");
            
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
}
