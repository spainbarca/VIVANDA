package Modelo;

    import java.sql.*;
    import Util.*;
    import java.util.*;

public class ConsultarBebidas {
    ArrayList<BebidasBean> lista=null;
    BebidasBean objBebidasBean=null;
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    
    public ArrayList<BebidasBean> ConsultarBebidas(){
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("select * from bebidas_y_licores");
            //pt.setString(1, objDistritoBean.getNombdistri());
            rs= pt.executeQuery();
            lista=new ArrayList<BebidasBean>();
            while(rs.next()){
                objBebidasBean=new BebidasBean();
                objBebidasBean.setCodigo(rs.getInt(1));
                objBebidasBean.setCategoria(rs.getString(2));
                objBebidasBean.setSubcategoria(rs.getString(3));
                objBebidasBean.setMarca(rs.getString(4));
                objBebidasBean.setDescripcion(rs.getString(5));
                objBebidasBean.setCantidad(rs.getInt(6));
                objBebidasBean.setPrecio(rs.getDouble(7));
                objBebidasBean.setNombre(rs.getString(8));
                
                lista.add(objBebidasBean);
            }
            pt.close();
            rs.close();
            cn.close();
        }catch(Exception e){
        }
        return lista;
    }
    
    public int guardarDatos(BebidasBean objBebidasBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("insert into bebidas_y_licores values(?,?,?,?,?,?,?,?)");
            pt.setInt(1, objBebidasBean.getCodigo());
            pt.setString(2, objBebidasBean.getCategoria());
            pt.setString(3, objBebidasBean.getSubcategoria());
            pt.setString(4, objBebidasBean.getMarca());
            pt.setString(5, objBebidasBean.getDescripcion());
            pt.setInt(6, objBebidasBean.getCantidad());
            pt.setDouble(7, objBebidasBean.getPrecio());
            pt.setString(8, objBebidasBean.getNombre());
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
    
    public int eliminarDatos(BebidasBean objBebidasBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from bebidas_y_licores where Codigo=?");
            pt.setInt(1, objBebidasBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int modificarDatos(BebidasBean objBebidasBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("update bebidas_y_licores set Descripcion=?, Cantidad=?, Preciounitario=? where Codigo=?");
            
            //pt.setString(1, objAseoBean.getCategoria());
            //pt.setString(2, objAseoBean.getSubcategoria());
            //pt.setString(3, objAseoBean.getMarca());
            pt.setString(1, objBebidasBean.getDescripcion());
            pt.setInt(2, objBebidasBean.getCantidad());
            pt.setDouble(3, objBebidasBean.getPrecio());
           //pt.setLong(7, objAseoBean.getImagen());
            //pt.setString(8, objAseoBean.getRuta());
            pt.setInt(4, objBebidasBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int vaciarDatos(BebidasBean objBebidasBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from bebidas_y_licores");
            
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
}
