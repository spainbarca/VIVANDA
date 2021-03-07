package Vista;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
public class Bienvenido extends JFrame {

    public JButton btnContinuar;
    public JLabel jLabel1;
    public JLabel jLabel2;
    public JLabel jLabel3;
    
    public Bienvenido() {
        initComponents();
        setLocationRelativeTo(null);
    }
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/Vivandalogo.png"));
    return retValue;
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        btnContinuar = new JButton();
        jLabel1 = new JLabel();

        
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new Color(255, 255, 255));
        jLabel2.setFont(new Font("Tahoma", 1, 36)); 
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("BIENVENIDO A \"VIVANDA\"");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 500, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Vivandagif.gif"))); 
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 680, 390));

        btnContinuar.setBackground(new Color(102, 51, 0));
        btnContinuar.setFont(new Font("Tahoma", 1, 18));
        btnContinuar.setForeground(new java.awt.Color(255, 255, 255));
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 130, 50));

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg")));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 510));

        pack();
    }                    

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        VentanaContinuar C = new VentanaContinuar();
        C.setVisible(true);
        this.dispose();
    }                                        

    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bienvenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bienvenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bienvenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bienvenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bienvenido().setVisible(true);
            }
        });
    }                 
}
