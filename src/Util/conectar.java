
package Util;
import java.sql.*;
public class conectar {
    Connection con = null;
    public static void main(String[] args)
    {  
         conectar  obj=new   conectar ();
                               obj.conexion()   ; 
        
        
        
    }
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/bdproductos","root","");
            System.out.println("CONEXION ESTABLECIDA");;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de Conexion");
        }
        return con;
        
    }
         
}
