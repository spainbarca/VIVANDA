package Modelo;

    import java.sql.*;
    import Util.*;
    import java.util.*;

public class ConsultarCarnes {
    ArrayList<CarnesBean> lista=null;
    CarnesBean objCarnesBean=null;
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    
    public ArrayList<CarnesBean> ConsultarCarnes(){
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("select * from carnes_y_pescados");
            //pt.setString(1, objDistritoBean.getNombdistri());
            rs= pt.executeQuery();
            lista=new ArrayList<CarnesBean>();
            while(rs.next()){
                objCarnesBean=new CarnesBean();
                objCarnesBean.setCodigo(rs.getInt(1));
                objCarnesBean.setCategoria(rs.getString(2));
                objCarnesBean.setSubcategoria(rs.getString(3));
                objCarnesBean.setMarca(rs.getString(4));
                objCarnesBean.setDescripcion(rs.getString(5));
                objCarnesBean.setCantidad(rs.getInt(6));
                objCarnesBean.setPrecio(rs.getDouble(7));
                objCarnesBean.setNombre(rs.getString(8));
                
                lista.add(objCarnesBean);
            }
            pt.close();
            rs.close();
            cn.close();
        }catch(Exception e){
        }
        return lista;
    }
    
    public int guardarDatos(CarnesBean objCarnesBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("insert into carnes_y_pescados values(?,?,?,?,?,?,?,?)");
            pt.setInt(1, objCarnesBean.getCodigo());
            pt.setString(2, objCarnesBean.getCategoria());
            pt.setString(3, objCarnesBean.getSubcategoria());
            pt.setString(4, objCarnesBean.getMarca());
            pt.setString(5, objCarnesBean.getDescripcion());
            pt.setInt(6, objCarnesBean.getCantidad());
            pt.setDouble(7, objCarnesBean.getPrecio());
            pt.setString(8, objCarnesBean.getNombre());
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
    
    public int eliminarDatos(CarnesBean objCarnesBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from carnes_y_pescados where Codigo=?");
            pt.setInt(1, objCarnesBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int modificarDatos(CarnesBean objCarnesBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("update carnes_y_pescados set Descripcion=?, Cantidad=?, Preciounitario=? where Codigo=?");
            
            //pt.setString(1, objAseoBean.getCategoria());
            //pt.setString(2, objAseoBean.getSubcategoria());
            //pt.setString(3, objAseoBean.getMarca());
            pt.setString(1, objCarnesBean.getDescripcion());
            pt.setInt(2, objCarnesBean.getCantidad());
            pt.setDouble(3, objCarnesBean.getPrecio());
           //pt.setLong(7, objAseoBean.getImagen());
            //pt.setString(8, objAseoBean.getRuta());
            pt.setInt(4, objCarnesBean.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
    public int vaciarDatos(CarnesBean objCarnesBean){
        int i=0;
        try{
            conectar objC=new conectar();
            cn=objC.conexion();
            pt= cn.prepareStatement("delete from carnes_y_pescados");
            
            i=pt.executeUpdate();
            pt.close();
            cn.close();      
        }catch(Exception e){
            i=0;
        }
        return i;
    }
    
}
