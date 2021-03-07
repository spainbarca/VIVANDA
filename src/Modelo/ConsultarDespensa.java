package Modelo;

    import java.sql.*;
    import Util.*;
    import java.util.*;

public class ConsultarDespensa {
    ArrayList<DespensaBean> lista=null;
    DespensaBean objDespensaBean=null;
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    
    public ArrayList<DespensaBean> ConsultarDespensa(){
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("select * from despensa");
            //pt.setString(1, objDistritoBean.getNombdistri());
            rs= pt.executeQuery();
            lista=new ArrayList<DespensaBean>();
            while(rs.next()){
                objDespensaBean=new DespensaBean();
                objDespensaBean.setCodigo(rs.getInt(1));
                objDespensaBean.setCategoria(rs.getString(2));
                objDespensaBean.setSubcategoria(rs.getString(3));
                objDespensaBean.setMarca(rs.getString(4));
                objDespensaBean.setDescripcion(rs.getString(5));
                objDespensaBean.setCantidad(rs.getInt(6));
                objDespensaBean.setPrecio(rs.getDouble(7));
                objDespensaBean.setNombre(rs.getString(8));
                
                lista.add(objDespensaBean);
            }
            pt.close();
            rs.close();
            cn.close();
        }catch(Exception e){
        }
        return lista;
    }
    
    public int guardarDatos(DespensaBean objDespensaBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("insert into despensa values(?,?,?,?,?,?,?,?)");
            pt.setInt(1, objDespensaBean.getCodigo());
            pt.setString(2, objDespensaBean.getCategoria());
            pt.setString(3, objDespensaBean.getSubcategoria());
            pt.setString(4, objDespensaBean.getMarca());
            pt.setString(5, objDespensaBean.getDescripcion());
            pt.setInt(6, objDespensaBean.getCantidad());
            pt.setDouble(7, objDespensaBean.getPrecio());
            pt.setString(8, objDespensaBean.getNombre());
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
    
    public int eliminarDatos(DespensaBean objDespensaBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from despensa where Codigo=?");
            pt.setInt(1, objDespensaBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int modificarDatos(DespensaBean objDespensaBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("update despensa set Descripcion=?, Cantidad=?, Preciounitario=? where Codigo=?");
            
            //pt.setString(1, objAseoBean.getCategoria());
            //pt.setString(2, objAseoBean.getSubcategoria());
            //pt.setString(3, objAseoBean.getMarca());
            pt.setString(1, objDespensaBean.getDescripcion());
            pt.setInt(2, objDespensaBean.getCantidad());
            pt.setDouble(3, objDespensaBean.getPrecio());
           //pt.setLong(7, objAseoBean.getImagen());
            //pt.setString(8, objAseoBean.getRuta());
            pt.setInt(4, objDespensaBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int vaciarDatos(DespensaBean objDespensaBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from despensa");
            
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
}
