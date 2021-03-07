package Modelo;

    import java.sql.*;
    import Util.*;
    import java.util.*;

public class ConsultarElectro {
    ArrayList<ElectroBean> lista=null;
    ElectroBean objElectroBean=null;
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    
    public ArrayList<ElectroBean> ConsultarElectro(){
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("select * from electrohogar");
            //pt.setString(1, objDistritoBean.getNombdistri());
            rs= pt.executeQuery();
            lista=new ArrayList<ElectroBean>();
            while(rs.next()){
                objElectroBean=new ElectroBean();
                objElectroBean.setCodigo(rs.getInt(1));
                objElectroBean.setCategoria(rs.getString(2));
                objElectroBean.setSubcategoria(rs.getString(3));
                objElectroBean.setMarca(rs.getString(4));
                objElectroBean.setDescripcion(rs.getString(5));
                objElectroBean.setCantidad(rs.getInt(6));
                objElectroBean.setPrecio(rs.getDouble(7));
                objElectroBean.setNombre(rs.getString(8));
                
                lista.add(objElectroBean);
            }
            pt.close();
            rs.close();
            cn.close();
        }catch(Exception e){
        }
        return lista;
    }
    
    public int guardarDatos(ElectroBean objElectroBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("insert into electrohogar values(?,?,?,?,?,?,?,?)");
            pt.setInt(1, objElectroBean.getCodigo());
            pt.setString(2, objElectroBean.getCategoria());
            pt.setString(3, objElectroBean.getSubcategoria());
            pt.setString(4, objElectroBean.getMarca());
            pt.setString(5, objElectroBean.getDescripcion());
            pt.setInt(6, objElectroBean.getCantidad());
            pt.setDouble(7, objElectroBean.getPrecio());
            pt.setString(8, objElectroBean.getNombre());
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
    
    public int eliminarDatos(ElectroBean objElectroBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from electrohogar where Codigo=?");
            pt.setInt(1, objElectroBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int modificarDatos(ElectroBean objElectroBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("update electrohogar set Descripcion=?, Cantidad=?, Preciounitario=? where Codigo=?");
            
            //pt.setString(1, objAseoBean.getCategoria());
            //pt.setString(2, objAseoBean.getSubcategoria());
            //pt.setString(3, objAseoBean.getMarca());
            pt.setString(1, objElectroBean.getDescripcion());
            pt.setInt(2, objElectroBean.getCantidad());
            pt.setDouble(3, objElectroBean.getPrecio());
           //pt.setLong(7, objAseoBean.getImagen());
            //pt.setString(8, objAseoBean.getRuta());
            pt.setInt(4, objElectroBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int vaciarDatos(ElectroBean objElectroBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from electrohogar");
            
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
}
