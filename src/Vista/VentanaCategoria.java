
package Vista;
import javax.swing.*;
import java.awt.*;
import Modelo.RSButtonMetro;
import java.awt.event.ActionEvent;
public class VentanaCategoria extends JFrame {

    JButton btnSalir;
    JButton Carnes;
    JButton Lacteos;
    JButton Despensa;
    JButton Bebidas;
    JButton FrutasVerduras;
    JButton Aseo;
    JButton Panaderia;
    JButton Golosinas;
    JButton Electrohogar;
    JButton Limpieza;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel5;
    RSButtonMetro rSButtonMetro1;
    
    public VentanaCategoria() {
        initComponents();
        this.setTitle("Ventana de Categorías"); 
    }

 
    public void initComponents() {

        btnSalir = new JButton();
        rSButtonMetro1 = new RSButtonMetro();
        jLabel3 = new JLabel();
        jLabel5 = new JLabel();
        jLabel2 = new JLabel();
        Carnes = new JButton();
        Lacteos = new JButton();
        Despensa = new JButton();
        Bebidas = new JButton();
        FrutasVerduras = new JButton();
        Aseo = new JButton();
        Panaderia = new JButton();
        Golosinas = new JButton();
        Electrohogar = new JButton();
        Limpieza = new JButton();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new Color(172, 7, 7));
        btnSalir.setFont(new Font("Tahoma", 1, 18));
        btnSalir.setForeground(new Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirAP(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 0, 100, 40));

        rSButtonMetro1.setBackground(new Color(255, 255, 255));
        rSButtonMetro1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/botonRegresarPeqeuño.png")));
        rSButtonMetro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro1AP(evt);
            }
        });
        getContentPane().add(rSButtonMetro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 80));

        jLabel3.setFont(new Font("Tahoma", 1, 36)); 
        jLabel3.setForeground(new Color(123, 123, 3));
        jLabel3.setText("Categoría");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 190, 80));

        jLabel5.setIcon(new ImageIcon(getClass().getResource("/Iconos/100px-printed-paper.png"))); 
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 130, 130));

        jLabel2.setIcon(new ImageIcon(getClass().getResource("/Iconos/banner14.png"))); 
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 380, 130));

        Carnes.setFont(new Font("Tahoma", 1, 30)); 
        Carnes.setIcon(new ImageIcon(getClass().getResource("/Iconos/pescados.png"))); 
        Carnes.setText("Carnes y Pescados");
        Carnes.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        Carnes.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CarnesAP(evt);
            }
        });
        
        getContentPane().add(Carnes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 460, 90));

        Lacteos.setFont(new Font("Tahoma", 1, 30)); 
        Lacteos.setIcon(new ImageIcon(getClass().getResource("/Iconos/Lacteo.png"))); 
        Lacteos.setText("  Lácteos");
        Lacteos.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        Lacteos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LacteosAP(evt);
            }
        });
        getContentPane().add(Lacteos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 460, 90));

        Despensa.setFont(new Font("Tahoma", 1, 30)); 
        Despensa.setIcon(new ImageIcon(getClass().getResource("/Iconos/despensaa.png"))); 
        Despensa.setText("  Despensa");
        Despensa.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        Despensa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DespensaAP(evt);
            }
        });
        
        getContentPane().add(Despensa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 460, 90));

        Bebidas.setFont(new Font("Tahoma", 1, 30)); 
        Bebidas.setIcon(new ImageIcon(getClass().getResource("/Iconos/Bebidas.png"))); 
        Bebidas.setText("Bebidas y Licores");
        Bebidas.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        Bebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BebidasAP(evt);
            }
        });
        
        getContentPane().add(Bebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 460, 90));

        FrutasVerduras.setFont(new Font("Tahoma", 1, 30));
        FrutasVerduras.setIcon(new ImageIcon(getClass().getResource("/Iconos/frutas.png")));
        FrutasVerduras.setText("Frutas y Verduras");
        FrutasVerduras.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        FrutasVerduras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FrutasVerdurasAP(evt);
            }
        });
        getContentPane().add(FrutasVerduras, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 610, 460, 90));

        Aseo.setFont(new Font("Tahoma", 1, 30)); 
        Aseo.setIcon(new ImageIcon(getClass().getResource("/Iconos/aseoPersonal.png")));
        Aseo.setText("  Aseo Personal");
        Aseo.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        Aseo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AseoAP(evt);
            }
        });
        getContentPane().add(Aseo, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, 510, 90));

        Panaderia.setFont(new Font("Tahoma", 1, 30)); 
        Panaderia.setIcon(new ImageIcon(getClass().getResource("/Iconos/panaderia.png"))); 
        Panaderia.setText(" Panadería y Pastelería");
        Panaderia.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        Panaderia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PanaderiaAP(evt);
            }
        });
        getContentPane().add(Panaderia, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, 510, 100));

        Golosinas.setFont(new Font("Tahoma", 1, 30)); 
        Golosinas.setIcon(new ImageIcon(getClass().getResource("/Iconos/Golosinas.png"))); 
        Golosinas.setText("  Golosinas");
        Golosinas.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        Golosinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                GolosinasAP(evt);
            }
        });
        getContentPane().add(Golosinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 390, 510, 90));

        Electrohogar.setFont(new Font("Tahoma", 1, 30)); 
        Electrohogar.setIcon(new ImageIcon(getClass().getResource("/Iconos/Electrodomesticos.png"))); 
        Electrohogar.setText("ElectroHogar");
        Electrohogar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        Electrohogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ElectrohogarAP(evt);
            }
        });
        getContentPane().add(Electrohogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 500, 510, 90));

        Limpieza.setFont(new Font("Tahoma", 1, 30)); 
        Limpieza.setIcon(new ImageIcon(getClass().getResource("/Iconos/escoba.png"))); 
        Limpieza.setText("  Limpieza Doméstica");
        Limpieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LimpiezaAP(evt);
            }
        });
        Limpieza.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        
        getContentPane().add(Limpieza, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 610, 510, 90));

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fondoBlanco.jpg"))); 
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 730));

        pack();
    }                       

    private void btnSalirAP(ActionEvent evt) {                                         
        System.exit(0);
    }                                        

    private void rSButtonMetro1AP(ActionEvent evt) {                                               
        VentanaContinuar objeto=new VentanaContinuar();
        objeto.setVisible(true);
        this.dispose();
    }                                              

    private void CarnesAP(ActionEvent evt) {                                         
        VentanaCarnes Ca = new VentanaCarnes();
        Ca.setVisible(true);
      this.dispose();
    }                                        

    private void LacteosAP(ActionEvent evt) {                                          
        VentanaLacteos La = new VentanaLacteos();
        La.setVisible(true);
      this.dispose();
    }
    
    private void DespensaAP(ActionEvent evt) {                                          
        VentanaDespensa De = new VentanaDespensa();
        De.setVisible(true);
      this.dispose();
    } 
    
    private void BebidasAP(ActionEvent evt) {                                          
        VentanaBebidas Be = new VentanaBebidas();
        Be.setVisible(true);
      this.dispose();
    } 
    
    private void FrutasVerdurasAP(ActionEvent evt) {                                          
        VentanaFrutas Fru = new VentanaFrutas();
        Fru.setVisible(true);
      this.dispose();
    } 
    
    private void AseoAP(ActionEvent evt) {                                          
      VentanaAseo As = new VentanaAseo();
        As.setVisible(true);
      this.dispose();
    } 
    
    
    private void PanaderiaAP(ActionEvent evt) {                                          
        VentanaPan Pan = new VentanaPan();
        Pan.setVisible(true);
      this.dispose();
    } 
    
    private void GolosinasAP(ActionEvent evt) {                                          
        VentanaGolosina Go = new VentanaGolosina();
        Go.setVisible(true);
      this.dispose();
    }                                         

    private void ElectrohogarAP(ActionEvent evt) {                                         
        VentanaElectro El = new VentanaElectro();
        El.setVisible(true);
      this.dispose();
    }                                        

    private void LimpiezaAP(ActionEvent evt) {                                         
        VentanaLimpieza Lim = new VentanaLimpieza();
        Lim.setVisible(true);
      this.dispose();
    }                                        

    public static void main(String args[]) {
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCategoria().setVisible(true);
            }
        });
    }
                  
}
