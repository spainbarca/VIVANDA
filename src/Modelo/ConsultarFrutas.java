package Modelo;

    import java.sql.*;
    import Util.*;
    import java.util.*;

public class ConsultarFrutas {
    ArrayList<FrutasBean> lista=null;
    FrutasBean objFrutasBean=null;
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    
    public ArrayList<FrutasBean> ConsultarFrutas(){
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("select * from frutas_y_verduras");
            //pt.setString(1, objDistritoBean.getNombdistri());
            rs= pt.executeQuery();
            lista=new ArrayList<FrutasBean>();
            while(rs.next()){
                objFrutasBean=new FrutasBean();
                objFrutasBean.setCodigo(rs.getInt(1));
                objFrutasBean.setCategoria(rs.getString(2));
                objFrutasBean.setSubcategoria(rs.getString(3));
                objFrutasBean.setMarca(rs.getString(4));
                objFrutasBean.setDescripcion(rs.getString(5));
                objFrutasBean.setCantidad(rs.getInt(6));
                objFrutasBean.setPrecio(rs.getDouble(7));
                objFrutasBean.setNombre(rs.getString(8));
                
                lista.add(objFrutasBean);
            }
            pt.close();
            rs.close();
            cn.close();
        }catch(Exception e){
        }
        return lista;
    }
    
    public int guardarDatos(FrutasBean objFrutasBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("insert into frutas_y_verduras values(?,?,?,?,?,?,?,?)");
            pt.setInt(1, objFrutasBean.getCodigo());
            pt.setString(2, objFrutasBean.getCategoria());
            pt.setString(3, objFrutasBean.getSubcategoria());
            pt.setString(4, objFrutasBean.getMarca());
            pt.setString(5, objFrutasBean.getDescripcion());
            pt.setInt(6, objFrutasBean.getCantidad());
            pt.setDouble(7, objFrutasBean.getPrecio());
            pt.setString(8, objFrutasBean.getNombre());
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
    
    public int eliminarDatos(FrutasBean objFrutasBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from frutas_y_verduras where Codigo=?");
            pt.setInt(1, objFrutasBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int modificarDatos(FrutasBean objFrutasBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("update frutas_y_verduras set Descripcion=?, Cantidad=?, Preciounitario=? where Codigo=?");
            
            //pt.setString(1, objAseoBean.getCategoria());
            //pt.setString(2, objAseoBean.getSubcategoria());
            //pt.setString(3, objAseoBean.getMarca());
            pt.setString(1, objFrutasBean.getDescripcion());
            pt.setInt(2, objFrutasBean.getCantidad());
            pt.setDouble(3, objFrutasBean.getPrecio());
           //pt.setLong(7, objAseoBean.getImagen());
            //pt.setString(8, objAseoBean.getRuta());
            pt.setInt(4, objFrutasBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int vaciarDatos(FrutasBean objFrutasBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from frutas_y_verduras");
            
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
}
