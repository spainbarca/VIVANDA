
package Vista;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import Modelo.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class VentanaContinuar extends JFrame {

    public RSButtonMetro cinco;
    public RSButtonMetro cuatro;
    public RSButtonMetro dos;
    public JButton jButton1;
    public JLabel jLabel1;
    public JLabel jLabel2;
    public JPanel jPanel1;
    public JPanel jPanel3;
    public JPanel jPanel4;
    public JPanel jPanel5;
    public JPanel pnlMenu;
    public JPanel pnlPrincipal;
    public RSButtonMetro tres;
    public RSButtonMetro uno;
    
    public VentanaContinuar() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.uno.setSelected(true); 
        new CambiaPanel(pnlPrincipal , new pnlUno());
    }
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/Vivandalogo.png"));
    return retValue;
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel3 = new JPanel();
        jButton1 = new JButton();
        pnlMenu = new JPanel();
        jPanel4 = new JPanel();
        jLabel1 = new JLabel();
        jPanel5 = new JPanel();
        jLabel2 = new JLabel();
        dos = new RSButtonMetro();
        uno = new RSButtonMetro();
        tres = new RSButtonMetro();
        cinco = new RSButtonMetro();
        cuatro = new RSButtonMetro();
        pnlPrincipal = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new Color(255, 204, 0));

        jButton1.setBackground(new Color(255, 255, 255));
        jButton1.setIcon(new ImageIcon(getClass().getResource("/iconos/menupeq.png"))); 
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton1,GroupLayout.PREFERRED_SIZE, 64,GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1066, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, GroupLayout.Alignment.TRAILING,GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 60));

        pnlMenu.setBackground(new Color(214, 217, 223));

        jPanel4.setBackground(new Color(214, 217, 223));

        jLabel1.setBackground(new Color(153, 153, 153));
        jLabel1.setFont(new Font("Tahoma", 1, 18)); 
        jLabel1.setForeground(new Color(166, 166, 166));
        jLabel1.setText("PEOPLE");

        jPanel5.setBackground(new java.awt.Color(214, 217, 223));

        jLabel2.setBackground(new Color(153, 153, 153));
        jLabel2.setFont(new Font("Tahoma", 1, 18));
        jLabel2.setForeground(new java.awt.Color(166, 166, 166));
        jLabel2.setText("PEOPLE");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 103, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 59, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 59, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        dos.setBackground(new Color(214, 217, 223));
        dos.setForeground(new Color(166, 166, 166));
        dos.setIcon(new ImageIcon(getClass().getResource("/iconos/collectionpeq.png"))); 
        dos.setText("COLLECTION");
        dos.setColorHover(new Color(204, 204, 204));
        dos.setColorNormal(new Color(214, 217, 223));
        dos.setColorPressed(new Color(204, 204, 204));
        dos.setColorTextHover(new Color(166, 166, 166));
        dos.setColorTextNormal(new Color(166, 166, 166));
        dos.setColorTextPressed(new Color(166, 166, 166));
        dos.setHorizontalAlignment(SwingConstants.LEFT);
        dos.setHorizontalTextPosition(SwingConstants.RIGHT);
        dos.setIconTextGap(25);
        dos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dosMousePressed(evt);
            }
        });
        dos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosActionPerformed(evt);
            }
        });

        uno.setForeground(new Color(166, 166, 166));
        uno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/homepeq.png"))); 
        uno.setText("HOME");
        uno.setColorHover(new Color(204, 204, 204));
        uno.setColorNormal(new Color(204, 204, 204));
        uno.setColorPressed(new Color(204, 204, 204));
        uno.setColorTextHover(new Color(166, 166, 166));
        uno.setColorTextNormal(new Color(166, 166, 166));
        uno.setColorTextPressed(new Color(166, 166, 166));
        uno.setHorizontalAlignment(SwingConstants.LEFT);
        uno.setHorizontalTextPosition(SwingConstants.RIGHT);
        uno.setIconTextGap(25);
        uno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                unoMousePressed(evt);
            }
        });
        uno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unoActionPerformed(evt);
            }
        });

        tres.setBackground(new Color(214, 217, 223));
        tres.setForeground(new Color(166, 166, 166));
        tres.setIcon(new ImageIcon(getClass().getResource("/iconos/feeedbackpeq.png")));
        tres.setText("CONSULTAS");
        tres.setColorHover(new Color(204, 204, 204));
        tres.setColorNormal(new Color(214, 217, 223));
        tres.setColorPressed(new Color(204, 204, 204));
        tres.setColorTextHover(new Color(166, 166, 166));
        tres.setColorTextNormal(new Color(166, 166, 166));
        tres.setColorTextPressed(new Color(166, 166, 166));
        tres.setHorizontalAlignment(SwingConstants.LEFT);
        tres.setHorizontalTextPosition(SwingConstants.RIGHT);
        tres.setIconTextGap(25);
        tres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tresMousePressed(evt);
            }
        });
        tres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tresActionPerformed(evt);
            }
        });

        cinco.setBackground(new Color(214, 217, 223));
        cinco.setForeground(new Color(166, 166, 166));
        cinco.setIcon(new ImageIcon(getClass().getResource("/iconos/marketpeq.png"))); 
        cinco.setText("MARKET");
        cinco.setColorHover(new Color(204, 204, 204));
        cinco.setColorNormal(new Color(214, 217, 223));
        cinco.setColorPressed(new Color(204, 204, 204));
        cinco.setColorTextHover(new Color(166, 166, 166));
        cinco.setColorTextNormal(new Color(166, 166, 166));
        cinco.setColorTextPressed(new Color(166, 166, 166));
        cinco.setHorizontalAlignment(SwingConstants.LEFT);
        cinco.setHorizontalTextPosition(SwingConstants.RIGHT);
        cinco.setIconTextGap(25);
        cinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cincoActionPerformed(evt);
            }
        });

        cuatro.setBackground(new Color(214, 217, 223));
        cuatro.setForeground(new Color(166, 166, 166));
        cuatro.setIcon(new ImageIcon(getClass().getResource("/iconos/chatpeq.png")));
        cuatro.setText("CHAT");
        cuatro.setColorHover(new Color(204, 204, 204));
        cuatro.setColorNormal(new Color(214, 217, 223));
        cuatro.setColorPressed(new Color(204, 204, 204));
        cuatro.setColorTextHover(new Color(166, 166, 166));
        cuatro.setColorTextNormal(new Color(166, 166, 166));
        cuatro.setColorTextPressed(new Color(166, 166, 166));
        cuatro.setHorizontalAlignment(SwingConstants.LEFT);
        cuatro.setHorizontalTextPosition(SwingConstants.RIGHT);
        cuatro.setIconTextGap(25);
        cuatro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cuatroMousePressed(evt);
            }
        });
        cuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuatroActionPerformed(evt);
            }
        });

        GroupLayout pnlMenuLayout = new GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(uno, GroupLayout.PREFERRED_SIZE, 180,GroupLayout.PREFERRED_SIZE)
            .addComponent(dos, GroupLayout.PREFERRED_SIZE, 180,GroupLayout.PREFERRED_SIZE)
            .addComponent(tres, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
            .addComponent(cuatro, GroupLayout.PREFERRED_SIZE, 180,GroupLayout.PREFERRED_SIZE)
            .addComponent(cinco, GroupLayout.PREFERRED_SIZE, 180,GroupLayout.PREFERRED_SIZE)
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(uno, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dos, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tres, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cuatro,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cinco,GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 180, 540));

        pnlPrincipal.setBackground(new Color(255, 255, 255));
        pnlPrincipal.setLayout(new BoxLayout(pnlPrincipal, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 950, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 590));

        pack();
    }// </editor-fold>                        

    private void cuatroActionPerformed(java.awt.event.ActionEvent evt) {                                       
        CambiaPanel cambiaPanel = new CambiaPanel(pnlPrincipal , new pnlCuatro());
        if (this.cuatro.isSelected()){
            this.uno.setColorNormal(new Color(214,217,223));
            this.uno.setColorHover(new Color(204,204,204));
            this.uno.setColorPressed(new Color(214,217,223));
            
            this.dos.setColorNormal(new Color(214,217,223));
            this.dos.setColorHover(new Color(204,204,204));
            this.dos.setColorPressed(new Color(214,217,223));
            
            this.tres.setColorNormal(new Color(214,217,223));
            this.tres.setColorHover(new Color(204,204,204));
            this.tres.setColorPressed(new Color(214,217,223));
            
            this.cuatro.setColorNormal(new Color(204,204,204));
            this.cuatro.setColorHover(new Color(204,204,204));
            this.cuatro.setColorPressed(new Color(204,204,204));
            
            this.cinco.setColorNormal(new Color(214,217,223));
            this.cinco.setColorHover(new Color(204,204,204));
            this.cinco.setColorPressed(new Color(214,217,223));
        } else {
            this.cuatro.setColorNormal(new Color(214,217,223));
            this.cuatro.setColorHover(new Color(204,204,204));
            this.cuatro.setColorPressed(new Color(214,217,223));
        }
        
    }                                      

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        int posicion = this.pnlMenu.getX();
        if (posicion>-1){
            Animacion.Animacion.mover_izquierda(0,-188, 2,2, pnlMenu);
        } else {
            Animacion.Animacion.mover_derecha(-188,0, 2,2, pnlMenu);
        }
    }                                        

    private void unoActionPerformed(java.awt.event.ActionEvent evt) {                                    
        CambiaPanel cambiaPanel = new CambiaPanel(pnlPrincipal , new pnlUno());
        if (this.uno.isSelected()){
            this.uno.setColorNormal(new Color(204,204,204));
            this.uno.setColorHover(new Color(204,204,204));
            this.uno.setColorPressed(new Color(204,204,204));
            
            this.dos.setColorNormal(new Color(214,217,223));
            this.dos.setColorHover(new Color(204,204,204));
            this.dos.setColorPressed(new Color(214,217,223));
            
            this.tres.setColorNormal(new Color(214,217,223));
            this.tres.setColorHover(new Color(204,204,204));
            this.tres.setColorPressed(new Color(214,217,223));
            
            this.cuatro.setColorNormal(new Color(214,217,223));
            this.cuatro.setColorHover(new Color(204,204,204));
            this.cuatro.setColorPressed(new Color(214,217,223));
            
            this.cinco.setColorNormal(new Color(214,217,223));
            this.cinco.setColorHover(new Color(204,204,204));
            this.cinco.setColorPressed(new Color(214,217,223));
        } else {
            this.uno.setColorNormal(new Color(214,217,223));
            this.uno.setColorHover(new Color(204,204,204));
            this.uno.setColorPressed(new Color(214,217,223));
        }
    }                                   

    private void dosActionPerformed(java.awt.event.ActionEvent evt) {                                    
        CambiaPanel cambiaPanel = new CambiaPanel(pnlPrincipal , new pnlDos());
        if (this.dos.isSelected()){
            this.uno.setColorNormal(new Color(214,217,223));
            this.uno.setColorHover(new Color(204,204,204));
            this.uno.setColorPressed(new Color(214,217,223));
            
            this.dos.setColorNormal(new Color(204,204,204));
            this.dos.setColorHover(new Color(204,204,204));
            this.dos.setColorPressed(new Color(204,204,204));
            
            this.tres.setColorNormal(new Color(214,217,223));
            this.tres.setColorHover(new Color(204,204,204));
            this.tres.setColorPressed(new Color(214,217,223));
            
            this.cuatro.setColorNormal(new Color(214,217,223));
            this.cuatro.setColorHover(new Color(204,204,204));
            this.cuatro.setColorPressed(new Color(214,217,223));
            
            this.cinco.setColorNormal(new Color(214,217,223));
            this.cinco.setColorHover(new Color(204,204,204));
            this.cinco.setColorPressed(new Color(214,217,223));
        } else {
            this.dos.setColorNormal(new Color(214,217,223));
            this.dos.setColorHover(new Color(204,204,204));
            this.dos.setColorPressed(new Color(214,217,223));
        }
    }                                   

    private void unoMousePressed(java.awt.event.MouseEvent evt) {                                 
        this.uno.setSelected(true);
         this.dos.setSelected(false);
         this.tres.setSelected(false);
         this.cuatro.setSelected(false);
         this.cinco.setSelected(false);
    }                                

    private void dosMousePressed(java.awt.event.MouseEvent evt) {                                 
        this.uno.setSelected(false);
         this.dos.setSelected(true);
         this.tres.setSelected(false);
         this.cuatro.setSelected(false);
         this.cinco.setSelected(false);
    }                                

    private void tresActionPerformed(java.awt.event.ActionEvent evt) {                                     
        CambiaPanel cambiaPanel = new CambiaPanel(pnlPrincipal , new pnlTres());
        if (this.tres.isSelected()){
            this.uno.setColorNormal(new Color(214,217,223));
            this.uno.setColorHover(new Color(204,204,204));
            this.uno.setColorPressed(new Color(214,217,223));
            
            this.dos.setColorNormal(new Color(214,217,223));
            this.dos.setColorHover(new Color(204,204,204));
            this.dos.setColorPressed(new Color(214,217,223));
            
            this.tres.setColorNormal(new Color(204,204,204));
            this.tres.setColorHover(new Color(204,204,204));
            this.tres.setColorPressed(new Color(204,204,204));
            
            this.cuatro.setColorNormal(new Color(214,217,223));
            this.cuatro.setColorHover(new Color(204,204,204));
            this.cuatro.setColorPressed(new Color(214,217,223));
            
            this.cinco.setColorNormal(new Color(214,217,223));
            this.cinco.setColorHover(new Color(204,204,204));
            this.cinco.setColorPressed(new Color(214,217,223));
        } else {
            this.tres.setColorNormal(new Color(214,217,223));
            this.tres.setColorHover(new Color(204,204,204));
            this.tres.setColorPressed(new Color(214,217,223));
        }
        
    }                                    

    private void tresMousePressed(java.awt.event.MouseEvent evt) {                                  
        this.uno.setSelected(false);
         this.dos.setSelected(false);
         this.tres.setSelected(true);
         this.cuatro.setSelected(false);
         this.cinco.setSelected(false);
    }                                 

    private void cuatroMousePressed(java.awt.event.MouseEvent evt) {                                    
        this.uno.setSelected(false);
         this.dos.setSelected(false);
         this.tres.setSelected(false);
         this.cuatro.setSelected(true);
         this.cinco.setSelected(false);
    }                                   

    private void cincoActionPerformed(java.awt.event.ActionEvent evt) {                                      
        
    }                                     

    public static void main(String args[]) throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaContinuar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaContinuar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaContinuar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaContinuar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
        } catch (ClassNotFoundException ex) {
        };
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaContinuar().setVisible(true);
                
            }
        });
    }                
}
