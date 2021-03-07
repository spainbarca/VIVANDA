package Modelo;

    import Vista.VentanaContinuarAlimentos;
    import javax.swing.*;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import java.sql.*;
    import java.io.*; 

public class ProductosDAO {
    VentanaContinuarAlimentos objVentanaAlimentos;
    ProductosBean objProductosBean=null;
    public ProductosDAO(VentanaContinuarAlimentos objVentanaAlimentos){
        this.objVentanaAlimentos=objVentanaAlimentos;
    }

    public void tablaDatos(){
        Connection conectar=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://localhost/bdproductos","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentanaContinuarAlimentos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaContinuarAlimentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String z = null;
                String elecc=objVentanaAlimentos.ComboBoxCategoria.getSelectedItem().toString();
           if (elecc.equals("Frutas y verduras")){
                       z="Frutas_y_verduras";
             } else if(elecc.equals("Bebidas y licores")){
                       z="Bebidas_y_licores";
           }else if(elecc.equals("Electrohogar")){
                       z="Electrohogar";
          }else if(elecc.equals("Limpieza domestica")){
                       z="Limpieza_domestica";
           }else if(elecc.equals("Golosinas")){
                       z="Golosinas";
          }else if(elecc.equals("Lacteos")){
                       z="Lacteos";
         }else if(elecc.equals("Despensa")){
                       z="Despensa";
          }else if(elecc.equals("Carnes y pescados")){
                       z="Carnes_y_pescados";
          }else if(elecc.equals("Panaderia y pasteleria")){
                       z="Panaderia_y_pasteleria";
            }else if(elecc.equals("Aseo personal")){
                       z="Aseo_personal";
             }
        String datos[]=new String[9];
    double PrecioT[]=new double[1];
        try {
            Statement st=conectar.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM "+z);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                datos[7]=rs.getString(9);
            }
            PrecioT[0]=Double.parseDouble(objVentanaAlimentos.txtCantidad.getText())*Double.parseDouble(objVentanaAlimentos.txtPrecio.getText());
                objVentanaAlimentos.modelo.addRow(new Object[] {datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],PrecioT[0],datos[7],datos[8]});
        } catch (SQLException ex) {
            Logger.getLogger(VentanaContinuarAlimentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LimpiarDatos(){
        objVentanaAlimentos.txtCantidad.setText("");
        objVentanaAlimentos.txtCodigo.setText("");
        objVentanaAlimentos.txtDescripcion.setText("");
        objVentanaAlimentos.txtImagen.setText("");
        objVentanaAlimentos.txtPrecio.setText("");
        objVentanaAlimentos.ComboBoxCategoria.setSelectedItem("Seleccionar...");
        objVentanaAlimentos.ComboBoxSubcategoria.setSelectedItem("Seleccionar...");
        objVentanaAlimentos.ComboBoxMarca.setSelectedItem("Seleccionar...");
        objVentanaAlimentos.ComboBoxUser.setSelectedItem("noe");
    }
    
    public final void cargarCategoria(){
        String Catego[]={"Seleccionar...","Aseo personal","Bebidas y licores","Carnes y pescados","Despensa","Electrohogar","Frutas y verduras",
           "Golosinas", "Lacteos","Limpieza domestica","Panaderia y pasteleria"};
        objVentanaAlimentos.modeloCategoria =new DefaultComboBoxModel(Catego);
        objVentanaAlimentos.ComboBoxCategoria.setModel(objVentanaAlimentos.modeloCategoria);
    }
    
    public int Agregar(ProductosBean objProductosBean){
        this.objProductosBean=objProductosBean;
        int estadoRegistro=0;
//        boolean num=objVentanaAlimentos.objeto.Validando(objVentanaAlimentos.txtCodigo.getText());
//        boolean num1=objVentanaAlimentos.objeto.Validando(objVentanaAlimentos.txtCantidad.getText());
//        boolean num2=objVentanaAlimentos.objeto2.Validando(objVentanaAlimentos.txtPrecio.getText());
//        if (objVentanaAlimentos.txtCodigo.getText().length()==0  || objVentanaAlimentos.txtCantidad.getText().length()==0 || objVentanaAlimentos.txtImagen.getText().length()==0
//          || objVentanaAlimentos.txtPrecio.getText().length()==0 || objVentanaAlimentos.txtDescripcion.getText().length()==0 || objVentanaAlimentos.ComboBoxCategoria.getSelectedItem().equals("Seleccionar...")
//                || objVentanaAlimentos.ComboBoxSubcategoria.getSelectedItem().equals("Seleccionar...") || objVentanaAlimentos.ComboBoxMarca.getSelectedItem().equals("Seleccionar...")){
//            JOptionPane.showMessageDialog(null,"Complete los campos vacíos");
//            estadoRegistro=0;
//        } else {
//            if (num!=true /*|| num1!=true || num2!=true*/){
//                JOptionPane.showMessageDialog(null,"Ingrese solo numeros Enteros en el CODIGO");
//                estadoRegistro=0;
//            }else {
//                if (num1!=true){
//                    JOptionPane.showMessageDialog(null,"Ingrese solo numeros Enteros en la CANTIDAD");
//                    estadoRegistro=0;
//                } else{
//                    if(num2!=true){
//                        JOptionPane.showMessageDialog(null,"Ingrese solo numeros en el PRECIO");
//                        estadoRegistro=0;
//                    }
//                    else {
                try {
                Connection conectar=null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conectar=DriverManager.getConnection("jdbc:mysql://localhost/bdproductos","root","");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(VentanaContinuarAlimentos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex){
                    Logger.getLogger(VentanaContinuarAlimentos.class.getName()).log(Level.SEVERE, null, ex);
                }
                String z = null;
                String elecc=objVentanaAlimentos.ComboBoxCategoria.getSelectedItem().toString();
           if (elecc.equals("Frutas y verduras")){
                       z="Frutas_y_verduras";
             } else if(elecc.equals("Bebidas y licores")){
                       z="Bebidas_y_licores";
           }else if(elecc.equals("Electrohogar")){
                       z="Electrohogar";
          }else if(elecc.equals("Limpieza domestica")){
                       z="Limpieza_domestica";
           }else if(elecc.equals("Golosinas")){
                       z="Golosinas";
          }else if(elecc.equals("Lacteos")){
                       z="Lacteos";
         }else if(elecc.equals("Despensa")){
                       z="Despensa";
          }else if(elecc.equals("Carnes y pescados")){
                       z="Carnes_y_pescados";
          }else if(elecc.equals("Panaderia y pasteleria")){
                       z="Panaderia_y_pasteleria";
            }else if(elecc.equals("Aseo personal")){
                       z="Aseo_personal";
             }
                String insertar="INSERT INTO "+z+"(Codigo, Categoria, Subcategoria, Marca, Descripcion, Cantidad, Preciounitario, Nombre, pers_nombre) VALUES(?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst=conectar.prepareStatement(insertar);
                pst.setString(1,objVentanaAlimentos.txtCodigo.getText());
                pst.setString(2,objVentanaAlimentos.ComboBoxCategoria.getSelectedItem().toString());
                pst.setString(3,objVentanaAlimentos.ComboBoxSubcategoria.getSelectedItem().toString());
                pst.setString(4,objVentanaAlimentos.ComboBoxMarca.getSelectedItem().toString());
                pst.setString(5,objVentanaAlimentos.txtDescripcion.getText());
                pst.setInt(6,Integer.parseInt(objVentanaAlimentos.txtCantidad.getText()));
                pst.setDouble(7,Double.parseDouble(objVentanaAlimentos.txtPrecio.getText()));
                    pst.setString(8,objVentanaAlimentos.txtNombre.getText());
                    pst.setString(9, objVentanaAlimentos.ComboBoxUser.getSelectedItem().toString());
                    FileInputStream archivoFoto;
                    archivoFoto=new FileInputStream(objVentanaAlimentos.txtImagen.getText());
                    //pst.setBinaryStream(8, archivoFoto);
                    //pst.setString(9,txtImagen.getText());
                     estadoRegistro = pst.executeUpdate();
                    if(estadoRegistro>0){
                        JOptionPane.showMessageDialog(null,"Se ha guardado Correctamente");
                        tablaDatos();
                        
                        
                    }else{
                        JOptionPane.showMessageDialog(null,"Ha ocurrido un error , no se han guardado los datos!!!");
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaContinuarAlimentos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(VentanaContinuarAlimentos.class.getName()).log(Level.SEVERE, null, ex);
                }  
                
                LimpiarDatos();
        return estadoRegistro;
        
}

    
    
    public void ImagenNombre(){
        JFileChooser archivo=new JFileChooser("D:\\VIVANDA\\src\\Productos");
        int ventana=archivo.showOpenDialog(null);
        if (ventana==JFileChooser.APPROVE_OPTION){
            File file=archivo.getSelectedFile();
            objVentanaAlimentos.txtImagen.setText(String.valueOf(file));
            String NombreArchivo=archivo.getSelectedFile().getName();
            objVentanaAlimentos.txtNombre.setText(NombreArchivo);
           /*Image foto=getToolkit().getImage(txtImagen.getText());
           btnImagen.setIcon(new ImageIcon(foto));*/ //Este codigo sirve para que la imagen que se selecciona
           //se guarde en el panel, para ello se tendria que cambiar el BOTON de AÑADIR IMAGEN , a un PANEL!!!
        }
    }
}
