package Vista;
import Modelo.UsuarioOperaciones;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import Util.conectar;
import Controlador.ControladorIngresar;
import Modelo.UsuarioBean;
import java.awt.*;

public class Interfaz extends javax.swing.JFrame {
    UsuarioBean objUsuarioBean;
    ControladorIngresar objControladorIngresar;
    public JPasswordField contraseña;
    public JButton btnSalir;
    public JButton btnRegistrar;
    public JButton btnLimpiar;
    public JButton btnIngresar;
    public JLabel jLabel1;
    public JLabel jLabel2;
    public JLabel jLabel3;
    public JLabel jLabel4;
    public JTextField usuario;
    UsuarioOperaciones   objoperaciones=new UsuarioOperaciones();
    
    public Interfaz() {
        initComponents();
        objControladorIngresar= new ControladorIngresar(this);
        this.setLocationRelativeTo(null);
    }
    
    public void Entrar(){
        boolean estado, estadoCampo;
        objUsuarioBean=new UsuarioBean();
        objUsuarioBean.setUsuarioo(usuario.getText());
        objUsuarioBean.setClavee(contraseña.getText());
        estadoCampo=objControladorIngresar.ValidarCampos();
        estado = objControladorIngresar.ValidarUsuarioControlador(objUsuarioBean);
        if(estado==true && estadoCampo==true)
    {
        Bienvenido objBienvenido = new Bienvenido();
        objBienvenido.setVisible(true);
        this.dispose();
    } else if(estado!=true && estadoCampo==true)
    {
        JOptionPane.showMessageDialog(null,"Usuario y/o clave Incorrecto!!!!!");       
        usuario.setText("");
        contraseña.setText("");
        usuario.requestFocus();   
    } 
    }
     public void Grabar(){
        boolean estadoCampo;
        estadoCampo=objControladorIngresar.ValidarCampos();
        objUsuarioBean= new UsuarioBean();
        if (estadoCampo){
        objUsuarioBean.setUsuarioo(usuario.getText());
        objUsuarioBean.setClavee(contraseña.getText());
        objControladorIngresar.GrabarUsuario(objUsuarioBean);
        }
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/Vivandalogo.png"));
    return retValue;
    }
                       
    private void initComponents() {

        btnSalir = new JButton();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        usuario = new JTextField();
        contraseña = new JPasswordField();
        btnIngresar = new JButton();
        btnRegistrar = new JButton();
        btnLimpiar = new JButton();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new Color(0, 0, 51));
        btnSalir.setFont(new Font("Tahoma", 1, 14)); 
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnSalirActionPerformed(evt);
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, -1));

        jLabel2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/iconoazul.png"))); 
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 190, 190));

        jLabel3.setFont(new Font("Tahoma", 1, 18)); 
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setText("Usuario :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        jLabel4.setFont(new Font("Tahoma", 1, 18)); 
        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setText("Password :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        
        
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 160, -1));

        contraseña.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        contraseña.addActionListener(this::contraseñaActionPerformed);
        
        getContentPane().add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 160, -1));

        btnIngresar.setBackground(new Color(153, 51, 0));
        btnIngresar.setFont(new Font("Tahoma", 1, 14));
        btnIngresar.setForeground(new Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(this::btnIngresarActionPerformed);
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 100, 40));

        btnRegistrar.setBackground(new Color(153, 51, 0));
        btnRegistrar.setFont(new Font("Tahoma", 1, 14)); 
        btnRegistrar.setForeground(new Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(this::btnRegistrarActionPerformed);
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 110, 40));

        btnLimpiar.setBackground(new Color(153, 51, 0));
        btnLimpiar.setFont(new Font("Tahoma", 1, 14)); 
        btnLimpiar.setForeground(new Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 110, 40));

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fondoazul.jpg"))); 
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-12, -57, 450, 520));

        pack();
    }// </editor-fold>                        

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(0);
    }                                        

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {                                              
     
        Entrar();
    }                                             
         
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        usuario.setText("");
        contraseña.setText("");
    }                                        

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        Grabar();
    }               
    
    private void contraseñaActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
    }                                          

    @SuppressWarnings("empty-statement")
    public static void main(String args[]) throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
    
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
        } catch (ClassNotFoundException ex) {
        };
        java.awt.EventQueue.invokeLater(() -> {
            new Interfaz().setVisible(true);
        });
    }                                    
}
