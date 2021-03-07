
package Modelo;

import javax.swing.*;

public class pnlCuatro extends JPanel {

    public JLabel jLabel1;
    public JLabel jLabel2;
    public JLabel jLabel3;
    
    public pnlCuatro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jLabel2 = new JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/chat.png"))); // NOI18N
        jLabel1.setText("CONSULTAS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 7, 387, 120));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CONSULTASVIVANDA.jpg"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 145, 674, 403));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoBlanco.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 580));
    }// </editor-fold>                        
                      
}
