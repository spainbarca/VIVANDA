package Modelo;

import Vista.VentanaCategoria;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class pnlUno extends JPanel {

                    
    JButton btnCategoria;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    VentanaCategoria objCategoria = new VentanaCategoria();
    
    public pnlUno() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCategoria = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home.png"))); // NOI18N
        jLabel1.setText("HOME");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIconTextGap(20);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 262, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vivandaPantalla.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 120, 633, 329));

        btnCategoria.setBackground(new java.awt.Color(153, 153, 0));
        btnCategoria.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnCategoria.setText("Ir a Seleccion x Categoría");
        btnCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCategoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCategoriaAP(evt);
            }
        });
        add(btnCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 300, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoBlanco.jpg"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 510));
    }// </editor-fold>                        

    private void btnCategoriaAP(ActionEvent evt) {                                             
         
        objCategoria.setVisible(true);
        // Este codigo sirve para Cerrar un panel , ya que con el "this.dispose" solo se pueden
        // cerrar jframe y este es un panel, es por ello que se usa el siguiente codigo :D
        Window w = SwingUtilities.getWindowAncestor(pnlUno.this);
       w.setVisible(false); 
    }                                            
                      
}
